package com.example.lenovo.mvp.persenter;

import com.example.lenovo.mvp.OnFinishListener;
import com.example.lenovo.mvp.bean.News;
import com.example.lenovo.mvp.monder.ShowModel;
import com.example.lenovo.mvp.monder.ShowModelImpl;
import com.example.lenovo.mvp.view.ShowView;

/**
 * Created by Lenovo on 2017/10/30.
 */

public class ShowPresenterImpl implements ShowPresenter,OnFinishListener {
    ShowView showView;
    private final ShowModel showModel;
    //初始化
    public ShowPresenterImpl(ShowView showView){
        this.showView  = showView;
        //多态
        showModel = new ShowModelImpl();


    }

    @Override
    public void relevance() {
        //p跟m关联
        showModel.getData(this);
    }

    @Override
    public void onSuccess(News news) {
        //关联view
        showView.showData(news);
    }
}
