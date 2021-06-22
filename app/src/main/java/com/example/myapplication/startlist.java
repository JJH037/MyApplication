package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class startlist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startlist);

        final TextView startselect = findViewById(R.id.start_select);
        ListView listView = findViewById(R.id.listView);



        List<String> list = new ArrayList<>();
        list.add("6공학관");
        list.add("넉터");
        list.add("인문관");
        list.add("제11공학관");
        list.add("제10공학관");
        list.add("인문대교수연구동");
        list.add("제1물리관");
        list.add("지구관");
        list.add("제1사범관");
        list.add("생물관");
        list.add("제1도서관");
        list.add("정학관");
        list.add("약학연구동");
        list.add("예술관");
        list.add("조형관");
        list.add("미술관");
        list.add("음악관");
        list.add("넉터3");
        list.add("학생회관");
        list.add("화학관");
        list.add("금정회관");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String data = (String) parent.getItemAtPosition(position);

                MainActivity.startpoint = data;

                startselect.setText(data);














                // MainActivity.startpoint = data;
                // artpoly();
                Intent intent = new Intent(getApplicationContext(), destlist.class);
                startActivity(intent);



            }
        });




        // adapter.notifyDataSetChanged();



    }
}