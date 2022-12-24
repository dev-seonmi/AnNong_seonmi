package com.example.annong_seonmi;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Activity_TableSetting extends AppCompatActivity {

    TextView textView_crop_name;
    TableLayout table_layout;
    Button btn_add_row, btn_delete_row;

    String crop_name;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_setting);

        textView_crop_name = (TextView) findViewById(R.id.textView_crop_name);

        /* 인텐트 시작 -> 새 인텐트에서 종료 시 작물 이름 반환 -> 작물 이름 확인 */
        intent = new Intent(Activity_TableSetting.this, activity_select_crop_name.class);
        intent.putExtra("init", "setting_table");
//        startActivityForResult(intent, 1);
        activityResultLauncher.launch(intent);



        check_table_data();


        table_layout = (TableLayout) findViewById(R.id.table_layout);

        /* 테이블 로우 추가 */
        btn_add_row = (Button) findViewById(R.id.btn_add_row);
        btn_add_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               add_tableRow();
            }
        });

        /* 테이블 로우 삭제 */
        btn_delete_row = (Button) findViewById(R.id.btn_delete_row);
        btn_delete_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete_tableRow();
            }
        });
    }

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if(result.getResultCode() == RESULT_OK) {
                    crop_name = intent.getStringExtra("crop_name");
                    Log.e("TAG", "작물명<< " +crop_name);
                    textView_crop_name.setText(crop_name);
                }
            });


    /* 기존 테이블 설정 확인 -> 화면 구성 */
    void check_table_data() {
        int count = 0;
        /*
            파
            일

            열
            어
            서

            데
            이
            터
            가

            있
            는
            지

            확
            인
            하
            고

            개
            수
            만
            큼

            for(int i=0; i<count; i++) {
                TableRow tableRow = (TableRow) LayoutInflater.from(this).inflate(R.layout.table_setting_add_row, null);
                ((TextView)tableRow.getChildAt(1)).setText("작물명"); // 작물명 입력
                ((Spinner)tableRow.getChildAt(2)).setSelection(1); // 숫자 0, 텍스트 1
                ((CheckBox)tableRow.getChildAt(3)).setChecked(true); // 필수이면 true, 아니면 false
                table_layout.addView(tableRow);
            }

            반
            복
         */


    }

    /* 테이블 행 추가 */
    void add_tableRow() {
        TableRow tableRow = (TableRow) LayoutInflater.from(this).inflate(R.layout.table_setting_add_row, null);
        table_layout.addView(tableRow);
    }

    /* 테이블 행 삭제 */
    void delete_tableRow() {
        ArrayList<Integer> delete_list = new ArrayList<>();

        for(int i=0; i<table_layout.getChildCount(); i++) {
            TableRow tableRow = (TableRow) table_layout.getChildAt(i);
            CheckBox checkBox = (CheckBox) tableRow.getChildAt(0);
            if(checkBox.isChecked()) {
                delete_list.add(i);
                Log.e("TAG", i+"행 추가");
            }
        }

        int count = 0;
        for(int i=0; i<delete_list.size(); i++) {
            Log.e("TAG", delete_list.get(i) +"번째 행 삭제");
            table_layout.removeViewAt(delete_list.get(i)-count);
            count++;
        }

        delete_list.clear();
    }
}