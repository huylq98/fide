package fide.service.impl;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fide.entity.LeaguePlayer;
import fide.entity.Match;
import fide.entity.Player;
import fide.repository.LeaguePlayerRepository;
import fide.repository.LeagueRepository;
import fide.service.LeaguePlayerService;
import fide.service.PlayerService;
import fide.utils.Constant;

@Service
public class LeaguePlayerServiceImpl implements LeaguePlayerService {

	@Autowired
	private LeagueRepository leagueRepo;

	@Autowired
	private PlayerService playerService;

	@Autowired
	private LeaguePlayerRepository leaguePlayerRepo;

	@Override
	public List<Player> getRankingTable(Integer leagueId, String round) {
		List<Player> players = playerService.getAllPlayerInLeague(leagueRepo.findById(leagueId).get());
		// Nếu là ván thứ nhất thì sắp xếp theo hệ số Elo
		if (Constant.FIRST_ROUND.equals(round)) {
			players.sort(new Comparator<Player>() {
				@Override
				public int compare(Player p1, Player p2) {
					Double diff = p1.getEloRating() - p2.getEloRating();
					if (diff < 0)
						return 1;
					else if (diff > 0)
						return -1;
					else
						return 0;
				}
			});
			return players;
		}
		return null;
	}

	@Override
	public List<Match> pairMatches(List<Player> players, String round) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMatchResult(Player player1, Player player2, Double result) {
		LeaguePlayer leaguePlayer1 = leaguePlayerRepo.findByPlayerId(player1.getId());
		LeaguePlayer leaguePlayer2 = leaguePlayerRepo.findByPlayerId(player2.getId());
		
		Double eloA = player1.getEloRating();
		Double eloB = player2.getEloRating();

		Double qA = Math.pow(10, eloA / 400d);
		Double qB = Math.pow(10, eloB / 400d);

		Double eA = qA / (qA + qB);
		Double eB = 1 - eA;

		if (result == Constant.WON) {
			player1.setEloRating(eloA + getK(player1) * (Constant.WON - eA));
			player2.setEloRating(eloB + getK(player2) * (Constant.LOST - eB));
			leaguePlayer1.setTotalPoint(leaguePlayer1.getTotalPoint() + result);
		} else if (result == Constant.LOST) {
			player1.setEloRating(eloA + getK(player1) * (Constant.LOST - eA));
			player2.setEloRating(eloB + getK(player2) * (Constant.WON - eB));
			leaguePlayer2.setTotalPoint(leaguePlayer2.getTotalPoint() + result);
		} else if (result == Constant.DRAW) {
			player1.setEloRating(eloA + getK(player1) * (Constant.DRAW - eA));
			player2.setEloRating(eloB + getK(player2) * (Constant.DRAW - eB));
			leaguePlayer1.setTotalPoint(leaguePlayer1.getTotalPoint() + result);
			leaguePlayer2.setTotalPoint(leaguePlayer2.getTotalPoint() + result);
		}
		
		playerService.saveOrCreatePlayer(player1);
		playerService.saveOrCreatePlayer(player2);
		leaguePlayerRepo.save(leaguePlayer1);
		leaguePlayerRepo.save(leaguePlayer2);
	}

	public Double getK(Player player) {
		Double elo = player.getEloRating();
		if (elo <= 1600)
			return 25d;
		else if (elo <= 2000)
			return 20d;
		else if (elo <= 2400)
			return 15d;
		else
			return 10d;
	}
}
