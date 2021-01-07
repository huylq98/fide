package fide.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fide.entity.Match;
import fide.repository.MatchRepository;
import fide.service.MatchService;

@Service
public class MatchServiceImpl implements MatchService {
	
	@Autowired
	private MatchRepository matchRepo;

	@Override
	public List<Match> getAllMatches() {
		return matchRepo.findAll();
	}

	@Override
	public Match getMatchById(Integer id) {
		return matchRepo.getOne(id);
	}

	@Override
	public Match createOrUpdateMatch(Match match) {
		return matchRepo.save(match);
	}

	@Override
	public Integer deleteMatchById(Integer id) {
		matchRepo.deleteById(id);
		return id;
	}

}
