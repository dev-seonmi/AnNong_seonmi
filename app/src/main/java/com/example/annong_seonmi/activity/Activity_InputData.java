package com.example.annong_seonmi.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.annong_seonmi.R;

public class Activity_InputData extends AppCompatActivity {

    TextView textView_crop_name, time_progress;
    ProgressBar progressBar;
    TableLayout tableLayout;

    String crop_name;
    long baseTime, pauseTime, setTime;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);

        Intent intent = getIntent();
        crop_name = intent.getStringExtra("crop_name");

        textView_crop_name = (TextView) findViewById(R.id.textView_crop_name);
        textView_crop_name.setText(crop_name);

        time_progress = (TextView) findViewById(R.id.time_progress);
//        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        /* 중지버튼 -> 초기화 */
        time_progress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        /* 데이터가 들어오면 사용 */
        tableLayout = (TableLayout) findViewById(R.id.table_layout);

        for(int i=0; i<10; i++) {
            TableRow tableRow = (TableRow) LayoutInflater.from(this).inflate(R.layout.add_table_data_row_edit, null);
            ((TextView) tableRow.getChildAt(0)).setText("엽장 테스트 7");
            ((TextView) tableRow.getChildAt(1)).setText("158.5");
            tableLayout.addView(tableRow);
        }

    }
}