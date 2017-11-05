package com.example.app2.model;

import android.util.Log;
import android.widget.Toast;

import com.example.app2.OnFinishListener;
import com.example.app2.bean.bean;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import java.io.IOException;

import cz.msebera.android.httpclient.Header;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.loopj.android.http.AsyncHttpClient.log;

/**
 * Created by Lenovo on 2017/10/30.
 */

public class beanmondelister implements beanmondel{

    private OkHttpClient mOkHttpClient;

    @Override
    public void getData(final OnFinishListener listener) {
        String PATH="http://result.eolinker.com/6rdnXgZ20130cc07fd3b192ce2715f6df4113e76fe201df?uri=more";
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        asyncHttpClient.get(PATH, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                //直接加高到主线程
                Gson gson = new Gson();
                bean bean = gson.fromJson(responseString, bean.class);
                System.out.println("1234567890-09876567890-=-0987670-=-0987"+bean.toString());
                //接口回调
                if (listener!=null){
                    listener.onSuccess(bean);
                }

            }
        });

//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder()
//                .get()
//                .url(PATH)
//                .build();
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//            @Override
//            public void onResponse(Call call, final Response response) throws IOException {
//
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        String s = response.body().toString();
//
//                        Gson gson = new Gson();
//                        bean bean = gson.fromJson(s, bean.class);
//                        //接口回调
//                        if (listener!=null){
//                            listener.onSuccess(bean);
//                        }
//                    }
//                });
//
//            }
//        });
    }

}
