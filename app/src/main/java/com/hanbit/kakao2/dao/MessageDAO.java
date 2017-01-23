package com.hanbit.kakao2.dao;

import android.content.Context;

import com.hanbit.kakao2.domain.MessageBean;

import java.util.ArrayList;

/**
 * Created by hb2000 on 2017-01-10.
 */

public class MessageDAO {
    public MessageDAO(Context applicationContext) {

    }

    public void write(MessageBean msg){}
    public ArrayList<MessageBean> list(){
        ArrayList<MessageBean> list = new ArrayList<MessageBean>();
        return list;
    }
    public ArrayList<MessageBean> findByWriter(String id){
        ArrayList<MessageBean> list = new ArrayList<MessageBean>();
        return list;
    }
    public MessageBean findBySeq(int seq){
        MessageBean msg = new MessageBean();
        return msg;
    }
    public int count(){
        int count = 0;
        return count;
    }
    public int countByWriter(String id){
        int count = 0;
        return count;
    }
    public void updateMessage(MessageBean msg){

    }
    public void deleteMessage(int seq){

    }
}
