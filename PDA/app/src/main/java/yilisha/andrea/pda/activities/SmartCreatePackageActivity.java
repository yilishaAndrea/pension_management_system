package yilisha.andrea.pda.activities;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import yilisha.andrea.pda.R;
import yilisha.andrea.pda.beans.ShowListData;
import yilisha.andrea.pda.net.NetConnect;
import yilisha.andrea.pda.transport.Operator;
import yilisha.andrea.pda.transport.ResponseEntry;
import yilisha.andrea.pda.util.NetUtils;

public class SmartCreatePackageActivity extends AppCompatActivity {
    private TextView operatorTV;//操作员
    private EditText packageNumberET;//集包号
    private EditText pickNumberET;//分拣口
    private TextView operationTV;//扫描集包号操作
    private ListView list_view;
    private ArrayList<ShowListData> showList = new ArrayList<ShowListData>();
    private String packageNumberStr="";
    private String pickNumberStr="";
    private Operator operator;
    private MyListAdapter listAdapter;
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            if(msg.what == NetConnect.CHANGE_UI) {
                int i = msg.arg1;
                Toast.makeText(SmartCreatePackageActivity.this, "操作成功", Toast.LENGTH_LONG).show();
                listAdapter.setSign(i,true);
            }else if(msg.what ==NetConnect.ERROR) {
                int i = msg.arg1;
                Toast.makeText(SmartCreatePackageActivity.this, "操作失败，请重新输入", Toast.LENGTH_LONG).show();
                listAdapter.setSign(i,false);
            }
        };
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE);
        getSupportActionBar().setIcon(R.drawable.car);
        setContentView(R.layout.activity_smart_add_package);
        init();
    }
    public void init(){
        operator = (Operator) getIntent().getSerializableExtra("operator");
        operatorTV = (TextView)findViewById(R.id.operatorTV);
        operator = (Operator) getIntent().getSerializableExtra("operator");
        operatorTV.setText(operator.getUname());
        packageNumberET = (EditText) findViewById(R.id.packageNumberET);
        pickNumberET = (EditText)findViewById(R.id.pickNumberET);
        operationTV = (TextView)findViewById(R.id.operationTV);
        list_view = (ListView)findViewById(R.id.list_view);
        listAdapter = new MyListAdapter(SmartCreatePackageActivity.this,showList);
        list_view.setAdapter(listAdapter);
        //点击模拟扫描功能
        operationTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击后录入数据
                packageNumberStr = packageNumberET.getText().toString();
                pickNumberStr = pickNumberET.getText().toString();
                if(packageNumberStr.length()!=10||pickNumberStr.length()!=6){
                    Toast.makeText(SmartCreatePackageActivity.this, "确保输入格式正确！", Toast.LENGTH_SHORT).show();
                }else{
                    ShowListData showData = new ShowListData(packageNumberStr,pickNumberStr,"是");
                    listAdapter.add(showData);
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
    private void createPackage(String urlPath,int i){
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
                    Message msg = new Message();
                    msg.what = NetConnect.CHANGE_UI;
                    msg.arg1 = i;
                    handler.sendMessage(msg);
                }else{
                    Message msg = new Message();
                    msg.what = NetConnect.ERROR;
                    msg.arg1 = i;
                    handler.sendMessage(msg);
                }
            }else{
                Message msg = new Message();
                msg.arg1 = i;
                msg.what = NetConnect.ERROR;
                handler.sendMessage(msg);

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public class MyListAdapter extends BaseAdapter {
        private Context context;
        ArrayList<ShowListData> showdataList;
        private TextView packageNumberTV;
        private TextView pickNumberTV;
        private TextView sendTV;

        public MyListAdapter(Context c, ArrayList<ShowListData> showdataList)
        {
            this.showdataList=showdataList;
            this.context = c;
        }
        public void setSign(int i,boolean flag){
            ShowListData showdata = showdataList.get(i);
            if(flag) {
                showdata.setIsSend("成功");
                showdataList.set(i,showdata);
            }else{
                showdata.setIsSend("失败");
                showdataList.set(i,showdata);
            }
            notifyDataSetChanged();
        }
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return showdataList.size();
        }
        public void add(ShowListData showData){
            showdataList.add(showData);
            notifyDataSetChanged();
        }
        @Override
        public Object getItem(int i) {
            // TODO Auto-generated method stub
            return showdataList.get(i);
        }


        @Override
        public long getItemId(int i) {
            // TODO Auto-generated method stub
            return i;
        }


        public void setItemSelected(int position)
        {
            for (ShowListData showdata:showdataList)
            {
                showdata.setSelected(false);
            }
            showdataList.get(position).setSelected(true);

            notifyDataSetChanged();
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewgroup) {
            packageNumberTV = null;
            pickNumberTV=null;
            sendTV = null;
            if(view == null){
                view = LayoutInflater.from(context).inflate(R.layout.list_view_item, null);
            }
            packageNumberTV=(TextView)view.findViewById(R.id.packageNumberTV);
            packageNumberTV.setText(showdataList.get(i).getPackageNumber());
            pickNumberTV=(TextView)view.findViewById(R.id.pickNumberTV);
            pickNumberTV.setText(showdataList.get(i).getPickNumber());
            sendTV = (TextView)view.findViewById(R.id.sendTV);
            if(showdataList.get(i).getIsSend().equals("失败")){
                sendTV.setTextColor(Color.parseColor("#FF0000"));
                sendTV.setText(showdataList.get(i).getIsSend());
            }
            sendTV.setText(showdataList.get(i).getIsSend());

            sendTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            String url = new NetConnect().SMART_ADD_PACKAGE_URL+"?bigBagNo=" + showdataList.get(i).getPackageNumber()+"&downNo="+showdataList.get(i).getPickNumber()+"&operateId="+operatorTV.getText().toString();
                            createPackage(url,i);
                        }
                    }).start();
                }
            });
            return view;
        }
    }

}
