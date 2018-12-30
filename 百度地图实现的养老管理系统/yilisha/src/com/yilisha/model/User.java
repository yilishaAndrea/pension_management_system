package com.yilisha.model;
import java.io.Serializable;
public class User implements Serializable{
	private String userID;
	private String userName;
	private String userGender;
	private int userAge;
	private String userTel;
	private double userCoordinateX;
	private double userCoordinateY;
	private int insuredTypeID;
	private String userAddress;
	private int userStatus;
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public double getUserCoordinateX() {
		return userCoordinateX;
	}
	public void setUserCoordinateX(double userCoordinateX) {
		this.userCoordinateX = userCoordinateX;
	}
	public double getUserCoordinateY() {
		return userCoordinateY;
	}
	public void setUserCoordinateY(double userCoordinateY) {
		this.userCoordinateY = userCoordinateY;
	}
	public int getInsuredTypeID() {
		return insuredTypeID;
	}
	public void setInsuredTypeID(int insuredTypeID) {
		this.insuredTypeID = insuredTypeID;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
}
