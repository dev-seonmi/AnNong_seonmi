package com.example.annong_seonmi.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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

    TextView time_progress;
    ProgressBar progressBar;
    TableLayout tableLayout;

    long baseTime, pauseTime, setTime;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);

        time_progress = (TextView) findViewById(R.id.time_progress);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

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


        /* 데이터 입력 시 add_table_data_row.xml 사용 */
        tableLayout = (TableLayout) findViewById(R.id.table_layout);
        @SuppressLint("ResourceType") TableRow tableRow = (TableRow) findViewById(R.layout.add_table_data_row);
        tableLayout.addView(tableRow);
    }
}