package com.soccermatching.dao;

import java.util.List;

import com.soccermatching.dto.MemberDTO;

public interface MemberDAO {

	public List<MemberDTO> readAll();

	public MemberDTO read(int number);

	public void create(MemberDTO memberDTO);

	public void update(String name, String pwd, int gender, String cphone, String birthday, String email, int number);

	public void delete(int number);

}