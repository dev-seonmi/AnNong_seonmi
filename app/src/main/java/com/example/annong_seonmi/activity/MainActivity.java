package com.example.annong_seonmi.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.annong_seonmi.R;

public class MainActivity extends AppCompatActivity {

    Button btn_table_setting, btn_input_data, btn_output_data, btn_app_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_table_setting = (Button) findViewById(R.id.btn_table_setting);
        btn_input_data = (Button) findViewById(R.id.btn_input_data);
        btn_output_data = (Button) findViewById(R.id.btn_output_data);
        btn_app_setting = (Button) findViewById(R.id.btn_app_setting);

        btn_table_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, activity_select_crop_name.class);
                intent.putExtra("startPage", 1);
                startActivity(intent);
            }
        });

        btn_input_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity_InputData.class);
                startActivity(intent);
            }
        });

        btn_output_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, activity_select_crop_name.class);
                intent.putExtra("startPage", 3);
                startActivity(intent);
            }
        });

        btn_app_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity_AppSetting.class);
                startActivity(intent);
            }
        });
    }
}