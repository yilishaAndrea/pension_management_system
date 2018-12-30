package yilisha.andrea.pda.transport;

import java.util.Date;


public class FastGood {
	private int id;
	private String goodNo;
	private String des;
	private String bigBagNo;
	private Date time;
	public FastGood() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGoodNo() {
		return goodNo;
	}
	public void setGoodNo(String goodNo) {
		this.goodNo = goodNo;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getBigBagNo() {
		return bigBagNo;
	}
	public void setBigBagNo(String bigBagNo) {
		this.bigBagNo = bigBagNo;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "FastGood [id=" + id + ", goodNo=" + goodNo + ", des=" + des + ", bigBagNo=" + bigBagNo + ", time="
				+ time + "]";
	}
	

}
