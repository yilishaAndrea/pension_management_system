package com.yilisha.model;
import java.io.Serializable;
public class FamilyMember implements Serializable{
	private String memberID;
	private String memberName;
	private String relation;
	private String memberTel;
	private String address;
	private String relationMemberID;
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getMemberTel() {
		return memberTel;
	}
	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRelationMemberID() {
		return relationMemberID;
	}
	public void setRelationMemberID(String relationMemberID) {
		this.relationMemberID = relationMemberID;
	}
}
