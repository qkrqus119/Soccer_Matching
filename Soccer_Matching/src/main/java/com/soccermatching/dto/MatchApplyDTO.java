package com.soccermatching.dto;

public class MatchApplyDTO {
	private int memberNumber;
	private int matchBoardNumber;

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public int getMatchBoardNumber() {
		return matchBoardNumber;
	}

	public void setMatchBoardNumber(int matchBoardNumber) {
		this.matchBoardNumber = matchBoardNumber;
	}

	@Override
	public String toString() {
		return "MatchApply [memberNumber=" + memberNumber + ", matchBoardNumber=" + matchBoardNumber + "]";
	}

}
