package com.soccermatching.dao;

import java.util.List;

import com.soccermatching.dto.MemberDTO;

public interface MemberDAO {

	public List<MemberDTO> readAll();

	public MemberDTO read(int number);

}