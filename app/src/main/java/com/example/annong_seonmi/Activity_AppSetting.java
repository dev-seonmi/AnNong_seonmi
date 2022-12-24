package com.example.annong_seonmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_AppSetting extends AppCompatActivity {

    TextView textView_measure, textView_wait;
    EditText editText_measure, editText_wait;
    Button btn_measure, btn_wait, btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_setting);

        textView_measure = (TextView) findViewById(R.id.textView_measure);
        editText_measure = (EditText) findViewById(R.id.editText_measure);
        btn_measure = (Button) findViewById(R.id.btn_measure);
        btn_measure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView_measure.setText(editText_measure.getText());
                editText_measure.setText("");
            }
        });

        textView_wait = (TextView) findViewById(R.id.textView_wait);
        editText_wait = (EditText) findViewById(R.id.editText_wait);
        btn_wait = (Button) findViewById(R.id.btn_wait);
        btn_wait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView_wait.setText(editText_wait.getText());
                editText_wait.setText("");
            }
        });

        btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}