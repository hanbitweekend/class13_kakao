package com.hanbit.kakao2.service;

import com.hanbit.kakao2.domain.MessageBean;

import java.util.ArrayList;

/**
 * Created by hb2000 on 2017-01-10.
 */

public interface MessageService {
    public void write(MessageBean msg);
    public ArrayList<MessageBean> list();
    public ArrayList<MessageBean> findByWriter(String id);
    public MessageBean findBySeq(int seq);
    public int count();
    public int countByWriter(String id);
    public void updateMessage(MessageBean msg);
    public void deleteMessage(int seq);
}
