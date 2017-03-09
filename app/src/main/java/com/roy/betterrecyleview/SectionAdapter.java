package com.roy.betterrecyleview;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by roy on 2017/3/9.
 */

public class SectionAdapter extends RecyclerView.Adapter<SectionAdapter.MyViewHolder>{


    private LayoutInflater layoutInflater;
    private Context context;
    private static int color;
    public SectionAdapter(Context context,int i){
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        switch (i){
            case 2:
                color = R.color.cardview_shadow_end_color;
                break;
            case 3:
                color = R.color.cardview_shadow_start_color;
                break;
            case 1:
                color = Color.WHITE;
                break;
        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(layoutInflater.inflate(R.layout.item_section,null));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind();
    }

    @Override
    public int getItemCount() {
        return 10;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        RecyclerView rv_sevtion;
        LinearLayoutManager linearLayoutManager;
        FakeAdapter fakeAdapter;

        public MyViewHolder(View view){
            super(view);
            rv_sevtion = (RecyclerView)view.findViewById(R.id.rv_section);
            rv_sevtion.setBackgroundColor(color);
            linearLayoutManager = new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false);
            fakeAdapter = new FakeAdapter(R.layout.item_card_hor);

            rv_sevtion.setLayoutManager(linearLayoutManager);
            rv_sevtion.setAdapter(fakeAdapter);
        }

        public void bind(){
            rv_sevtion.scrollToPosition(0);
        }
    }
}
