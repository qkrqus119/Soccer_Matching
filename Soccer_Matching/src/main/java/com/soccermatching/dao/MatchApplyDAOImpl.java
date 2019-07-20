package com.soccermatching.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.soccermatching.dto.MatchApplyDTO;

@Repository
public class MatchApplyDAOImpl implements MatchApplyDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<MatchApplyDTO> readAppliedMatch(int memberNumber) {
		return jdbcTemplate.query("select * from match_apply where member_number = ?", new MatchApplyDTOMapper(), memberNumber);
	}
	
	public final class MatchApplyDTOMapper implements RowMapper<MatchApplyDTO> {
		public MatchApplyDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MatchApplyDTO matchApplyDTO = new MatchApplyDTO();
			matchApplyDTO.setMatchBoardNumber(rs.getInt("match_board_number"));
			matchApplyDTO.setMemberNumber(rs.getInt("member_number"));

			return matchApplyDTO;
		}
	}

}
