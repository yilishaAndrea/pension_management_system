package com.yilisha.model;
import java.io.Serializable;
public class OrderForm implements Serializable{
	private String orderNumber;
	private String userId;
	private String serverId;
	private String serviceContent;
	private int serviceTypeId;
	private int serviceStatus;
	public String getServerId() {
		return serverId;
	}
	public void setServerId(String serverId) {
		this.serverId = serverId;
	}
	
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getServiceContent() {
		return serviceContent;
	}
	public void setServiceContent(String serviceContent) {
		this.serviceContent = serviceContent;
	}
	public int getServiceTypeId() {
		return serviceTypeId;
	}
	public void setServiceTypeId(int serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}
	public int getServiceStatus() {
		return serviceStatus;
	}
	public void setServiceStatus(int serviceStatus) {
		this.serviceStatus = serviceStatus;
	}
}
