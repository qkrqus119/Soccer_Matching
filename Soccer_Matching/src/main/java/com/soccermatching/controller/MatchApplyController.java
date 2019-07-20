package com.soccermatching.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soccermatching.dao.MatchApplyDAO;
import com.soccermatching.dto.MatchApplyDTO;

@RestController
@RequestMapping("/api/match-applies")
public class MatchApplyController {
	
	@Autowired
	private MatchApplyDAO matchApplyDAO;
	
	@GetMapping("member/{memberNumber}")
	public List<MatchApplyDTO> getApplies(@PathVariable("memberNumber") int memberNumber) {
		return matchApplyDAO.readAppliedMatch(memberNumber);
	}

}