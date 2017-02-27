package com.sample.hackdaniels;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by User1 on 2/18/2017.
 */

public class BarHost extends AppCompatActivity{

    private FragmentTabHost mTabHost;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.barhost);

        Intent intent = getIntent();
        String barName = intent.getExtras().getString("name");

        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.bartabs);

        Bundle args = new Bundle();
        args.putString("name",barName);

        mTabHost.addTab(mTabHost.newTabSpec("details").setIndicator("Details"),
                Details.class, args);
        mTabHost.addTab(mTabHost.newTabSpec("location").setIndicator("Location"),
                Map.class, args);

        TextView bn = (TextView) findViewById(R.id.barName);
        bn.setText(barName);

    }

}
