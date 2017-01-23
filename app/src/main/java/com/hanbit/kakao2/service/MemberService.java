package com.hanbit.kakao2.service;

import com.hanbit.kakao2.domain.MemberBean;

import java.util.ArrayList;

/**
 * Created by hb2000 on 2017-01-10.
 */

public interface MemberService {
    public void regist(MemberBean param); // createMember
    public ArrayList<MemberBean> list(); // readAll
    public ArrayList<MemberBean> searchByName(String name); // readGroup
    public MemberBean searchById(String id); // readOne
    public boolean login(MemberBean param);
    public int count(); // readCount
    public void modify(MemberBean param); // updateMember
    public void unregist(String id); // delet
}
