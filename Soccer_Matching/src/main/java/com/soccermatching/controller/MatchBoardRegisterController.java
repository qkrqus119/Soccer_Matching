package com.soccermatching.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.soccermatching.dao.MatchBoardDAO;
import com.soccermatching.dto.MatchBoardDTO;

@Controller
@RequestMapping("/match-register")
public class MatchBoardRegisterController {
	
	@Autowired
	private MatchBoardDAO matchBoardDAO;
	
	@GetMapping
	public String get() {
		return "match_register";
	}
	
	@PostMapping
	public String register(MatchBoardDTO matchBoardDTO, RedirectAttributes redirectAttributes) {
		matchBoardDAO.create(matchBoardDTO);
		
		redirectAttributes.addFlashAttribute("msg", 1);
		
		return "redirect:main";
	}

}
