package yilisha.andrea.pda.activities;

import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by yilisha andrea on 2018/6/18.
 */

public class HttpThread  extends Thread {
    private final static int CONNECT_OUT_TIME = 5000;
    private String url;
    private String name;
    private String pwd;
   // private TextView response;

    /**
     * tag=1：默认，get方式；tag=2：post方式
     */
    private int tag = 1;

    public HttpThread() {
        super();
    }

    public HttpThread(String url, String name, String pwd,
                       int tag) {
        super();
        this.url = url;
        this.name = name;
        this.pwd = pwd;
      //  this.response = response;
        this.tag = tag;
    }

    public void doGet() {
        // 如果服务器没有转码的时候，我们可以设置，防止乱码
        // name = URLEncoder.encode(name, "utf-8");
        // pwd = URLEncoder.encode(pwd, "utf-8");

        url += "?operateId=" + name + "&pwd=" + pwd;
        try {
            // 第一步：创建必要的URL对象
            URL httpUrl = new URL(url);
            // 第二步：根据URL对象，获取HttpURLConnection对象
            HttpURLConnection connection = (HttpURLConnection) httpUrl
                    .openConnection();
            // 第三步：为HttpURLConnection对象设置必要的参数（是否允许输入数据、连接超时时间、请求方式）
            connection.setConnectTimeout(CONNECT_OUT_TIME);
            connection.setReadTimeout(CONNECT_OUT_TIME);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            // 第四步：开始读取服务器返回数据
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            final StringBuffer buffer = new StringBuffer();
            String str = null;
            while ((str = reader.readLine()) != null) {
                buffer.append(str);
            }
            reader.close();
            Log.i("resjson",buffer.toString());

         /*   handler.post(new Runnable() {

                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    response.setText(buffer.toString());
                }
            });*/

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void doPost() {

        try {
            // 第一步：创建必要的URL对象
            URL httpUrl = new URL(url);
            // 第二步：根据URL对象，获取HttpURLConnection对象
            HttpURLConnection connection = (HttpURLConnection) httpUrl
                    .openConnection();
            // 第三步：为HttpURLConnection对象设置必要的参数（是否允许输入数据、连接超时时间、请求方式）
            connection.setConnectTimeout(CONNECT_OUT_TIME);
            connection.setReadTimeout(CONNECT_OUT_TIME);
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            // 第四步：向服务器写入数据
            OutputStream out = connection.getOutputStream();
            String content = "name=" + name + "&pwd=" + pwd;// 无论服务器转码与否，这里不需要转码，因为Android系统自动已经转码为utf-8啦
            out.write(content.getBytes());
            out.flush();
            out.close();
            // 第五步：开始读取服务器返回数据
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            final StringBuffer buffer = new StringBuffer();
            String str = null;
            while ((str = reader.readLine()) != null) {
                buffer.append(str);
            }
            reader.close();
           /* handler.post(new Runnable() {
                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    response.setText(buffer.toString());
                }
            });*/

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        if (tag == 1) http://
                doGet();
        else if (tag == 2)
            doPost();
    }

}
