package com.soccermatching.dao;

import java.util.List;

import com.soccermatching.dto.MatchApplyDTO;

public interface MatchApplyDAO {
	public List<MatchApplyDTO> readAppliedMatch(int memberNumber);
}
