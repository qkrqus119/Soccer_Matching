package com.soccermatching.dao;

import java.util.Date;
import java.util.List;

import com.soccermatching.dto.MatchBoardDTO;

public interface MatchBoardDAO {

	public List<MatchBoardDTO> readAll();

	public MatchBoardDTO read(int number);

	public void create(MatchBoardDTO matchBoardDTO);

	public void update(String address, String detailAddress, String placeName, Date date, String startTime,
			String startTimeMinutes, String endTime, String endTimeMinutes, String gameType, String gender,
			String numberAppliable, String detailInfo, String x, String y, int number);

	public void delete(int number);

}
