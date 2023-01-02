package com.example.annong_seonmi.domain;

import android.os.Build.VERSION_CODES;

import androidx.annotation.RequiresApi;

import com.example.annong_seonmi.utils.enums.CustomDataType;

public class CropRowMeta {
    private String columnName;
    private String dataType;
    private boolean isRequired;

    public CropRowMeta(String columnName, String dataType, boolean isRequired){
        this.columnName = columnName;
        this.dataType = dataType;
        this.isRequired = isRequired;
    }

    public String getColumnName(){
        return this.columnName;
    }

    @RequiresApi(api = VERSION_CODES.N)
    public int getDataTypeIndex(){
        return CustomDataType.getCustomDataTypeIndex(this.dataType);
    }

    public boolean isRequired(){
        return this.isRequired;
    }
}
