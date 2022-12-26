package com.example.annong_seonmi;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class activity_select_crop_name extends AppCompatActivity {

    ListView listView_crop_name;
    Button btn_add_new_crop;

    String crop_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_crop_name);

        Intent intent = getIntent();
        String init_intent = String.valueOf(intent.getStringExtra("init"));
        Log.e("TAG", "init_intent: " +init_intent);

        /* 작물 추가 */
        btn_add_new_crop = (Button) findViewById(R.id.btn_add_new_crop);
        if (init_intent.equals("setting_table")) {
            btn_add_new_crop.setVisibility(View.VISIBLE);
        } else if (init_intent.equals("output_data")){
            btn_add_new_crop.setVisibility(View.GONE);
        }
        btn_add_new_crop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(activity_select_crop_name.this);
                dialog.setTitle("작물 추가");
                dialog.setMessage("추가하실 작물명을 이름을 입력하세요");
                dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        /*
                            여
                            기
                            에

                            작
                            물

                            추
                            가
                            하
                            는

                            동
                            작

                            넣
                            어
                            죠
                         */
                    }
                });
            }
        });

        /* 작물 선택 */
        listView_crop_name = (ListView) findViewById(R.id.listView_crop_name);
        ArrayList<String> crop_name_list = new ArrayList<>();
        /*
            작
            물
            이
            름

            리
            스
            트
            에

            넣
            기
         */
        crop_name_list.add("딸기");
        crop_name_list.add("토마토");

        ArrayAdapter arrayAdapter = new ArrayAdapter(activity_select_crop_name.this, android.R.layout.simple_list_item_1, crop_name_list);
        listView_crop_name.setAdapter(arrayAdapter);

        listView_crop_name.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                crop_name = adapterView.getItemAtPosition(i).toString();
                Log.e("TAG", "작물명>> " +crop_name);
                intent.putExtra("crop_name", crop_name);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

    }
}
