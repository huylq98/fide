package fide.service;

import java.util.List;

import fide.entity.Match;
import fide.entity.Player;

public interface MatchService {
	List<Match> getMatchesByRound(String round);

	Match createOrUpdateMatch(Match match);
	
	boolean isPaired(Player player1, Player player2);
}
