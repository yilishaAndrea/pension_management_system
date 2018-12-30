package com.yilisha.model;
import java.io.Serializable;
public class ServerWorkspace implements Serializable{
	private int serverWorkplaceID;
	private String serverWorkplaceName;
	private double serverWorkplaceCoordinateX;
	private double serverWorkplaceCoordinateY;
	private String serverWorkplaceAddress;
	public int getServerWorkplaceID() {
		return serverWorkplaceID;
	}
	public void setServerWorkplaceID(int serverWorkplaceID) {
		this.serverWorkplaceID = serverWorkplaceID;
	}
	public String getServerWorkplaceName() {
		return serverWorkplaceName;
	}
	public void setServerWorkplaceName(String serverWorkplaceName) {
		this.serverWorkplaceName = serverWorkplaceName;
	}
	public double getServerWorkplaceCoordinateX() {
		return serverWorkplaceCoordinateX;
	}
	public void setServerWorkplaceCoordinateX(double serverWorkplaceCoordinateX) {
		this.serverWorkplaceCoordinateX = serverWorkplaceCoordinateX;
	}
	public double getServerWorkplaceCoordinateY() {
		return serverWorkplaceCoordinateY;
	}
	public void setServerWorkplaceCoordinateY(double serverWorkplaceCoordinateY) {
		this.serverWorkplaceCoordinateY = serverWorkplaceCoordinateY;
	}
	public String getServerWorkplaceAddress() {
		return serverWorkplaceAddress;
	}
	public void setServerWorkplaceAddress(String serverWorkplaceAddress) {
		this.serverWorkplaceAddress = serverWorkplaceAddress;
	}
}
