package yilisha.andrea.pda.transport;

import java.util.Date;

public class SetPackage {
	private int id;
	private String bigBagNo;
	private String downNo;
	private Date time;
	private String operateId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBigBagNo() {
		return bigBagNo;
	}
	public void setBigBagNo(String bigBagNo) {
		this.bigBagNo = bigBagNo;
	}
	public String getDownNo() {
		return downNo;
	}
	public void setDownNo(String downNo) {
		this.downNo = downNo;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getOperateId() {
		return operateId;
	}
	public void setOperateId(String operateId) {
		this.operateId = operateId;
	}
	public SetPackage() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SetPackage [id=" + id + ", bigBagNo=" + bigBagNo + ", downNo=" + downNo + ", time=" + time
				+ ", operateId=" + operateId + "]";
	}
	
}
