package com.roy.betterrecyleview;

import android.support.annotation.IdRes;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private RecyclerView rv_normal;
    private RecyclerView rv_better;
    private RecyclerView rv_feed_better;
    private RadioGroup rg_selecte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpActionBarAndDrawer();

        initRecylerView();

        initRadioGroup();
    }

    private void initRadioGroup() {

        rg_selecte = (RadioGroup)findViewById(R.id.rg_select);

        rg_selecte.setOnCheckedChangeListener(this);

    }


    private void initRecylerView() {
        rv_normal = (RecyclerView) findViewById(R.id.rv_normal);
        rv_better = (RecyclerView) findViewById(R.id.rv_better);
        rv_feed_better = (RecyclerView) findViewById(R.id.rv_feed_root);

        rv_normal.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv_better.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv_feed_better.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        rv_normal.setAdapter(new SectionAdapter(this,1));
        rv_feed_better.setAdapter(new SectionAdapter(this,2));
        rv_better.setAdapter(new SectionAdapter(this,3));
    }

    void setUpActionBarAndDrawer() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.consider_angle, R.string.ignore_child_requests);
        drawerToggle.syncState();

        drawerLayout.setDrawerListener(drawerToggle);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        initShowRecyler(checkedId);
    }

    void initShowRecyler(int checkid){
        rv_better.setVisibility(checkid == R.id.rb_better?View.VISIBLE:View.GONE);
        rv_feed_better.setVisibility(checkid == R.id.rb_feed_better?View.VISIBLE:View.GONE);
        rv_normal.setVisibility(checkid == R.id.rb_normal?View.VISIBLE:View.GONE);

    }

}
