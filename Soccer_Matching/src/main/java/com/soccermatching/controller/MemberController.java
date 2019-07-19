package com.soccermatching.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soccermatching.dao.MemberDAOImpl;
import com.soccermatching.dto.MemberDTO;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberDAOImpl memberDAOImpl;

	@GetMapping
	public String getMembers(Model model) {
		List<MemberDTO> memberDTOs = memberDAOImpl.readAll();
		model.addAttribute("member", memberDTOs);

		return "member";
	}

	@GetMapping("/{number}")
	public String getMember(@PathVariable("number") int number, Model model) {
		MemberDTO memberDTO = memberDAOImpl.read(number);
		model.addAttribute("member", memberDTO);

		return "member";
	}

}