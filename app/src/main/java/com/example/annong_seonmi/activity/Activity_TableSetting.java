package com.example.annong_seonmi.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.annong_seonmi.R;
import com.example.annong_seonmi.domain.CropMeta;
import com.example.annong_seonmi.domain.CropRowMeta;

import java.util.ArrayList;
import java.util.List;

public class Activity_TableSetting extends AppCompatActivity {

    TextView textView_crop_name;
    TableLayout table_layout;
    Button btn_add_row, btn_delete_row;

    CropMeta cropMetaData;
    String crop_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_setting);

        Intent intent = getIntent();
        crop_name = intent.getStringExtra("crop_name");

        textView_crop_name = (TextView) findViewById(R.id.textView_crop_name);
        textView_crop_name.setText(crop_name);

        initCropMetaData(crop_name);

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

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void initCropMetaData(String cropName){
        textView_crop_name.setText(crop_name);
        initCropRowMetaData(cropMetaData.getRows());
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void initCropRowMetaData(List<CropRowMeta> cropRowMetaData){
        for(CropRowMeta rowMeta: cropRowMetaData){
            TableRow tableRow = (TableRow) LayoutInflater.from(this).inflate(R.layout.add_table_setting_row, null);
            ((EditText) tableRow.getVirtualChildAt(1)).setText(rowMeta.getColumnName());
            ((Spinner) tableRow.getVirtualChildAt(2)).setSelection(rowMeta.getDataTypeIndex());
            ((CheckBox) tableRow.getVirtualChildAt(3)).setChecked(rowMeta.isRequired());
            table_layout.addView(tableRow);
        }
    }

    /* 테이블 행 추가 */
    void add_tableRow() {
        TableRow tableRow = (TableRow) LayoutInflater.from(this).inflate(R.layout.add_table_setting_row, null);
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
            }
        }

        int count = 0;
        for(int i=0; i<delete_list.size(); i++) {
            table_layout.removeViewAt(delete_list.get(i)-count);
            count++;
        }

        delete_list.clear();
    }
}