package com.hanbit.kakao2.presentaion.member;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.hanbit.kakao2.R;
import com.hanbit.kakao2.domain.MemberBean;
import com.hanbit.kakao2.service.MemberService;
import com.hanbit.kakao2.service.MemberServiceImpl;
import com.hanbit.kakao2.util.MemberAdapter;

import java.util.ArrayList;

public class MemberListActivity extends AppCompatActivity {
    MemberService service;
    ListView lv_member_list;
    final String[] arr = new String[1];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);
        service = new MemberServiceImpl(this.getApplicationContext());
        lv_member_list = (ListView) findViewById(R.id.lv_member_list);
        ArrayList<MemberBean> list = service.list();
        Log.d("Service 에서 리턴한 데이터 갯수:",String.valueOf(list.size()));
        lv_member_list.setAdapter(new MemberAdapter(list,this));
        lv_member_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int i, long l) {
                Object o = lv_member_list.getItemAtPosition(i);
                MemberBean member = (MemberBean) o;
                Toast.makeText(MemberListActivity.this,"선택한 이름"+member.getName(),
                    Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MemberListActivity.this, MemberDetailActivity.class);
                intent.putExtra("id",member.getId());
                startActivity(intent);
            }
        });
        lv_member_list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View v, int i, long l) {
                Object o = lv_member_list.getItemAtPosition(i);
                MemberBean member = (MemberBean) o;
                arr[0] = member.getId();
                new AlertDialog.Builder(MemberListActivity.this)
                        .setTitle("삭제 ?")
                        .setMessage("정말로 삭제하시겠습니까?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                service.unregist(arr[0]);
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
                return true;
            }
        });
    }
}
