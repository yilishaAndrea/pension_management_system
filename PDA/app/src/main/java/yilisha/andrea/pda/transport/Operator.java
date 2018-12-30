package yilisha.andrea.pda.transport;
import java.io.Serializable;

public class Operator implements Serializable {
	private int id;
	private String  operateId;
	private String uname;
	private String pwd;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOperateId() {
		return operateId;
	}
	public void setOperateId(String operateId) {
		this.operateId = operateId;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Operator() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Operator [id=" + id + ", operateId=" + operateId + ", uname=" + uname + ", pwd=" + pwd + "]";
	}
	
}
