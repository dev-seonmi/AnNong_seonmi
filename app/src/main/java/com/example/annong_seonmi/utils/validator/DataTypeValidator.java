package com.example.annong_seonmi.utils.validator;

import android.os.Build.VERSION_CODES;

import androidx.annotation.RequiresApi;

import com.example.annong_seonmi.utils.enums.OneSpotNumber;
import com.example.annong_seonmi.utils.validator.exception.NotCorrectDataTypeException;

import java.util.NoSuchElementException;

public class DataTypeValidator {
    @RequiresApi(api = VERSION_CODES.N)
    public static double validateNumberTypeData(String data) throws NotCorrectDataTypeException {
        double value;

        try{
            value = Double.parseDouble(removeBlank(data));
        }catch (NumberFormatException e){
            value = checkOneSpotNumber(data);
        }
        return value;
    }

    @RequiresApi(api = VERSION_CODES.N)
    private static double checkOneSpotNumber(String data) throws NotCorrectDataTypeException{
        try{
            return OneSpotNumber.findValueByKorean(data);
        }catch (NoSuchElementException e){
            throw new NotCorrectDataTypeException("숫자가 아닙니다.");
        }
    }

    private static String removeBlank(String data){
        return data.replace(" ", "");
    }
}
