package com.yilisha.model;
import java.io.Serializable;
public class Server implements Serializable{
	private String serverID;
	private String serverName;
	private int serverWorkplaceID;
	private String serverTel;
	private double serverCoordinateX;
	private double serverCoordinateY;
	private int serverStatus;
	public String getServerID() {
		return serverID;
	}
	public void setServerID(String serverID) {
		this.serverID = serverID;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public int getServerWorkplaceID() {
		return serverWorkplaceID;
	}
	public void setServerWorkplaceID(int serverWorkplaceID) {
		this.serverWorkplaceID = serverWorkplaceID;
	}
	public String getServerTel() {
		return serverTel;
	}
	public void setServerTel(String serverTel) {
		this.serverTel = serverTel;
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
	public int getServerStatus() {
		return serverStatus;
	}
	public void setServerStatus(int serverStatus) {
		this.serverStatus = serverStatus;
	}
}
