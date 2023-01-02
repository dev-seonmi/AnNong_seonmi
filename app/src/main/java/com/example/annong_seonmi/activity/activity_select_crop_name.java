package com.example.annong_seonmi.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.annong_seonmi.R;
import com.example.annong_seonmi.domain.CropMeta;
import com.example.annong_seonmi.domain.CropsList;
import com.example.annong_seonmi.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

public class activity_select_crop_name extends AppCompatActivity {

    int startPage;
    ListView listView_crop_name;
    Button btn_add_new_crop;

    CropsList cropItems;
    String crop_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_crop_name);

        Intent intent = getIntent();
        startPage = intent.getIntExtra("startPage", 1);
        Log.e("TAG", "start page>> " +startPage);

        /* 작물 리스트 불러오기 */
        listView_crop_name = (ListView) findViewById(R.id.listView_crop_name);
        List<String> crop_name_list = new ArrayList<>();

        cropItems = CropsList.getInstance().initItem(this);
        crop_name_list = cropItems.getCropsList();

        ArrayAdapter arrayAdapter = new ArrayAdapter(activity_select_crop_name.this, R.layout.listview_style, crop_name_list);
        listView_crop_name.setAdapter(arrayAdapter);


        /* 작물 추가 */
        btn_add_new_crop = (Button) findViewById(R.id.btn_add_new_crop);
        if (startPage == 1) {
            btn_add_new_crop.setVisibility(View.VISIBLE);
        } else if (startPage == 3){
            btn_add_new_crop.setVisibility(View.GONE);
        }
        btn_add_new_crop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(activity_select_crop_name.this);
                EditText editText = new EditText(dialog.getContext());
                dialog.setView(editText);
                String new_crop_name = editText.getText().toString();
                dialog.setTitle("작물 추가");
                dialog.setMessage("추가하실 작물명을 이름을 입력하세요");
                dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(!new_crop_name.equals("")) {
                            addNewCropItem(new_crop_name);
                            initNewCropMeta(new_crop_name);
                            ((Activity)getApplicationContext()).finish();
                        }
                    }
                });
                dialog.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {}
                });

                dialog.show();
            }
        });

        /* 작물 선택 */
        listView_crop_name.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                crop_name = adapterView.getItemAtPosition(i).toString();
                Log.e("TAG", "작물명>> " +crop_name);

                Class nextPage = null;
                if(startPage == 1) {
                    nextPage = Activity_TableSetting.class;

                } else if(startPage == 3) {
                    nextPage = Activity_OutputData.class;
                }

                Intent intent = new Intent(activity_select_crop_name.this, nextPage);
                intent.putExtra("crop_name", crop_name);
                startActivity(intent);
                finish();
            }
        });

    }

    private void addNewCropItem(String newCropItem){
        cropItems.addNewCrops(newCropItem);
    }

    private void initNewCropMeta(String newCropName){
        JsonUtils.writeJsonData(this, newCropName, new CropMeta(newCropName));
    }
}
