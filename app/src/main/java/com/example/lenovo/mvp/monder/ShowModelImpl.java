package com.example.lenovo.mvp.monder;

import android.support.v7.widget.RecyclerView;

import com.example.lenovo.mvp.OnFinishListener;
import com.example.lenovo.mvp.bean.News;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;
import cz.msebera.android.httpclient.Header;
/**
 * Created by Lenovo on 2017/10/30.
 */

public class ShowModelImpl implements ShowModel {


    @Override
    public void getData( final OnFinishListener listener) {
        String url ="http://www.93.gov.cn/93app/data.do?channelId=0&startNum=2";
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        asyncHttpClient.get(url, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                //直接加高到主线程
                Gson gson = new Gson();
                News news = gson.fromJson(responseString, News.class);

                //接口回调

                if (listener!=null){
                    listener.onSuccess(news);
                }

            }
        });

        /*//构建OK对象
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        //构建Request
        final Request request = new Request.Builder().url(url).build();
        //得到Call
        Call call = okHttpClient.newCall(request);
        //执行异步
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
            //直接回调到子线程
                String json = response.body().string();
                Gson gson = new Gson();
                News news = gson.fromJson(json, News.class);

                //接口回调

    if (listener!=null){
        listener.onSuccess(news);
    }
            }
        });*/


    }
}
