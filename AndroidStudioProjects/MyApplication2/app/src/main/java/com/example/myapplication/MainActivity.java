package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2;
    Button btnAdd, btnSub, btnMul, btnDiv, btnNam;
    TextView textResult;
    String num1, num2;

    Double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex04_19);
        setTitle("초간단 계산기");

        et1=(EditText) findViewById(R.id.Edit1);
        et2=(EditText) findViewById(R.id.Edit2);

        btnAdd=(Button) findViewById(R.id.BtnAdd);
        btnSub=(Button) findViewById(R.id.BtnSub);
        btnMul=(Button) findViewById(R.id.BtnMul);
        btnDiv=(Button) findViewById(R.id.BtnDiv);
        btnNam=(Button) findViewById(R.id.BtnNam);

        textResult=(TextView) findViewById(R.id.TextResult);

//        btnAdd.setOnTouchListener(new View.OnTouchListener(){
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                num1=et1.getText().toString();
//                num2=et2.getText().toString();
//                result=Integer.parseInt(num1)+Integer.parseInt(num2);
//                textResult.setText("계산결과 : "+result.toString());
//                return false;
//            }
//        });
//
//        btnSub.setOnTouchListener(new View.OnTouchListener(){
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                num1=et1.getText().toString();
//                num2=et2.getText().toString();
//                result=Integer.parseInt(num1)-Integer.parseInt(num2);
//                textResult.setText("계산결과 : "+result.toString());
//                return false;
//            }
//        });
//
//        btnMul.setOnTouchListener(new View.OnTouchListener(){
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                num1=et1.getText().toString();
//                num2=et2.getText().toString();
//                result=Integer.parseInt(num1)*Integer.parseInt(num2);
//                textResult.setText("계산결과 : "+result.toString());
//                return false;
//            }
//        });
//
//        btnDiv.setOnTouchListener(new View.OnTouchListener(){
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                num1=et1.getText().toString();
//                num2=et2.getText().toString();
//                result=Integer.parseInt(num1)/Integer.parseInt(num2);
//                textResult.setText("계산결과 : "+result.toString());
//                return false;
//            }
//        });

        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                num1=et1.getText().toString();
                num2=et2.getText().toString();

                Toast myToast=Toast.makeText(MainActivity.this , "값을 입력하세요", Toast.LENGTH_SHORT);
                if (num1.isEmpty() || num2.isEmpty()){
                    myToast.show();
                }else {
                    result = Double.parseDouble(num1) + Double.parseDouble(num2);
                    textResult.setText("계산결과 : " + result);
                }
                /*if(num2.equals("")) num2="0";
                result=Double.parseDouble(num1)+Double.parseDouble(num2);
                textResult.setText("계산결과 : "+result.toString());*/
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                num1=et1.getText().toString();
                num2=et2.getText().toString();

                Toast myToast=Toast.makeText(MainActivity.this , "값을 입력하세요", Toast.LENGTH_SHORT);
                if (num1.isEmpty() || num2.isEmpty()){
                    myToast.show();
                }else{
                    result=Double.parseDouble(num1)-Double.parseDouble(num2);
                    textResult.setText("계산결과 : "+result);
                }
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                num1=et1.getText().toString();
                num2=et2.getText().toString();

                Toast myToast=Toast.makeText(MainActivity.this , "값을 입력하세요", Toast.LENGTH_SHORT);
                if (num1.isEmpty() || num2.isEmpty()){
                    myToast.show();
                }else{
                    result=Double.parseDouble(num1)*Double.parseDouble(num2);
                    textResult.setText("계산결과 : "+result);
                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                num1=et1.getText().toString();
                num2=et2.getText().toString();

                Toast myToast=Toast.makeText(MainActivity.this , "값을 입력하세요", Toast.LENGTH_SHORT);
                Toast myToast2=Toast.makeText(MainActivity.this , "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT);
                if (num1.isEmpty() || num2.isEmpty()){
                    myToast.show();
                }
                else if(Double.parseDouble(num2)==0){
                    myToast2.show();
                }else {
                    result = Double.parseDouble(num1) / Double.parseDouble(num2);
                    result = ((int)(result * 100))/100.0;

                    textResult.setText("계산결과 : " + result);
                }
            }
        });

        btnNam.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                num1=et1.getText().toString();
                num2=et2.getText().toString();

                Toast myToast=Toast.makeText(MainActivity.this , "값을 입력하세요", Toast.LENGTH_SHORT);
                if (num1.isEmpty() || num2.isEmpty()){
                    myToast.show();
                }else{
                    result=Double.parseDouble(num1)%Double.parseDouble(num2);
                    textResult.setText("계산결과 : "+result);
                }
            }
        });
//        TextView tv1, tv2, tv3;
//        tv1=(TextView) findViewById(R.id.textView1);
//        tv2=(TextView) findViewById(R.id.textView2);
//        tv3=(TextView) findViewById(R.id.textView3);
//
//        tv1.setText("안녕하세요");
//        tv1.setTextColor(Color.RED);
//        tv2.setTextSize(30);
//        tv2.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD_ITALIC);
//        tv3.setText("가나다라마바사아자차카타파하");
//        tv3.setSingleLine();
    }

}
