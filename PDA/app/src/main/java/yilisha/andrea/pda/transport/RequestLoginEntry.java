package yilisha.andrea.pda.transport;

/**
 * Created by yilisha andrea on 2018/6/17.
 */

public class RequestLoginEntry implements yilisha.andrea.pda.interfaces.Protocol {
    private Operator data;			// 命令实体(用户对象)
    public Operator getData() {
        return data;
    }
    public void setData(Operator data) {
        this.data = data;
    }

    public RequestLoginEntry(Operator data) {
        this.data = data;
    }
}
