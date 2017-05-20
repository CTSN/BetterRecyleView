package com.roy.betterrecyleview

import android.support.annotation.IdRes
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.text.Layout
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.RadioGroup

class MainActivity : AppCompatActivity(), RadioGroup.OnCheckedChangeListener {

    private var drawerLayout: DrawerLayout? = null
    private var drawerToggle: ActionBarDrawerToggle? = null
    private var rv_normal: RecyclerView? = null
    private var rv_better: RecyclerView? = null
    private var rv_feed_better: RecyclerView? = null
    private var rg_selecte: RadioGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpActionBarAndDrawer()

        initRecylerView()

        initRadioGroup()
    }

    private fun initRadioGroup() {

        rg_selecte = findViewById(R.id.rg_select) as RadioGroup

        rg_selecte!!.setOnCheckedChangeListener(this)

    }


    private fun initRecylerView() {
        rv_normal = findViewById(R.id.rv_normal) as RecyclerView
        rv_better = findViewById(R.id.rv_better) as RecyclerView
        rv_feed_better = findViewById(R.id.rv_feed_root) as RecyclerView

        rv_normal!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_better!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_feed_better!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        rv_normal!!.adapter = SectionAdapter(this, 1)
        rv_feed_better!!.adapter = SectionAdapter(this, 2)
        rv_better!!.adapter = SectionAdapter(this, 3)
    }

    internal fun setUpActionBarAndDrawer() {
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)

        drawerLayout = findViewById(R.id.drawer_layout) as DrawerLayout
        drawerToggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.consider_angle, R.string.ignore_child_requests)
        drawerToggle!!.syncState()

        drawerLayout!!.setDrawerListener(drawerToggle)
    }

    override fun onCheckedChanged(group: RadioGroup, @IdRes checkedId: Int) {
        initShowRecyler(checkedId)
    }

    internal fun initShowRecyler(checkid: Int) {
        rv_better!!.visibility = if (checkid == R.id.rb_better) View.VISIBLE else View.GONE
        rv_feed_better!!.visibility = if (checkid == R.id.rb_feed_better) View.VISIBLE else View.GONE
        rv_normal!!.visibility = if (checkid == R.id.rb_normal) View.VISIBLE else View.GONE

    }

}
