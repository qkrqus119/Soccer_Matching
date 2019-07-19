package com.soccermatching.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.soccermatching.dto.MatchBoardDTO;

@Repository
public class MatchBoardDAOImpl implements MatchBoardDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<MatchBoardDTO> readAll() {
		return jdbcTemplate.query("select * from board", new MatchBoardDTOMapper());
	}

	@Override
	public MatchBoardDTO read(int number) {
		return jdbcTemplate.queryForObject("select * from board where number = ?", new MatchBoardDTOMapper(), number);
	}

	@Override
	public void create(MatchBoardDTO matchBoardDTO) {
		jdbcTemplate.update(
				"insert into board (author, game_date, game_start_time, game_type, game_gender_type, place_name, address, content, register_date) values (?, ?, ?, ?, ?, ?, ?, ?, ?)",
				matchBoardDTO.getAuthor(), matchBoardDTO.getGameDate(), matchBoardDTO.getGameStartTime(),
				matchBoardDTO.getGameType(), matchBoardDTO.getGameGenderType(), matchBoardDTO.getPlaceName(),
				matchBoardDTO.getAddress(), matchBoardDTO.getContent(), matchBoardDTO.getRegisterDate());
	}

	@Override
	public void update(Date gameDate, LocalTime gameStartTime, String gameType, int gameGenderType, String placeName,
			String address, String content, Date registerDate, int number) {
		jdbcTemplate.update(
				"update board set game_date = ?, game_start_time = ?, game_type = ?, game_gender_type = ?, place_name = ?, address = ?, content = ?, register_date = ? where number = ?",
				gameDate, gameStartTime, gameType, gameGenderType, placeName, address, content, registerDate, number);
	}

	@Override
	public void delete(int number) {
		jdbcTemplate.update("delete from board where number = ?", number);
	}

	public final class MatchBoardDTOMapper implements RowMapper<MatchBoardDTO> {
		public MatchBoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MatchBoardDTO matchBoardDTO = new MatchBoardDTO();
			matchBoardDTO.setAddress(rs.getString("address"));
			matchBoardDTO.setAuthor(rs.getInt("author"));
			matchBoardDTO.setContent(rs.getString("content"));
			matchBoardDTO.setGameDate(rs.getDate("game_date"));
			matchBoardDTO.setGameGenderType(rs.getInt("game_gender_type"));
			matchBoardDTO.setGameStartTime(rs.getTime("game_start_time").toLocalTime());
			matchBoardDTO.setGameType(rs.getString("game_type"));
			matchBoardDTO.setNumber(rs.getInt("number"));
			matchBoardDTO.setPlaceName(rs.getString("place_number"));
			matchBoardDTO.setRegisterDate(rs.getDate("register_date"));

			return matchBoardDTO;
		}
	}

}
