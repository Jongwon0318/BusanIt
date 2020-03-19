package com.cookandroid.project10_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Button btnNewActivity;
    RadioGroup rg;
    RadioButton secondActivity, thirdActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNewActivity=(Button) findViewById(R.id.btnNewActivity);
        rg=(RadioGroup) findViewById(R.id.rg);
        secondActivity=(RadioButton) findViewById(R.id.secondActivity);
        thirdActivity=(RadioButton) findViewById(R.id.thirdActivity);

        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rg.getCheckedRadioButtonId() == R.id.secondActivity){
                    Intent intent=new Intent(getApplicationContext(), SecondActivity.class);
                    startActivity(intent);
                }else if(rg.getCheckedRadioButtonId() == R.id.thirdActivity){
                    Intent intent=new Intent(getApplicationContext(), ThirdActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
