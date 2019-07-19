package com.soccermatching.dao;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import com.soccermatching.dto.MatchBoardDTO;

public interface MatchBoardDAO {

	public List<MatchBoardDTO> readAll();

	public MatchBoardDTO read(int number);

	public void create(MatchBoardDTO matchBoardDTO);

	public void update(Date gameDate, LocalTime gameStartTime, String gameType, int gameGenderType, String placeName,
			String address, String Content, Date registerDate, int number);

	public void delete(int number);

}
