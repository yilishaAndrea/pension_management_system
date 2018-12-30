package com.yilisha.model;
import java.io.Serializable;
public class ServiceType implements Serializable{
	private int serviceId;
	private String serviceName;
	private double servicePrice;
	private double serviceDuration;
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public double getServicePrice() {
		return servicePrice;
	}
	public void setServicePrice(double servicePrice) {
		this.servicePrice = servicePrice;
	}
	public double getServiceDuration() {
		return serviceDuration;
	}
	public void setServiceDuration(double serviceDuration) {
		this.serviceDuration = serviceDuration;
	}
}
