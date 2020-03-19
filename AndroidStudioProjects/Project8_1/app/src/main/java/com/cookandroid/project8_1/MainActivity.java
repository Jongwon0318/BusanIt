package com.cookandroid.project8_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    EditText edtDiary;
    Button btnWrite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dp=(DatePicker) findViewById(R.id.datePicker);
        edtDiary=(EditText) findViewById(R.id.edtDiary);
        btnWrite=(Button) findViewById(R.id.btnWrite);

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                char[] diary=edtDiary.getText().toString().toCharArray();
                byte[] diaryS=edtDiary.getText().toString().getBytes();
                String date="";
                date+=dp.getYear()+"_";
                date+=(dp.getMonth()+1)+"_";
                date+=dp.getDayOfMonth();
//                char[] dateA=date.toCharArray();
                byte[] dateS=date.getBytes();
                try {
                    FileOutputStream outFs = openFileOutput(date+".txt", Context.MODE_PRIVATE);
                    outFs.write(dateS);
                    outFs.write(diaryS);
                    outFs.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
