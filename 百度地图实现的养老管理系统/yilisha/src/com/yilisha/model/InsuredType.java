package com.yilisha.model;
import java.io.Serializable;
public class InsuredType implements Serializable{
	private int insuredTypeID;
	private String insuredName;
	private String insuredCount;
	public int getInsuredTypeID() {
		return insuredTypeID;
	}
	public void setInsuredTypeID(int insuredTypeID) {
		this.insuredTypeID = insuredTypeID;
	}
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getInsuredCount() {
		return insuredCount;
	}
	public void setInsuredCount(String insuredCount) {
		this.insuredCount = insuredCount;
	}
}
