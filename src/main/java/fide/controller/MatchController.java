package fide.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fide.entity.Match;
import fide.service.MatchService;

@RestController
@RequestMapping("/matches")
public class MatchController {
	@Autowired
	private MatchService matchService;;

	@GetMapping
	public ResponseEntity<List<Match>> getAllMatches() {
		List<Match> matches = matchService.getAllMatches();
		return new ResponseEntity<List<Match>>(matches, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Match> getMatchById(@PathVariable("id") Integer id) throws Exception {
		Match match = matchService.getMatchById(id);
		return new ResponseEntity<>(match, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Match> createOrUpdateMatch(Match match) {
		Match updatedMatch = matchService.createOrUpdateMatch(match);
		return new ResponseEntity<Match>(updatedMatch, new HttpHeaders(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public HttpStatus deleteMatchById(@PathVariable("id") Integer id) {
		matchService.deleteMatchById(id);
		return HttpStatus.FORBIDDEN;
	}
}
