package com.soccermatching.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.soccermatching.dao.MemberDAO;
import com.soccermatching.dao.MemberDAOImpl;
import com.soccermatching.dto.MemberDTO;

@Controller
@RequestMapping("/register")
public class MemberRegisterController {

	@Autowired
	private MemberDAO memberDAO;

	@GetMapping
	public String get() {
		return "member_register";
	}

	@PostMapping
	public String register(MemberDTO memberDTO, RedirectAttributes redirectAttributes) {
		memberDAO.create(memberDTO);
		
		redirectAttributes.addFlashAttribute("msg", 1);

		return "redirect:/index";
	}

}
