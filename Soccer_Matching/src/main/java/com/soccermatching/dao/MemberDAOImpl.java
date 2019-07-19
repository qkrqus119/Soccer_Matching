package com.soccermatching.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.soccermatching.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<MemberDTO> readAll() {
		return jdbcTemplate.query("select * from member", new MemberDTOMapper());
	}

	@Override
	public MemberDTO read(int number) {
		return jdbcTemplate.queryForObject("select * from member where number = ?", new MemberDTOMapper(), number);
	}

	@Override
	public void create(MemberDTO memberDTO) {
		jdbcTemplate.update(
				"insert into member (id, pwd, name, gender, cphone, birthday, email) values (?, ?, ?, ?, ?, ?, ?)",
				memberDTO.getId(), memberDTO.getPwd(), memberDTO.getName(), memberDTO.getGender(),
				memberDTO.getCphone(), memberDTO.getBirthday(), memberDTO.getEmail());
	}

	@Override
	public void update(String pwd, String name, int gender, String cphone, String birthday, String email, int number) {
		jdbcTemplate.update(
				"update member set pwd = ?, name = ?, gender = ?, cphone = ?, birthday = ?, email = ? where number = ?",
				pwd, name, gender, cphone, birthday, email, number);
	}

	@Override
	public void delete(int number) {
		jdbcTemplate.update("delete from member where number = ?", number);
	}

	public final class MemberDTOMapper implements RowMapper<MemberDTO> {
		public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setBirthday(rs.getString("birthday"));
			memberDTO.setCphone(rs.getString("cphone"));
			memberDTO.setEmail(rs.getString("email"));
			memberDTO.setGender(rs.getInt("gender"));
			memberDTO.setId(rs.getString("id"));
			memberDTO.setName(rs.getString("name"));
			memberDTO.setNumber(rs.getInt("number"));
			memberDTO.setPwd(rs.getString("pwd"));

			return memberDTO;
		}
	}

}