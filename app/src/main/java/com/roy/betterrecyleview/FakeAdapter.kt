package com.roy.betterrecyleview

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by roy on 2017/3/9.
 */

class FakeAdapter(private val layoutRes: Int) : RecyclerView.Adapter<FakeAdapter.MyViewHolder>() {
    private var layoutInflater: LayoutInflater? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        layoutInflater = LayoutInflater.from(parent.context)
        return MyViewHolder(layoutInflater!!.inflate(layoutRes, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)
}
