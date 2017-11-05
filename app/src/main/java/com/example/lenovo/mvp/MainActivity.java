package com.example.lenovo.mvp;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.example.lenovo.mvp.adapter.MyAdapter;
import com.example.lenovo.mvp.bean.News;
import com.example.lenovo.mvp.persenter.ShowPresenterImpl;
import com.example.lenovo.mvp.view.ShowView;

public class MainActivity extends AppCompatActivity implements ShowView,SwipeRefreshLayout.OnRefreshListener {
    private RecyclerView rlr;
    private SwipeRefreshLayout sp;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找控件
        rlr =findViewById(R.id.recycler);
        sp = findViewById(R.id.swipeRefresh);
        sp.setOnRefreshListener(this);
        // 顶部刷新的样式
        sp.setColorScheme(android.R.color.holo_red_light, android.R.color.holo_green_light, android.R.color.holo_blue_bright, android.R.color.holo_orange_light);
        //设置页面的背景，不会随着下拉加载而移动
        //swipeLayout.setBackgroundResource(R.drawable.ic_launcher);
        //设置成布局管理器
        linearLayoutManager = new LinearLayoutManager(this);
        rlr.setLayoutManager(linearLayoutManager);

        //p关联v
        ShowPresenterImpl presenter = new ShowPresenterImpl(this);
        //p关联m 做网络请求
        presenter.relevance();
    }

    @Override
    public void showData(News news) {
        MyAdapter adapter = new MyAdapter(this,news);
        rlr.setAdapter(adapter);
    }

    @Override
    public void onRefresh() {
        // 显示刷新动画
        sp.setRefreshing(true);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                // 刷新完毕，结束刷新动画
                sp.setRefreshing(false);
            }
        }, 500);
    }
}
