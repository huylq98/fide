package fide.service;

import java.util.List;
import fide.entity.Match;
import fide.entity.Player;

public interface LeaguePlayerService {

	List<Player> getRankingTable(Integer leagueId, String round);

	List<Match> pairMatches(List<Player> players, String round);

	void updateMatchResult(Player player1, Player player2, Double result);
}
