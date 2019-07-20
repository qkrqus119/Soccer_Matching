package com.soccermatching.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soccermatching.dao.MatchBoardDAO;
import com.soccermatching.dto.MatchBoardDTO;

@RestController
@RequestMapping("/api/match-boards")
public class MatchBoardController {

	@Autowired
	private MatchBoardDAO matchBoardDAO;

	@GetMapping
	public List<MatchBoardDTO> getAll() {
		return matchBoardDAO.readAll();
	}
	
	@GetMapping("{number}")
	public MatchBoardDTO getOne(@PathVariable("number") int number) {
		return matchBoardDAO.read(number);
	}

	@PutMapping("{number}")
	public void modify(@PathVariable("number") int number, @RequestBody Map<String, Object> map) {
		String address = (String) map.get("address");
		String detailAddress = (String) map.get("detail_address");
		String placeName = (String) map.get("place_name");
		Date date = (Date) map.get("date");
		String startTime = (String) map.get("start_time");
		String startTimeMinutes = (String) map.get("start_time_minutes");
		String endTime = (String) map.get("end_time");
		String endTimeMinutes = (String) map.get("end_time_minutes");
		String gameType = (String) map.get("game_type");
		String gender = (String) map.get("gender");
		String numberAppliable = (String) map.get("number_appliable");
		String detailInfo = (String) map.get("detail_info");
		String x = (String) map.get("x");
		String y = (String) map.get("y");

		matchBoardDAO.update(address, detailAddress, placeName, date, startTime, startTimeMinutes, endTime,
				endTimeMinutes, gameType, gender, numberAppliable, detailInfo, x, y, number);
	}
	
	@DeleteMapping("{number}")
	public void remove(@PathVariable("number") int number) {
		matchBoardDAO.delete(number);
	}

}
