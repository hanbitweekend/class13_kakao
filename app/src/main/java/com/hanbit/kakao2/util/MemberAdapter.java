package com.hanbit.kakao2.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hanbit.kakao2.R;
import com.hanbit.kakao2.domain.MemberBean;

import java.util.ArrayList;

/**
 * Created by hb2000 on 2017-01-14.
 */

public class MemberAdapter extends BaseAdapter {
    ArrayList<MemberBean> list;
    LayoutInflater inflater;
    private int[]photos={
            R.drawable.cupcake,
            R.drawable.donut,
            R.drawable.eclair,
            R.drawable.froyo,
            R.drawable.gingerbread,
            R.drawable.honeycomb,
            R.drawable.icecream,
            R.drawable.jellybean,
            R.drawable.kitkat,
            R.drawable.lollipop

    };

    public MemberAdapter(ArrayList<MemberBean> list, Context context) {
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size(); // 멤버 총 인원(= addapter count)
    }

    @Override
    public Object getItem(int i) {
        return list.get(i); // 멤버 instance
    }

    @Override
    public long getItemId(int i) {
        return i; // 배열의 id
    }

    @Override
    public View getView(int i, View v, ViewGroup g) {
        ViewHolder holder;
        if(v==null){
            v = inflater.inflate(R.layout.member_list,null);
            holder = new ViewHolder();
            holder.ivPhoto = (ImageView) v.findViewById(R.id.iv_photo);
            holder.tvName = (TextView) v.findViewById(R.id.tv_name);
            holder.tvPhone = (TextView) v.findViewById(R.id.tv_phone);
            v.setTag(holder);
        }else{
            holder = (ViewHolder) v.getTag();
        }
        holder.ivPhoto.setImageResource(photos[i]);
        holder.tvName.setText(list.get(i).getName());
        holder.tvPhone.setText(list.get(i).getPhone());
        return v;
    }
    // inner class
    static class ViewHolder{
        ImageView ivPhoto;
        TextView tvName;
        TextView tvPhone;
    }
}
