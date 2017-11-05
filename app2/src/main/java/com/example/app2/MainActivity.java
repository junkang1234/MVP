package com.example.app2;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.app2.adapter.MyAdapter;
import com.example.app2.bean.bean;
import com.example.app2.persenter.beanpersenterinter;
import com.example.app2.view.beanview;

public class MainActivity extends AppCompatActivity  implements beanview{
    private RecyclerView rlr;
    private LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找控件
        rlr =findViewById(R.id.recycler);
        linearLayoutManager = new LinearLayoutManager(this);
        rlr.setLayoutManager(linearLayoutManager);
        //p关联v
        beanpersenterinter presenter = new beanpersenterinter(this);
        //p关联m 做网络请求
        presenter.relevance();
    }
    @Override
    public void showData(bean bean) {
        MyAdapter adapter = new MyAdapter(this,bean);
        rlr.setAdapter(adapter);
    }
}