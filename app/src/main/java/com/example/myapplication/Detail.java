package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Detail extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        TextView BuildingName = (TextView)findViewById(R.id.BuildingName);
        TextView BuildingNumber = (TextView)findViewById(R.id.BuildingNumber);
        TextView BuildingInfo = (TextView)findViewById(R.id.BuildingInfo);
        TextView BuildingTag = (TextView)findViewById(R.id.BuildingTag);
        ImageView iv = (ImageView)findViewById(R.id.BuildingImage);

        Intent intent = getIntent(); // 보내온 Intent를 얻는다
        BuildingName.setText(intent.getStringExtra("Name"));
        BuildingNumber.setText(intent.getStringExtra("Number"));
        BuildingInfo.setText(intent.getStringExtra("Info"));
        BuildingTag.setText(intent.getStringExtra("Tag"));
        iv.setImageResource(intent.getIntExtra("Img", 0));

        final ArrayList<String> review=new ArrayList<String>();
        final ArrayAdapter Aadapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, review);
        final ListView reviewList=(ListView) findViewById(R.id.reviewList);
        reviewList.setAdapter(Aadapter);
        TextView nothing=(TextView) findViewById(R.id.empty);

        reviewList.setEmptyView(nothing);
        //review.add("6203 강의실 뒤편에 의자 파손된 자리 있음.(예시)");
        //review.add("3층 남자화장실 세면대 물이 나오지 않음.(예시)");

        Aadapter.notifyDataSetChanged();

    } // end of onCreate
}
