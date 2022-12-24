package com.example.annong_seonmi;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Activity_TableSetting extends AppCompatActivity {

    Spinner spinner_crops_name;
    TableLayout table_layout;
    Button btn_add_row, btn_delete_row;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_setting);

        /* 작물 리스트 불러오기 */
        ArrayList<String> crops_name_list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("crops.json")));
            String crops_name = reader.readLine();
            while(crops_name != null) {
                crops_name_list.add(crops_name);
                crops_name = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }        spinner_crops_name = (Spinner) findViewById(R.id.spinner_crops_name);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, crops_name_list);
        spinner_crops_name.setAdapter(arrayAdapter);

        /* 새 작물 추가 */
        spinner_crops_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0) {
                    
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        table_layout = (TableLayout) findViewById(R.id.table_layout);

        /* 테이블 로우 추가 */
        btn_add_row = (Button) findViewById(R.id.btn_add_row);
        btn_add_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               add_tableRow2();
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

    /* 테이블 행 추가1 */
//    void add_tableRow1() {
//        DisplayMetrics dm = getApplicationContext().getResources().getDisplayMetrics();
////        Toast.makeText(this, String.valueOf(dm.widthPixels), Toast.LENGTH_SHORT).show();
//
//        TableRow tableRow = new TableRow(this);
//        tableRow.setBackgroundColor(Color.parseColor("#FFFACD"));
////        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT
////                , LinearLayout.LayoutParams.MATCH_PARENT, 1);
//
//        /* 삭제 */
//        CheckBox checkBox1 = new CheckBox(this);
//        checkBox1.setWidth(dm.widthPixels/10);
//        tableRow.addView(checkBox1);
//
//        /* 컬럼명 */
//        EditText editText = new EditText(this);
//        editText.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
//        editText.setWidth(dm.widthPixels/10*4);
//        editText.setSingleLine();
//        tableRow.addView(editText);
//
//        /* 데이터 형식 */
//        Spinner spinner = new Spinner(this);
//        List<String> spinnerList = new ArrayList<String>();
//        spinnerList.add("숫자");
//        spinnerList.add("텍스트");
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, spinnerList);
//        arrayAdapter.setDropDownViewResource(com.google.android.material.R.layout.support_simple_spinner_dropdown_item);
//        spinner.setAdapter(arrayAdapter);
//        tableRow.addView(spinner);
//
//        /* 필수 입력 */
//        CheckBox checkBox2 = new CheckBox(this);
//        checkBox2.setWidth(dm.widthPixels/10);
//        tableRow.addView(checkBox2);
//
//
//        table_layout.addView(tableRow);
//    }

    /* 테이블 행 추가2 */
    void add_tableRow2() {
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