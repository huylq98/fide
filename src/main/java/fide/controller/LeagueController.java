package fide.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import fide.service.LeaguePlayerService;
import fide.utils.Constant;

@Controller
public class LeagueController {

	@Autowired
	private LeaguePlayerService leaguePlayerService;

	@GetMapping("/ranking-table")
	public String getRankingTable(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("players", leaguePlayerService.getRankingTable(1, Constant.FIRST_ROUND));
		return "ranking-table";
	}
}
