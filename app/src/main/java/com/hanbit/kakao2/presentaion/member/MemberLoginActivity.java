package com.hanbit.kakao2.presentaion.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hanbit.kakao2.R;
import com.hanbit.kakao2.domain.MemberBean;
import com.hanbit.kakao2.service.MemberService;
import com.hanbit.kakao2.service.MemberServiceImpl;

public class MemberLoginActivity extends AppCompatActivity  implements View.OnClickListener{

    EditText etID, etPass;
    Button btLogin, btCancel;
    MemberService service;
    MemberBean member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_login);
        etID = (EditText) findViewById(R.id.etID);
        etPass = (EditText) findViewById(R.id.etPass);
        btLogin = (Button) findViewById(R.id.btLogin);
        btCancel = (Button) findViewById(R.id.btCancel);
        btLogin.setOnClickListener(this);
        btCancel.setOnClickListener(this);
        service = new MemberServiceImpl(this.getApplicationContext());
        member = new MemberBean();
    }

    @Override
    public void onClick(View v) {
        String id = etID.getText().toString();
        String pass = etPass.getText().toString();
        Log.d("넘어온 ID:",id);
        Log.d("넘어온 Pass:",pass);
        member.setId(id);
        member.setPw(pass);
        switch (v.getId()){
            case R.id.btLogin:
                boolean flag =  service.login(member);
                if(flag){
                    Toast.makeText(MemberLoginActivity.this,"SUCCESS",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(MemberLoginActivity.this, MemberListActivity.class));
                }else{
                    Toast.makeText(MemberLoginActivity.this,"FAIL",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btCancel: break;
        }

    }
}
