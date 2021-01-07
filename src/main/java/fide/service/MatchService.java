package fide.service;

import java.util.List;

import fide.entity.Match;

public interface MatchService {
	public List<Match> getAllMatches();
	public Match getMatchById(Integer id) throws Exception;
	public Match createOrUpdateMatch(Match match);
	public Integer deleteMatchById(Integer id);
}
