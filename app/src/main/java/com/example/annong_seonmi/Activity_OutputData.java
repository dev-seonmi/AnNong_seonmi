package com.example.annong_seonmi;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_OutputData extends AppCompatActivity {

    String crop_name;

    TextView textView_crop_name;
    Button btn_delete_table, btn_delete_data;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_data);

        textView_crop_name = (TextView) findViewById(R.id.textView_crop_name);

        Intent intent = new Intent(Activity_OutputData.this, activity_select_crop_name.class);
        intent.putExtra("init", "output_data");
        startActivityForResult(intent, 4);


        /* 테이블 삭제 */
        btn_delete_table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        /* 데이터 삭제 */
        btn_delete_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        switch (requestCode) {
            case Activity.RESULT_OK:
                crop_name = intent.getStringExtra("crop_name");
                textView_crop_name.setText(crop_name);
                break;
        }
    }
}