package com.example.app2.persenter;


import com.example.app2.OnFinishListener;
import com.example.app2.bean.bean;
import com.example.app2.model.beanmondelister;
import com.example.app2.view.beanview;

/**
 * Created by Lenovo on 2017/10/30.
 */

public class beanpersenterinter implements beanpersenter ,OnFinishListener {
    beanview beanview;
    private final beanmondelister beanmondelister;

    //初始化
    public beanpersenterinter(beanview beanview){
        this.beanview  = beanview;
        //多态
        beanmondelister = new beanmondelister();
    }
    @Override
    public void relevance() {
        //p跟m关联
        beanmondelister.getData(this);
    }

    @Override
    public void onSuccess(bean bean) {
        //关联view
        beanview.showData(bean);
    }
}
