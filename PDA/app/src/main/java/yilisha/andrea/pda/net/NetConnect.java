package yilisha.andrea.pda.net;

/**
 * Created by yilisha andrea on 2018/6/17.
 */

public class NetConnect {
    //登录时的URL
    String str = "172.30.7.125";
    public String LOGIN_URL = "http://"+str+":8080/PDA/login.action";
    //添加包时的URL
    public String ADD_PACKAGE_URL = "http://"+str+":8080/PDA/addPackage.action";
    //减包URL
    public String DROP_PACKAGE_URL = "http://"+str+":8080/PDA/querySetPackage.action";
    //智能加包的URL
    public String SMART_ADD_PACKAGE_URL = "http://"+str+":8080/PDA/buildPackage.action";
    //集包查询URL
    public String QUERY_PACKAGE_URL="http://"+str+":8080/PDA/querySetPackage.action";
    //改变界面
    public static final int CHANGE_UI = 1;
    //发生错误
    public static final int ERROR = 2;
}
