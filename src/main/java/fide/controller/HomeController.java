package fide.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		return "home";
	}
	
	@GetMapping("/pair-match")
	public String pairMatch(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		return "pair-match";
	}
}
