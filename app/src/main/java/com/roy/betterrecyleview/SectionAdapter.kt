package com.roy.betterrecyleview

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by roy on 2017/3/9.
 */

class SectionAdapter(private val context: Context, i: Int) : RecyclerView.Adapter<SectionAdapter.MyViewHolder>() {


    private val layoutInflater: LayoutInflater

    init {
        layoutInflater = LayoutInflater.from(context)
        when (i) {
            2 -> color = R.color.cardview_shadow_end_color
            3 -> color = R.color.cardview_shadow_start_color
            1 -> color = Color.WHITE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(layoutInflater.inflate(R.layout.item_section, null))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return 10
    }


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        internal var rv_sevtion: RecyclerView
        internal var linearLayoutManager: LinearLayoutManager
        internal var fakeAdapter: FakeAdapter

        init {
            rv_sevtion = view.findViewById(R.id.rv_section) as RecyclerView
            rv_sevtion.setBackgroundColor(color)
            linearLayoutManager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
            fakeAdapter = FakeAdapter(R.layout.item_card_hor)

            rv_sevtion.layoutManager = linearLayoutManager
            rv_sevtion.adapter = fakeAdapter
        }

        fun bind() {
            rv_sevtion.scrollToPosition(0)
        }
    }

    companion object {
        private var color: Int = 0
    }
}
