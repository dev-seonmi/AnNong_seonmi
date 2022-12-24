package com.example.annong_seonmi;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.service.autofill.FieldClassification;
import android.text.PrecomputedText;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

public class Activity_TableSetting extends AppCompatActivity {

    Spinner spinner_crops_name;
    TableLayout table_layout;
    Button btn_add_row;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_setting);

        /* 작물 리스트 불러오기 */
        ArrayList<String> crops_name_list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("crops_name.txt")));
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

        /* 테이블 추가 */
        table_layout = (TableLayout) findViewById(R.id.table_layout);
        btn_add_row = (Button) findViewById(R.id.btn_add_row);
        btn_add_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               add_tableRow();
            }
        });

    }

    /* 테이블 행 추가 */
    void add_tableRow() {
        DisplayMetrics dm = getApplicationContext().getResources().getDisplayMetrics();
//        Toast.makeText(this, String.valueOf(dm.widthPixels), Toast.LENGTH_SHORT).show();

        TableRow tableRow = new TableRow(this);
        tableRow.setBackgroundColor(Color.parseColor("#FFFACD"));
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT
//                , LinearLayout.LayoutParams.MATCH_PARENT, 1);

        /* 컬럼명 */
        EditText editText = new EditText(this);
        editText.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        editText.setWidth(dm.widthPixels/10*4);
        editText.setSingleLine();
        tableRow.addView(editText);

        /* 데이터 형식 */
        Spinner spinner = new Spinner(this);
        List<String> spinnerList = new ArrayList<String>();
        spinnerList.add("숫자");
        spinnerList.add("텍스트");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, spinnerList);
        arrayAdapter.setDropDownViewResource(com.google.android.material.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        tableRow.addView(spinner);

        /* 필수 입력 */
        CheckBox checkBox = new CheckBox(this);
        tableRow.addView(checkBox);

        /* 삭제 */
//        ImageButton button = new ImageButton(this);
//        button.setImageResource(R.drawable.delete);
//        button.setBackgroundColor(Color.parseColor("#ffffffff"));
        Button button = new Button(this);
        button.setBackgroundResource(R.drawable.delete);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(dm.widthPixels/10, dm.widthPixels/10);
        button.setLayoutParams(params);
        tableRow.addView(button);

        table_layout.addView(tableRow);
//        table_layout.addView(tableRow, params);

        /* 삭제 이벤트 */
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                table_layout.removeView(tableRow);
            }
        });
    }
}