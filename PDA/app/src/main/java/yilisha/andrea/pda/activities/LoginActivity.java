package yilisha.andrea.pda.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import yilisha.andrea.pda.R;
import yilisha.andrea.pda.beans.User;
import yilisha.andrea.pda.net.NetConnect;
import yilisha.andrea.pda.transport.Operator;
import yilisha.andrea.pda.transport.ResponseEntry;
import yilisha.andrea.pda.util.NetUtils;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,CheckBox.OnCheckedChangeListener{
    private EditText et_userName;//用户名
    private EditText et_password;//密码
    private CheckBox cb_checkbox;//记住密码
    private Button btn_login;//登录
    private final static int CONNECT_OUT_TIME = 5000;

    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            if(msg.what == NetConnect.CHANGE_UI) {
                Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_LONG).show();
                Operator operator =(Operator) msg.obj;
                Intent intent = new Intent(LoginActivity.this,TabManyActivity.class);
                intent.putExtra("operator", operator);
                startActivity(intent);
            }else if(msg.what ==NetConnect.ERROR) {
                Toast.makeText(LoginActivity.this, "登录失败，请重新输入", Toast.LENGTH_LONG).show();
            }
        };
    };


    private static final String FILE_NAME = "userdata.txt";//用来保存用户名与密码到本地的文件
    private final String TAG = "FileIO";//打印到log的信息
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE);
        getSupportActionBar().setIcon(R.drawable.car);
        init();
        load(FILE_NAME);
        cb_checkbox.setOnCheckedChangeListener(this);
        btn_login.setOnClickListener(this);
    }
    //读是否存在记录的文件
    protected void load(String filename){
        FileInputStream in = null;
        try {
            in = openFileInput(filename); //创建输入流
            ObjectInputStream ois = new ObjectInputStream(in);
            User user = (User) ois.readObject();
            et_userName.setText(user.getUserName());
            et_password.setText(user.getUserPassword());
            cb_checkbox.setChecked(true);
        } catch (Exception e) {
            Log.d(TAG, "input error", e);//出错处理
        } finally {
        }

    }
    public void init(){
        et_userName = (EditText)findViewById(R.id.et_userName);
        et_password = (EditText)findViewById(R.id.et_password);
        cb_checkbox = (CheckBox) findViewById(R.id.cb_checkbox);
        btn_login = (Button)findViewById(R.id.btn_login);
    }
    //复选按钮是否状态改变
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Toast.makeText(LoginActivity.this, "test"+isChecked,Toast.LENGTH_SHORT).show();

        if(isChecked){
            //存储用户名与密码到本地文件
            save(FILE_NAME);
        }else{
            //判断本地文件是否存在，存在则删除文件
            File file = new File(FILE_NAME);
            if(file.isFile()&&file.exists()){
                file.delete();
                Toast.makeText(LoginActivity.this, "取消记住成功", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(LoginActivity.this, "文件不存在", Toast.LENGTH_LONG).show();
            }
//            if(deleteFile(FILE_NAME)) {
//                Toast.makeText(LoginActivity.this, "取消记住成功", Toast.LENGTH_LONG).show();
//            }
        }
    }
    //取消记忆时删除之前存在的文件
    public boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            file.setExecutable(true, false);
            file.setReadable(true, false);
            file.setWritable(true, false);
            return file.delete();
        }else{
            return false;
        }
    }
    //保存用户名与密码
    protected void save(String filename) {
        FileOutputStream out = null;
        try {
            out = openFileOutput(filename, Context.MODE_PRIVATE);//以私有模式建立文件
            User user = new User(et_userName.getText().toString(),et_password.getText().toString());
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(user);
            out.flush();

            Toast.makeText(LoginActivity.this, "保存成功!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.d(TAG, "output error", e);//出错处理
        } finally {//释放资源
            if(out != null) {
                try {
                    out.close();//关闭FileOutputStream
                } catch (IOException e) {
                    Log.d(TAG, "close error", e);
                }
            }
        }
    }

    @Override
    public void onClick(View v) {//点击发送登录请求
        final String name = et_userName.getText().toString();
        final String pass = et_password.getText().toString();
        if(name.equals("")||pass.equals("")){
            Toast.makeText(LoginActivity.this,"用户名或密码不为空",Toast.LENGTH_LONG).show();
        }else{
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String url = new NetConnect().LOGIN_URL+"?operateId=" + name + "&pwd=" + pass;
                    login(url);
                }
            }).start();

        }


    }

    //登录往服务器发送请求
    private void login(String urlPath){
        try {
            URL url = new URL(urlPath);
            HttpURLConnection conn=(HttpURLConnection) url.openConnection(); //开启连接
            conn.setConnectTimeout(5000);
            conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("ser-Agent", "Fiddler");
            conn.setRequestProperty("Content-Type","application/json");
            int code=conn.getResponseCode();
            if(code==200){   //与后台交互成功返回 200
                //读取返回的json数据
                InputStream inputStream=conn.getInputStream();
                // 调用自己写的NetUtils() 将流转成string类型
                String json= NetUtils.readString(inputStream);

                Gson gson=new Gson();  //引用谷歌的json包

                ResponseEntry request = gson.fromJson(json,ResponseEntry.class); //谷歌的解析json的方法
                if(request.getResult().equals("1")){
                    Operator operator = gson.fromJson(request.getData(), Operator.class);
                    Message msg = new Message();
                    msg.what = NetConnect.CHANGE_UI;
                    msg.obj = operator;
                    handler.sendMessage(msg);
                }else {
                    Message msg = new Message();
                    msg.what = NetConnect.ERROR;
                    handler.sendMessage(msg);
                }
            }else{
                Message msg = new Message();
                msg.what = NetConnect.ERROR;
                handler.sendMessage(msg);

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
