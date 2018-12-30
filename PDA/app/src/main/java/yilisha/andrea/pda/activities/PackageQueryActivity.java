package yilisha.andrea.pda.activities;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import yilisha.andrea.pda.R;
import yilisha.andrea.pda.net.NetConnect;
import yilisha.andrea.pda.transport.Operator;
import yilisha.andrea.pda.transport.ResponseEntry;
import yilisha.andrea.pda.transport.SetPackage;
import yilisha.andrea.pda.util.NetUtils;

public class PackageQueryActivity extends AppCompatActivity {
    private TextView operatorTV;
    private EditText packageNumberET;
    private Button queryPackageBT;
    private TextView showInfoTV;
    private Operator operator;
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            if(msg.what == NetConnect.CHANGE_UI) {
                SetPackage setPackage =(SetPackage) msg.obj;
                String str = "集包号："+setPackage.getBigBagNo()+"\n操作员："+setPackage.getOperateId()+"\n操作时间:"+setPackage.getTime();
                showInfoTV.setText(str);
                Toast.makeText(PackageQueryActivity.this, "查询成功", Toast.LENGTH_LONG).show();
            }else if(msg.what ==NetConnect.ERROR) {
                Toast.makeText(PackageQueryActivity.this, "操作失败，请重新输入", Toast.LENGTH_LONG).show();
            }
        };
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_query);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE);
        getSupportActionBar().setIcon(R.drawable.car);
        operatorTV = (TextView)findViewById(R.id.operatorTV);
        operator = (Operator) getIntent().getSerializableExtra("operator");
        operatorTV.setText(operator.getUname());
        packageNumberET = (EditText)findViewById(R.id.packageNumberET);
        queryPackageBT = (Button)findViewById(R.id.queryPackageBT);
        showInfoTV = (TextView)findViewById(R.id.showInfoTV);
        queryPackageBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = packageNumberET.getText().toString();
                if(number.length()!=10) {
                    Toast.makeText(PackageQueryActivity.this,"请输入10位集包号！",Toast.LENGTH_LONG).show();
                }else{
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            String url = new NetConnect().QUERY_PACKAGE_URL+"?bigBagNo=" + packageNumberET.getText().toString();
                            queryPackage(url);
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
    private void queryPackage(String urlPath){

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
                if(request.getResult().equals("1")) {
                    SetPackage setPackage = gson.fromJson(request.getData(), SetPackage.class);
                    Message msg = new Message();
                    msg.what = NetConnect.CHANGE_UI;
                    msg.obj = setPackage;
                    handler.sendMessage(msg);
                }else{
                    Message msg = new Message();
                    msg.what = NetConnect.ERROR;
                    handler.sendMessage(msg);
                    Log.d("TTTTT",request.getResult());
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
