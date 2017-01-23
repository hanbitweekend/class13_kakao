package com.hanbit.kakao2.util;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;

/**
 * Created by hb2000 on 2017-01-10.
 */

public class Phone {
    private Context context;
    private Activity activity;

    public Phone(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    }

    public void dial(String phoneNo){
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNo));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public void directCall(String phoneNo){
        Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+phoneNo));
        if(ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(activity,new String[]{Manifest.permission.CALL_PHONE},2);
            return;
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
       // context.startActivity(intent);
    }
}
