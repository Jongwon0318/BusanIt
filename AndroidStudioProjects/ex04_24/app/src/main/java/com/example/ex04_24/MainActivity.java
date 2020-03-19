package com.example.ex04_24;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox android,iphone,window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex04_24);

        android=(CheckBox) findViewById(R.id.android);
        iphone=(CheckBox) findViewById(R.id.iphone);
        window=(CheckBox) findViewById(R.id.window);

        android.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            Toast myToast = Toast.makeText(MainActivity.this, "안드로이드 선택", Toast.LENGTH_SHORT);
            Toast myToast2 = Toast.makeText(MainActivity.this, "안드로이드 선택해제", Toast.LENGTH_SHORT);
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(android.isChecked()){
                    myToast.show();
                }else{
                    myToast2.show();
                }
            }
        });

        iphone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            Toast myToast = Toast.makeText(MainActivity.this, "아이폰 선택", Toast.LENGTH_SHORT);
            Toast myToast2 = Toast.makeText(MainActivity.this, "아이폰 선택해제", Toast.LENGTH_SHORT);
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(iphone.isChecked()){
                    myToast.show();
                }else{
                    myToast2.show();
                }
            }
        });

        window.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            Toast myToast = Toast.makeText(MainActivity.this, "윈도우폰 선택", Toast.LENGTH_SHORT);
            Toast myToast2 = Toast.makeText(MainActivity.this, "윈도우폰 선택해제", Toast.LENGTH_SHORT);
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(window.isChecked()){
                    myToast.show();
                }else{
                    myToast2.show();
                }
            }
        });

    }
}
