package com.bw.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.bean.Goods;
import com.bw.wangqing20181221.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    public final static int LINEAR_TYPE=0;//线性
    public final static int GRID_TYPE=1;//网格
    private int viewType=LINEAR_TYPE;
    private Context context;
    private List<Goods> list=new ArrayList<>();

    public MyAdapter(Context context){
        this.context=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = View.inflate(viewGroup.getContext(), R.layout.item_layout, null);//加载item布局


        ViewHolder viewholder = new ViewHolder(view);

        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewholder, int position) {
        final Goods goods=list.get(position);//拿到商品，开始赋值

        viewholder.itemView.setTag(list.get(position));

        //增加点击事件
        viewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


// onItemClickListener.onItemClick(goods);
            }
        });

        viewholder.title.setText(goods.getTitle());
        //viewholder.price.setText(goods.getPrice());
        //由于我们的数据图片提供的不标准，所以我们需要切割得到图片
        String imageurl = "https" + goods.getImages().split("https")[1];
        Log.i("dt", "imageUrl: " + imageurl);
        imageurl = imageurl.substring(0, imageurl.lastIndexOf(".jpg") + ".jpg".length());
        Glide.with(context).load(imageurl).into(viewholder.pic);//加载图片
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return viewType;
    }

    //设置item的视图类型
    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,price;
        ImageView pic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pic=itemView.findViewById(R.id.image);
            title=itemView.findViewById(R.id.text_title);
            price=itemView.findViewById(R.id.text_price);
        }
    }
    /**
     * 添加集合的数据
     */

    public void addAll(List<Goods> data) {
        if (data!=null){
            list.addAll(data);
        }
    }
    /**
     * 清空数据
     *
     */

    public void clearList(){
        list.clear();
    }


}
