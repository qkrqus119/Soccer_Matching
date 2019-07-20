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
		return jdbcTemplate.query("select * from match_board", new MatchBoardDTOMapper());
	}

	@Override
	public MatchBoardDTO read(int number) {
		return jdbcTemplate.queryForObject("select * from match_board where number = ?", new MatchBoardDTOMapper(), number);
	}

	@Override
	public void create(MatchBoardDTO matchBoardDTO) {
		jdbcTemplate.update(
				"insert into match_board (author, address, detail_address, place_name, date, start_time, start_time_minutes, end_time, end_time_minutes, game_type, gender, number_appliable, x, y) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
				matchBoardDTO.getAuthor(), matchBoardDTO.getAddress(), matchBoardDTO.getDetailAddress(),
				matchBoardDTO.getPlaceName(), matchBoardDTO.getDate(), matchBoardDTO.getStartTime(),
				matchBoardDTO.getStartTimeMinutes(), matchBoardDTO.getEndTime(), matchBoardDTO.getEndTimeMinutes(),
				matchBoardDTO.getGameType(), matchBoardDTO.getGender(), matchBoardDTO.getNumberAppliable(),
				matchBoardDTO.getX(), matchBoardDTO.getY());
	}

	@Override
	public void update(String address, String detailAddress, String placeName, Date date, String startTime,
			String startTimeMinutes, String endTime, String endTimeMinutes, String gameType, String gender,
			String numberAppliable, String detailInfo, String x, String y, int number) {

		jdbcTemplate.update(
				"update match_board set address = ?, detail_address = ?, place_name = ?, date = ?, start_time = ?, start_time_minutes = ?, end_time = ?, end_time_minutes = ?, game_type = ?, gender = ?, number_appliable = ?, detail_info, x = ?, y = ? where number = ?",
				address, detailAddress, placeName, date, startTime, startTimeMinutes, endTime, endTimeMinutes, gameType,
				gender, numberAppliable, detailInfo, x, y, number);

	}

	@Override
	public void delete(int number) {
		jdbcTemplate.update("delete from match_board where number = ?", number);
	}

	public final class MatchBoardDTOMapper implements RowMapper<MatchBoardDTO> {
		public MatchBoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MatchBoardDTO matchBoardDTO = new MatchBoardDTO();
			matchBoardDTO.setAddress(rs.getString("address"));
			matchBoardDTO.setAuthor(rs.getInt("author"));
			matchBoardDTO.setDate(rs.getDate("date"));
			matchBoardDTO.setDetailAddress(rs.getString("detail_address"));
			matchBoardDTO.setDetailInfo(rs.getString("detail_info"));
			matchBoardDTO.setEndTime(rs.getString("end_time"));
			matchBoardDTO.setEndTimeMinutes(rs.getString("end_time_minutes"));
			matchBoardDTO.setGameType(rs.getString("game_type"));
			matchBoardDTO.setGender(rs.getString("gender"));
			matchBoardDTO.setNumber(rs.getInt("number"));
			matchBoardDTO.setNumberAppliable(rs.getString("number_appliable"));
			matchBoardDTO.setPlaceName(rs.getString("place_name"));
			matchBoardDTO.setRegisterDate(rs.getDate("register_date"));
			matchBoardDTO.setStartTime(rs.getString("start_time"));
			matchBoardDTO.setStartTimeMinutes(rs.getString("start_time_minutes"));
			matchBoardDTO.setX(rs.getString("x"));
			matchBoardDTO.setY(rs.getString("y"));

			return matchBoardDTO;
		}
	}

}
