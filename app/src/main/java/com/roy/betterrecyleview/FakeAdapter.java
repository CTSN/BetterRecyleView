package com.roy.betterrecyleview;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by roy on 2017/3/9.
 */

public class FakeAdapter extends RecyclerView.Adapter<FakeAdapter.MyViewHolder> {


    private int layoutRes;
    private LayoutInflater layoutInflater;

    public FakeAdapter(int res){
        this.layoutRes = res;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        layoutInflater = LayoutInflater.from(parent.getContext());
        return new MyViewHolder(layoutInflater.inflate(layoutRes,parent,false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public MyViewHolder(View view){
            super(view);
        }
    }
}
