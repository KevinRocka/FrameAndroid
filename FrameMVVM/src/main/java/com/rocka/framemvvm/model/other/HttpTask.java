package com.rocka.framemvvm.model.other;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;


import com.rocka.framemvvm.model.bean.RequestBean;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.InputStream;

/**
 * @Author：<a href="kevin.rocka@gmail.com">Kevin Rocka</a>
 * @version: 1.0
 * @Time: 2016/12/3 17:33
 * @Description: 网络请求简单工具类
 */
public abstract class HttpTask {

    private String mPath;

    private final int REQUEST_SUCCESS = 1;

    private final int REQUEST_FAILED = 0;

    public HttpTask path(String path) {
        this.mPath = path;
        return this;
    }

    public HttpTask execute() {
        // 模拟网络请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    HttpClient client = new DefaultHttpClient();
                    HttpGet get = new HttpGet(mPath);
                    HttpResponse response = client.execute(get);
                    if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                        InputStream in = response.getEntity().getContent();
                        StringBuffer buffer = new StringBuffer();
                        byte[] out = new byte[2048];
                        while (in.read(out) != -1) {
                            String result = new String(out);
                            buffer.append(result);
                        }
                        if (!TextUtils.isEmpty(buffer)) {
                            JSONObject object = new JSONObject(buffer.toString());
                            RequestBean bean = onParse(object);
                            Message message = new Message();
                            message.what = REQUEST_SUCCESS;
                            message.obj = bean;
                            mHandler.sendMessage(message);
                        }
                    }else{
                        mHandler.sendEmptyMessage(REQUEST_FAILED);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    mHandler.sendEmptyMessage(REQUEST_FAILED);
                }
            }
        }).start();
        return this;
    }

    public abstract void onRequestSuccess(RequestBean bean);

    public abstract void onRequestFailed();

    public abstract RequestBean onParse(JSONObject object);


    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case REQUEST_FAILED:
                    onRequestFailed();
                    break;
                case REQUEST_SUCCESS:
                    onRequestSuccess((RequestBean) msg.obj);
                    break;
            }
        }
    };

}
