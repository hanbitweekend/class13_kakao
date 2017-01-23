package com.hanbit.kakao2.presentaion.message;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.telephony.SmsManager;
import android.widget.Toast;
/**
 * Created by hb2000 on 2017-01-21.
 */

public class JavascriptInterface {
    Context context;

    public JavascriptInterface(Context context) {
        this.context = context;
    }
    @android.webkit.JavascriptInterface
    public void showToast(String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }
    @android.webkit.JavascriptInterface
    public void savePreferences(String key, String value){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.commit();
    }
    @android.webkit.JavascriptInterface
    public void vibrate(long milliseconds){
        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(milliseconds);
    }
    @android.webkit.JavascriptInterface
    public void sendSMS(String phone, String message){
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phone, null, message, null, null);
    }


}
