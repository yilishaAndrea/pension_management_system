package com.yilisha.model;
import java.io.Serializable;
import java.util.Date;
public class ServerTrace implements Serializable{
	private int ID;
	private String serverID;
	private  Date date;
	private  Date time;
	private double serverCoordinateX;
	private double serverCoordinateY;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getServerID() {
		return serverID;
	}
	public void setServerID(String serverID) {
		this.serverID = serverID;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public double getServerCoordinateX() {
		return serverCoordinateX;
	}
	public void setServerCoordinateX(double serverCoordinateX) {
		this.serverCoordinateX = serverCoordinateX;
	}
	public double getServerCoordinateY() {
		return serverCoordinateY;
	}
	public void setServerCoordinateY(double serverCoordinateY) {
		this.serverCoordinateY = serverCoordinateY;
	}
}
