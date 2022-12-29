package com.example.annong_seonmi.activity;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.annong_seonmi.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Activity_AppSetting extends AppCompatActivity {

    TextView textView_measure, textView_wait;
    EditText editText_measure, editText_wait;
    Button btn_measure, btn_wait, btn_back;


    String file_name, measure_time, wait_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_setting);

        measure_time = "10";
        wait_time = "3";
        file_name = "setting_time.txt";
        read_setting_time();

        textView_measure = (TextView) findViewById(R.id.textView_measure);
        editText_measure = (EditText) findViewById(R.id.editText_measure);
        textView_measure.setText(measure_time);

        btn_measure = (Button) findViewById(R.id.btn_measure);
        btn_measure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                measure_time = String.valueOf(editText_measure.getText());

                textView_measure.setText(measure_time);
                editText_measure.setText("");

                write_setting_time();
            }
        });

        textView_wait = (TextView) findViewById(R.id.textView_wait);
        editText_wait = (EditText) findViewById(R.id.editText_wait);
        textView_wait.setText(wait_time);

        btn_wait = (Button) findViewById(R.id.btn_wait);
        btn_wait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wait_time = String.valueOf(editText_wait.getText());

                textView_wait.setText(wait_time);
                editText_wait.setText("");

                write_setting_time();
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

    void read_setting_time() {
        try {
            File file = new File(getFilesDir(), file_name);

            if(file.exists()) {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                measure_time = bufferedReader.readLine();
                wait_time = bufferedReader.readLine();

                bufferedReader.close();
                fileReader.close();
            } else {
                write_setting_time();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void write_setting_time() {
        try {
            File file = new File(getFilesDir(), file_name);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(measure_time + "\n" + wait_time);

            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}