package com.yilisha.model;
import java.io.Serializable;
public class ServiceCost implements Serializable{
	private String serviceCostId;
	private String serverId;
	private double serviceTime;
	private double serviceCost;
	public String getServiceCostId() {
		return serviceCostId;
	}
	public void setServiceCostId(String serviceCostId) {
		this.serviceCostId = serviceCostId;
	}
	public String getServerId() {
		return serverId;
	}
	public void setServerId(String serverId) {
		this.serverId = serverId;
	}
	public double getServiceTime() {
		return serviceTime;
	}
	public void setServiceTime(double serviceTime) {
		this.serviceTime = serviceTime;
	}
	public double getServiceCost() {
		return serviceCost;
	}
	public void setServiceCost(double serviceCost) {
		this.serviceCost = serviceCost;
	}
}
