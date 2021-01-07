package fide.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fide.entity.Match;
import fide.service.MatchService;

@RestController
public class MatchController {
	@Autowired
	private MatchService matchService;;

	@GetMapping("/matches")
	public List<Match> getAllMatches() {
		return matchService.getAllMatches();
	}
}
