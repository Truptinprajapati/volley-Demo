package com.example.trupti.myjsonwithrecyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by pc41 on 01-06-2017.
 */

//List<ItemListPojo> itemList;
//        Context context;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    List<ItemListPojo> iteamlist;
    Context context;

    public MyAdapter(List<ItemListPojo> itemList, Context context) {
        this.iteamlist=itemList;
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.child_list_layout,parent,false);
        return  new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemListPojo listiteam=iteamlist.get(position);
        holder.tvTitle.setText(listiteam.getTitle());
        holder.tvDescription.setText(listiteam.getDescription());
        Picasso.with(context).load(listiteam.getIcon()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return iteamlist.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle, tvDescription;
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_header);
            tvDescription = (TextView) itemView.findViewById(R.id.tv_content);
            imageView = (ImageView) itemView.findViewById(R.id.image_view);
        }
    }
}
