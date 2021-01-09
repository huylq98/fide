package fide.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fide.entity.Player;
import fide.service.LeaguePlayerService;
import fide.utils.Constant;

@RestController
@RequestMapping("/league")
public class LeagueController {

	@Autowired
	private LeaguePlayerService leaguePlayerService;

	@GetMapping
	public List<Player> getRankingTable() {
		return leaguePlayerService.getRankingTable(1, Constant.FIRST_ROUND);
	}
}
