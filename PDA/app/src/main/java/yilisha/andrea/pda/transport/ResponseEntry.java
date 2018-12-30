package yilisha.andrea.pda.transport;

public class ResponseEntry  implements Protocol {
	private int command;
	private String data;
	private String result ;
	public int getCommand() {
		return command;
	}
	public void setCommand(int command) {
		this.command = command;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public ResponseEntry() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResponseEntry(int command, String data, String result) {
		super();
		this.command = command;
		this.data = data;
		this.result = result;
	}
	
}

