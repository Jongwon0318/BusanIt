package com.cookandandroid.project5_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Edit1,Edit2;

    TextView TextResult;

    Button[] btnArr=new Button[14];

    int[] btnIdArr={R.id.BtnNum0,R.id.BtnNum1,R.id.BtnNum2,R.id.BtnNum3,R.id.BtnNum4,
                          R.id.BtnNum5,R.id.BtnNum6,R.id.BtnNum7,R.id.BtnNum8,R.id.BtnNum9,
                          R.id.BtnAdd,R.id.BtnSub,R.id.BtnMul,R.id.BtnDiv};
    String num1, num2;
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex05_14);

        Edit1=(EditText) findViewById(R.id.Edit1);
        Edit2=(EditText) findViewById(R.id.Edit2);
        TextResult=(TextView) findViewById(R.id.TextResult);

        for(int i=0; i<14; i++){
//            final int final_i=i;
            btnArr[i]=(Button) findViewById(btnIdArr[i]);
        }

        for(int i=0; i<10; i++){
            final int final_i=i;
            btnArr[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Edit1.isFocused()){
                        num1=Edit1.getText().toString()+btnArr[final_i].getText().toString();
                        Edit1.setText(num1);
                    }else if(Edit2.isFocused()){
                        num2=Edit2.getText().toString()+btnArr[final_i].getText().toString();
                        Edit2.setText(num2);
                    }else{
                        Toast.makeText(getApplicationContext(),"먼저 에디트텍스트를 선택하세요.",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        btnArr[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=Edit1.getText().toString();
                num2=Edit2.getText().toString();
                if(Edit1.getText().toString().isEmpty() || Edit2.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"값을 입력하세요.",Toast.LENGTH_SHORT).show();
                }else{
                    result=Integer.parseInt(num1)+Integer.parseInt(num2);
                    TextResult.setText("계산결과 : "+result);
                }
            }
        });

        btnArr[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=Edit1.getText().toString();
                num2=Edit2.getText().toString();
                if(Edit1.getText().toString().isEmpty() || Edit2.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"값을 입력하세요.",Toast.LENGTH_SHORT).show();
                }else{
                    result=Integer.parseInt(num1)-Integer.parseInt(num2);
                    TextResult.setText("계산결과 : "+result);
                }
            }
        });

        btnArr[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=Edit1.getText().toString();
                num2=Edit2.getText().toString();
                if(Edit1.getText().toString().isEmpty() || Edit2.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"값을 입력하세요.",Toast.LENGTH_SHORT).show();
                }else{
                    result=Integer.parseInt(num1)*Integer.parseInt(num2);
                    TextResult.setText("계산결과 : "+result);
                }

            }
        });

        btnArr[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=Edit1.getText().toString();
                num2=Edit2.getText().toString();
                if(Integer.parseInt(num2)==0){
                    Toast.makeText(MainActivity.this,"0으로 나눌 수 없습니다.",Toast.LENGTH_SHORT).show();
                }
                if(Edit1.getText().toString().isEmpty() || Edit2.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"값을 입력하세요.",Toast.LENGTH_SHORT).show();
                }else{
                    result=Integer.parseInt(num1)/Integer.parseInt(num2);
                    TextResult.setText("계산결과 : "+result);
                }

            }
        });
    }
}
