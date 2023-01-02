package com.example.annong_seonmi.utils;

import android.content.Context;

import com.example.annong_seonmi.utils.enums.AppResourceName;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CsvUtils {
    private static final String CSV_SPLIT_COMMA = ",";

    /* 데이터 불러오기// 파일이름 ex) 딸기.csv */
    public static List<List<String>> getFullDataFromDir(Context context, AppResourceName appResourceName){
        BufferedReader csvBr = FileUtils.openInternalFileReader(context, appResourceName.getValue());

        return readAllCsvLine(csvBr);
    }

    public static void writeCsvData(Context context, AppResourceName appResourceName, String data){
        BufferedWriter csvWr = FileUtils.openInternalFileWriter(context, appResourceName.getValue(), context.MODE_APPEND);
        try{
            csvWr.write(data+ CSV_SPLIT_COMMA);
            csvWr.flush();
            csvWr.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static List<List<String>> readAllCsvLine(BufferedReader br){
        List<List<String>> allLine = new ArrayList<>();

        try{
            String line;
            while((line=br.readLine()) != null){
                allLine.add(readCsvLine(line));
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return allLine;
    }

    private static List<String> readCsvLine(String csvLine){
        List<String> line = new ArrayList<>();
        String[] dataSplitByComma = csvLine.split(CSV_SPLIT_COMMA);

        Collections.addAll(line, dataSplitByComma);

        return line;
    }
}
