package com.cookandroid.project10_16171819;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Main Activity");

        final RadioGroup rdoGr=(RadioGroup) findViewById(R.id.rdoGr);
        RadioButton rbPlus=(RadioButton) findViewById(R.id.rbPlus);
        RadioButton rbSub=(RadioButton) findViewById(R.id.rbSub);
        RadioButton rbMul=(RadioButton) findViewById(R.id.rbMul);
        RadioButton rbDiv=(RadioButton) findViewById(R.id.rbDiv);
        Button btnNewActivity=(Button) findViewById(R.id.btnNewActivity);

        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edtNum1=(EditText) findViewById(R.id.edtNum1);
                EditText edtNum2=(EditText) findViewById(R.id.edtNum2);

                Intent intent=new Intent(getApplicationContext(),second.class);
                intent.putExtra("num1",edtNum1.getText().toString());
                intent.putExtra("num2",edtNum2.getText().toString());

                String cal="";

                switch(rdoGr.getCheckedRadioButtonId()){
                    case R.id.rbPlus: cal="plus"; break;
                    case R.id.rbSub: cal="sub"; break;
                    case R.id.rbMul: cal="mul"; break;
                    case R.id.rbDiv: cal="div"; break;
                }

                intent.putExtra("cal",cal);

                //startActivity(intent) 가 아님!!***
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode==RESULT_OK){
            double res=data.getDoubleExtra("Res",0);
            Toast.makeText(getApplicationContext(),"계산결과 : "+res,Toast.LENGTH_SHORT).show();
        }
    }
}
