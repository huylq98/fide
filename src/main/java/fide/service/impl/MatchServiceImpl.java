package fide.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fide.entity.Match;
import fide.entity.Player;
import fide.repository.MatchRepository;
import fide.service.MatchService;

@Service
public class MatchServiceImpl implements MatchService {

	@Autowired
	private MatchRepository matchRepo;

	@Override
	public List<Match> getMatchesByRound(String round) {
		return matchRepo.findAll().stream().filter(match -> match.getRound().equals(round))
				.collect(Collectors.toList());
	}

	@Override
	public Match createOrUpdateMatch(Match match) {
		return matchRepo.save(match);
	}

	@Override
	public boolean isPaired(Player firstPlayer, Player secondPlayer) {
		Match match = matchRepo.findByFirstPlayerAndSecondPlayer(firstPlayer, secondPlayer);
		return match != null;
	}
}
