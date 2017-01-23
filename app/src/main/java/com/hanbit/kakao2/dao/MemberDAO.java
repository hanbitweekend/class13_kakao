package com.hanbit.kakao2.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.hanbit.kakao2.domain.MemberBean;

import java.util.ArrayList;

/**
 * Created by hb2000 on 2017-01-10.
 */

public class MemberDAO extends SQLiteOpenHelper {
    public MemberDAO(Context applicationContext) {
        super(applicationContext,"hanbit.db",null,1);
        this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS Member(\n" +
                "\tid TEXT PRIMARY KEY,\n" +
                "    pw TEXT,\n" +
                "    name TEXT,\n" +
                "    email TEXT,\n" +
                "    phone TEXT,\n" +
                "    photo TEXT,\n" +
                "    addr TEXT\n" +
                ");");
        db.execSQL("CREATE TABLE IF NOT EXISTS Message(\n" +
                "  \t_id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    sender TEXT,\n" +
                "    receiver TEXT,\n" +
                "    content TEXT,\n" +
                "    writeTime TEXT,\n" +
                "    id TEXT,\n" +
                "    FOREIGN KEY(id) REFERENCES Member(id)\n" +
                ");\n");

        db.execSQL("INSERT INTO Member(id,pw,name,email,phone,photo,addr)\n" +
                "VALUES('hong','1','홍길동','hong@test.com','010-1234-5678','default_profile','서울');");
        db.execSQL("INSERT INTO Member(id,pw,name,email,phone,photo,addr)\n" +
                "VALUES('kim','1','김유신','kim@test.com','010-1234-5678','default_profile','서울');");
        db.execSQL("INSERT INTO Member(id,pw,name,email,phone,photo,addr)\n" +
                "VALUES('lee','1','이순신','lee@test.com','010-1234-5678','default_profile','서울');");
        db.execSQL("INSERT INTO Member(id,pw,name,email,phone,photo,addr)\n" +
                "VALUES('park','1','박지성','park@test.com','010-1234-5678','default_profile','서울');");
        db.execSQL("INSERT INTO Member(id,pw,name,email,phone,photo,addr)\n" +
                "VALUES('yoo','1','유비','yoo@test.com','010-1234-5678','default_profile','서울');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(MemberBean param) { // createMember
        String sql = "";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }
    public ArrayList<MemberBean> selectAll() { // readAll
        ArrayList<MemberBean> list = new ArrayList<MemberBean>();
        String sql = "SELECT id,pw,name,email,phone,photo,addr FROM Member;";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor != null){
            Log.d("Member ","Exist !!");
            cursor.moveToFirst();
        }
        do{
           MemberBean member = new MemberBean();
            member.setId(cursor.getString(0));
            member.setPw(cursor.getString(1));
            member.setName(cursor.getString(2));
            member.setEmail(cursor.getString(3));
            member.setPhone(cursor.getString(4));
            member.setPhoto(cursor.getString(5));
            member.setAddr(cursor.getString(6));
            list.add(member);
        }while(cursor.moveToNext());
        Log.d("Member Count: ",String.valueOf(list.size()));
        return list;
    }
    public ArrayList<MemberBean> selectByName(String name) { // readGroup
        ArrayList<MemberBean> list = new ArrayList<MemberBean>();
        String sql = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);

        return list;
    }
    public MemberBean selectById(String id) { // readOne
        MemberBean member = new MemberBean();
        String sql = "SELECT id,pw,name,email,phone,photo,addr FROM Member WHERE id = '"+id+"';";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor.moveToNext()){
            Log.d("ID 결과:",cursor.getString(1));
            member.setId(cursor.getString(0));
            member.setPw(cursor.getString(1));
            member.setName(cursor.getString(2));
            member.setEmail(cursor.getString(3));
            member.setPhone(cursor.getString(4));
            member.setPhoto(cursor.getString(5));
            member.setAddr(cursor.getString(6));
        }else{
            member.setId("fail");
        }
        Log.d("한글깨짐 테스트",member.getName());
        return member;
    }
    public MemberBean login(MemberBean param){
        MemberBean member = new MemberBean();
        String sql = "SELECT id,pw,name,email,phone,photo,addr FROM Member WHERE id = '"+param.getId()
                +"' AND pw = '"+param.getPw()+"';";
        Log.d("login SQL:",sql);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor.moveToNext()){
            Log.d("ID 결과:",cursor.getString(1));
            member.setId(cursor.getString(0));
            member.setPw(cursor.getString(1));
            member.setName(cursor.getString(2));
            member.setEmail(cursor.getString(3));
            member.setPhone(cursor.getString(4));
            member.setPhoto(cursor.getString(5));
            member.setAddr(cursor.getString(6));
        }else{
            member.setId("fail");
        }
        Log.d("login result:",member.getId());
        return member;
    }
    public int count() { // readCount
        int count = 0;
        String sql = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        return count;
    }
    public void update(MemberBean param) { // updateMember
        String sql = "UPDATE Member SET pw = '"+param.getPw()+"', name = '"+param.getName()+"'," +
                " phone = '"+param.getPhone()+"', addr = '"+param.getAddr()+"' "
                +"', photo = '"+param.getPhoto()+"' "
                +" WHERE id = '"+param.getId()+"'";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }
    public void delete(String id) { // deleteMember
        String sql = "DELETE FROM Member WHERE id = '"+id+"';";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }



}
