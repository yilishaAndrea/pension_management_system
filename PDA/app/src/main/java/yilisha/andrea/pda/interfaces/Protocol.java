package yilisha.andrea.pda.interfaces;

/**
 * Created by yilisha andrea on 2018/6/16.
 */

public interface Protocol {
    //===========iCommand :Request/Response请求命令类型=========
    public final int LOGIN = 1;		//客户端的登录请求
    public final int RESPONSE_LOGIN = 2;	//服务器端的登录响应
    public final int SEND_DATA = 3;			//客户端的发送数据请求
    public final int RESPONSE_DATA = 4;		//服务器端的对客户发送数据的响应
    public final int REQUEST_DATA = 5;		 //客户端发送的数据
    public final int SEND_QUERY_BIGBAGNO = 7; //集包号查询请求
    

}
