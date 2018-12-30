package yilisha.andrea.pda.beans;

/**
 * Created by yilisha andrea on 2018/6/18.
 */

public class User {
    private String userName;
    private String userPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public User(String name, String password) {
        this.userName = name;
        this.userPassword = password;
    }
}
