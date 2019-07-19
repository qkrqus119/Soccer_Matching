package com.soccermatching.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soccermatching.dao.MemberDAOImpl;
import com.soccermatching.dto.MemberDTO;

@RestController
@RequestMapping("/api/members")
public class MemberController {

	@Autowired
	private MemberDAOImpl memberDAOImpl;

	@GetMapping
	public List<MemberDTO> getAll(Model model) {
		return memberDAOImpl.readAll();
	}

	@GetMapping("/{number}")
	public MemberDTO getOne(@PathVariable("number") int number) {
		return memberDAOImpl.read(number);
	}
	
	@PutMapping("/{number}")
	public void modify(@PathVariable("number") int number, @RequestBody Map<String, Object> map) {
		String pwd = (String) map.get("pwd");
		String name = (String) map.get("name");
		int gender = (int) map.get("gender");
		String cphone = (String) map.get("cphone");
		String birthday = (String) map.get("birthday");
		String email = (String) map.get("email");
		
		memberDAOImpl.update(pwd, name, gender, cphone, birthday, email, number);
	}
	
	@DeleteMapping("/{number}")
	public void remove(@PathVariable("number") int number) {
		memberDAOImpl.delete(number);
	}

}