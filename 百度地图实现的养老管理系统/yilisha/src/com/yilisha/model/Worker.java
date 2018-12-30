package com.yilisha.model;
import java.io.Serializable;
public class Worker implements Serializable{
	private String workNumber;
	private String workDate;
	private String startWork;
	private String endWork;
	public String getWorkNumber() {
		return workNumber;
	}
	public void setWorkNumber(String workNumber) {
		this.workNumber = workNumber;
	}
	public String getWorkDate() {
		return workDate;
	}
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}
	public String getStartWork() {
		return startWork;
	}
	public void setStartWork(String startWork) {
		this.startWork = startWork;
	}
	public String getEndWork() {
		return endWork;
	}
	public void setEndWork(String endWork) {
		this.endWork = endWork;
	}
	
}
