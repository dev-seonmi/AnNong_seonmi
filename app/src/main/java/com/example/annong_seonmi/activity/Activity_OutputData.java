package com.example.annong_seonmi.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.annong_seonmi.R;

public class Activity_OutputData extends AppCompatActivity {

    String crop_name;

    TextView textView_crop_name;
    Button btn_delete_table, btn_delete_data;
    FrameLayout output_data_frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_data);

        Intent intent = getIntent();
        crop_name = intent.getStringExtra("crop_name");

        textView_crop_name = (TextView) findViewById(R.id.textview_crop_name);
        textView_crop_name.setText(crop_name);

        /* 테이블 삭제 */
        btn_delete_table = (Button) findViewById(R.id.btn_delete_table);
        btn_delete_table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        /* 데이터 삭제 */
        btn_delete_data = (Button) findViewById(R.id.btn_delete_data);
        btn_delete_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        output_data_frame = (FrameLayout) findViewById(R.id.output_data_frame);
//
//        TableLayout tableLayout = new TableLayout(this);
//        TableRow tableRow = (TableRow) findViewById(R.id.add_table_data_row);
//        tableLayout.addView(tableRow);
//        output_data_frame.addView(tableLayout);
    }

}