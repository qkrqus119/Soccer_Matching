package com.soccermatching.dto;

import java.sql.Date;

public class MatchBoardDTO {
	private int number;
	private int author;
	private String address;
	private String detailAddress;
	private String placeName;
	private Date date;
	private String startTime;
	private String startTimeMinutes;
	private String endTime;
	private String endTimeMinutes;
	private String gameType;
	private String gender;
	private String numberAppliable;
	private String detailInfo;
	private String x;
	private String y;
	private Date registerDate;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getStartTimeMinutes() {
		return startTimeMinutes;
	}

	public void setStartTimeMinutes(String startTimeMinutes) {
		this.startTimeMinutes = startTimeMinutes;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getEndTimeMinutes() {
		return endTimeMinutes;
	}

	public void setEndTimeMinutes(String endTimeMinutes) {
		this.endTimeMinutes = endTimeMinutes;
	}

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNumberAppliable() {
		return numberAppliable;
	}

	public void setNumberAppliable(String numberAppliable) {
		this.numberAppliable = numberAppliable;
	}

	public String getDetailInfo() {
		return detailInfo;
	}

	public void setDetailInfo(String detailInfo) {
		this.detailInfo = detailInfo;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	@Override
	public String toString() {
		return "MatchBoardDTO [number=" + number + ", author=" + author + ", address=" + address + ", detailAddress="
				+ detailAddress + ", placeName=" + placeName + ", date=" + date + ", startTime=" + startTime
				+ ", startTimeMinutes=" + startTimeMinutes + ", endTime=" + endTime + ", endTimeMinutes="
				+ endTimeMinutes + ", gameType=" + gameType + ", gender=" + gender + ", numberAppliable="
				+ numberAppliable + ", detailInfo=" + detailInfo + ", x=" + x + ", y=" + y + ", registerDate="
				+ registerDate + "]";
	}

}
