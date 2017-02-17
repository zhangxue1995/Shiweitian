package com.dreamers.shiweitian;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ListView;

import com.dreamers.shiweitian.Home_page.SystemBarTintManager;
import com.dreamers.shiweitian.Report_page.Report_merchant;

import java.util.ArrayList;

/**
 * Created by stzha on 2017/1/10.
 */

public class Login_page extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);setTheme(R.style.AppBarTheme);
        setContentView(R.layout.login_page);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setTintColor(Color.parseColor("#FF4CAF50"));//设置状态栏颜色
        if(Build.VERSION.SDK_INT>=21){
            getSupportActionBar().setElevation(0);
        }
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

//        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setHomeAsUpIndicator(R.drawable.back);
        actionBar.setTitle("                登录");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Login_page.this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}