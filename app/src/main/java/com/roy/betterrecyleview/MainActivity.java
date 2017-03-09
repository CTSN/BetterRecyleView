package com.roy.betterrecyleview;

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

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private RecyclerView rv_normal;
    private RecyclerView rv_better;
    private RecyclerView rv_feed_better;
    private CheckBox cb_consider_angle;
    private CheckBox cb_ignore_child_requests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("TAG", View.VISIBLE + "--" + View.GONE);
        setUpActionBarAndDrawer();

        initRecylerView();

        initCheckBox();
    }

    private void initCheckBox() {
        cb_consider_angle = (CheckBox) findViewById(R.id.cb_consider_angle);
        cb_ignore_child_requests = (CheckBox) findViewById(R.id.cb_ignore_child_requests);

        cb_consider_angle.setOnCheckedChangeListener(this);
        cb_ignore_child_requests.setOnCheckedChangeListener(this);
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
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int id = buttonView.getId();
        switch (id){
            case R.id.cb_consider_angle:
                rv_better.setVisibility(isChecked ? View.VISIBLE : View.GONE);
                break;
            case R.id.cb_ignore_child_requests:
                rv_feed_better.setVisibility(isChecked ? View.VISIBLE : View.GONE);
                break;
            default:
                break;
        }

        if (rv_better.getVisibility() == View.GONE&&rv_feed_better.getVisibility() == View.GONE){
            Log.i("TAG","---");
            rv_normal.setVisibility(View.VISIBLE);
        }

    }

}
