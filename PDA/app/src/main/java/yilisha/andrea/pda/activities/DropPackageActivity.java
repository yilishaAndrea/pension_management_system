package yilisha.andrea.pda.activities;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import yilisha.andrea.pda.R;
import yilisha.andrea.pda.net.NetConnect;
import yilisha.andrea.pda.transport.Operator;
import yilisha.andrea.pda.transport.ResponseEntry;
import yilisha.andrea.pda.util.NetUtils;

public class DropPackageActivity extends AppCompatActivity {
    private EditText pickNumberET;
    private Button dropPackageBT;

    private String pickNumberStr;
   // private String packageNumberStr;
    private Operator operator;

    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            if(msg.what == NetConnect.CHANGE_UI) {
                Toast.makeText(DropPackageActivity.this, "操作成功", Toast.LENGTH_LONG).show();
            }else if(msg.what ==NetConnect.ERROR) {
                Toast.makeText(DropPackageActivity.this, "操作失败，请重新输入", Toast.LENGTH_LONG).show();
            }
        };
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop_package);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE);
        getSupportActionBar().setIcon(R.drawable.car);
        operator = (Operator) getIntent().getSerializableExtra("operator");
        pickNumberET = (EditText)findViewById(R.id.pickNumberET);
        dropPackageBT = (Button)findViewById(R.id.dropPackageBT);

        dropPackageBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickNumberStr = pickNumberET.getText().toString();
                if(pickNumberStr.length()!=6){
                    Toast.makeText(DropPackageActivity.this,"请输入6位面单号！",Toast.LENGTH_LONG).show();
                }else{

                    //发送请求到服务器
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            String url = new NetConnect().DROP_PACKAGE_URL+"?goodNo="+pickNumberStr;
                            dropPackage(url);
                        }
                    }).start();
                }
            }
        });
    }
    //点击按钮返回上一级
    public void GobackClick(View view){
        //
        finish();
    }
   //登录往服务器发送请求
    private void dropPackage(String urlPath){
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
