package com.soccermatching.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String register(MemberDTO memberDTO) {
		int gender = memberDTO.getGender();
		gender = (gender > 1 || gender < 0) ? 0 : gender;
		
		memberDTO.setGender(gender);

		memberDAO.create(memberDTO);

		return "redirect:/index";
	}

}
