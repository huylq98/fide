package fide.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
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
	public Match getMatchById(Integer id) throws Exception {
		Optional<Match> match = matchRepo.findById(id);
		if(match.isPresent()) {
			return match.get();
		} else {
			throw new Exception("No record found.");
		}
	}

	@Override
	public Match createOrUpdateMatch(Match oldMatch) {
		Optional<Match> match = matchRepo.findById(oldMatch.getId());
		if(match.isPresent()) {
			Match newMatch = match.get();
			BeanUtils.copyProperties(oldMatch, oldMatch);
			return matchRepo.save(newMatch);
		} else {
			return matchRepo.save(oldMatch);
		}
	}

	@Override
	public Integer deleteMatchById(Integer id) {
		matchRepo.deleteById(id);
		return id;
	}

}
