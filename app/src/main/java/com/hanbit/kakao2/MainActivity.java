package com.hanbit.kakao2;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hanbit.kakao2.presentaion.help.HelpActivity;
import com.hanbit.kakao2.presentaion.member.MemberLoginActivity;
import com.hanbit.kakao2.presentaion.member.MemberRegistActivity;
import com.hanbit.kakao2.util.BackPressCloseHandler;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button regist_btn, menu_login, menu_help;
    LinearLayout help_center;
    TextView menu_home;
    View mCustomView;
    private BackPressCloseHandler backPressCloseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        menu_home = (TextView) findViewById(R.id.menu_home);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);
        mCustomView = LayoutInflater.from(MainActivity.this)
                .inflate(R.layout.main_custombar, null);
        actionBar.setCustomView(mCustomView);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        regist_btn = (Button) findViewById(R.id.regist_btn);
      //  help_center = (LinearLayout) findViewById(R.id.help_center);
        menu_login = (Button) mCustomView.findViewById(R.id.menu_login);
        menu_help = (Button) mCustomView.findViewById(R.id.menu_help);
        regist_btn.setOnClickListener(this);
       // help_center.setOnClickListener(this);
        menu_help.setOnClickListener(this);
        menu_login.setOnClickListener(this);
        backPressCloseHandler = new BackPressCloseHandler(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.regist_btn:
                startActivity(new Intent(MainActivity.this, MemberRegistActivity.class));
                break;

            case R.id.menu_help:
                startActivity(new Intent(MainActivity.this, HelpActivity.class));
                break;
            case R.id.menu_login:
                startActivity(new Intent(MainActivity.this, MemberLoginActivity.class));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        backPressCloseHandler.onBackPressed();
    }
}