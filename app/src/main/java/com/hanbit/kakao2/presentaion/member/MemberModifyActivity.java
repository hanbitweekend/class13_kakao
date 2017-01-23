package com.hanbit.kakao2.presentaion.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hanbit.kakao2.R;
import com.hanbit.kakao2.domain.MemberBean;
import com.hanbit.kakao2.service.MemberService;
import com.hanbit.kakao2.service.MemberServiceImpl;

public class MemberModifyActivity extends AppCompatActivity implements View.OnClickListener{
    EditText etPass,etName,etPhone,etAddr,etPhoto;
    TextView tvID;
    Button btUpdate,btCancel;
    MemberBean member;
    MemberService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_modify);
        service = new MemberServiceImpl(this.getApplicationContext());
        Intent intent = this.getIntent();
        String id = intent.getExtras().getString("id");
        member = service.searchById(id);
        tvID = (TextView) findViewById(R.id.tvID);
        etPass = (EditText) findViewById(R.id.etPass);
        etName = (EditText) findViewById(R.id.etName);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etAddr = (EditText) findViewById(R.id.etAddr);
        etPhoto = (EditText) findViewById(R.id.etPhoto);
        btUpdate = (Button) findViewById(R.id.btUpdate);
        btCancel = (Button) findViewById(R.id.btCancel);
        btUpdate.setOnClickListener(this);
        btCancel.setOnClickListener(this);
        tvID.setText(member.getId());
        etPass.setHint(member.getPw());
        etName.setHint(member.getName());
        etAddr.setHint(member.getAddr());
        etPhone.setHint(member.getPhone());
        etPhoto.setHint(member.getPhoto());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btUpdate:
                MemberBean temp = new MemberBean();
                temp.setId(tvID.getText().toString());
                temp.setPw((etPass.getText().toString().equals(""))?member.getPw():etPass.getText().toString());
                temp.setName((etName.getText().toString().equals(""))?member.getName():etName.getText().toString());
                temp.setAddr((etAddr.getText().toString().equals(""))?member.getAddr():etAddr.getText().toString());
                temp.setPhone((etPhone.getText().toString().equals(""))?member.getPhone():etPhone.getText().toString());
                temp.setPhoto((etPhoto.getText().toString().equals(""))?member.getPhoto():etPhoto.getText().toString());
                service.modify(temp);
                break;
            case R.id.btCancel:
                break;
        }
        Intent intent = new Intent(MemberModifyActivity.this, MemberDetailActivity.class);
        intent.putExtra("id",member.getId());
        startActivity(intent);
    }
}
