package com.cookandroid.project_db;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cookandroid.project_db.Network.NetworkDelete;

import java.util.ArrayList;

public class Custom_Adapter extends BaseAdapter {
    private Activity mAct;
    LayoutInflater mInflater;
    ArrayList<UserInfo> mUserInfoObjArrayListT;
    int mListLayout;

    public Custom_Adapter(Activity a, ArrayList<UserInfo> mUserInfoObjArr, int listLayout){
        mAct=a;
        mListLayout=listLayout;
        mUserInfoObjArrayListT=mUserInfoObjArr;
        mInflater=(LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setDatas(ArrayList<UserInfo> arrayList){
        mUserInfoObjArrayListT=arrayList;
    }


    @Override
    public int getCount() {
        return mUserInfoObjArrayListT.size();
    }

    @Override
    public Object getItem(int position) {
        return mUserInfoObjArrayListT.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) convertView=mInflater.inflate(mListLayout, parent, false);

        final TextView tvID=(TextView) convertView.findViewById(R.id.tv_id);
        tvID.setText(mUserInfoObjArrayListT.get(position).id);

        final TextView tvName=(TextView) convertView.findViewById(R.id.tv_name);
        tvID.setText(mUserInfoObjArrayListT.get(position).name);

        final TextView tvPhone=(TextView) convertView.findViewById(R.id.tv_phone);
        tvID.setText(mUserInfoObjArrayListT.get(position).phone);

        final TextView tvGrade=(TextView) convertView.findViewById(R.id.tv_grade);
        tvID.setText(mUserInfoObjArrayListT.get(position).grade);

        final TextView tvWriteTime=(TextView) convertView.findViewById(R.id.tv_write_time);
        tvID.setText(mUserInfoObjArrayListT.get(position).writeTime);

        Button updateButton=(Button) convertView.findViewById(R.id.btnUpdate);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button deleteButton=(Button) convertView.findViewById(R.id.btnDelete);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID=tvID.getText().toString();
                AlertDialog.Builder ad=new AlertDialog.Builder(mAct);
                ad.setTitle("삭제하기");
                ad.setMessage("사용자 ID: "+userID+"를 정말 사용하시겠습니까?");

                ad.setNegativeButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        new NetworkDelete(Custom_Adapter.this).execute(tvID.getText().toString());
                    }
                });
                ad.setPositiveButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(mAct,"취소하였습니다.",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        return convertView;
    }
}
