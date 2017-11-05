package com.example.app2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.app2.R;
import com.example.app2.bean.bean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Lenovo on 2017/10/30.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    bean bean;

    public MyAdapter(Context context, bean bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item, null);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        List<bean.DataBean> data = bean.getData();
        bean.DataBean dataBean = data.get(0);
        String title = dataBean.getNotice().get(position).getNoticeTitle();
        String imageurl = dataBean.getImg().get(position).toString();
        myViewHolder.tv_title.setText(title);
        Picasso.with(context).load(imageurl).placeholder(R.mipmap.ic_launcher).into(myViewHolder.iv);
    }

    @Override
    public int getItemCount() {
        return bean.getData().size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView tv_title;
        private final ImageView iv;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            iv = itemView.findViewById(R.id.iv);

        }
    }
}
