package com.cookandroid.project_a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int num1,num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edt1=(EditText) findViewById(R.id.edt1);
        final EditText edt2=(EditText) findViewById(R.id.edt2);
        final EditText edt3=(EditText) findViewById(R.id.edt3);

        Button btn1=(Button) findViewById(R.id.btn1);
        Button btn2=(Button) findViewById(R.id.btn2);

        final ListView list=(ListView) findViewById(R.id.list);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rand1=new Random().nextInt(8)+2;
                int rand2=new Random().nextInt(8)+2;

                num1=rand1;
                num2=rand2;

                edt1.setText(String.valueOf(rand1));
                edt2.setText(String.valueOf(rand2));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Check edt3
                if(edt3.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"정답을 입력하세요",Toast.LENGTH_SHORT).show();
                    return;
                }

                int input=Integer.parseInt(edt3.getText().toString());
                if(input==num1*num2){
                    Toast.makeText(MainActivity.this,"정답입니다!",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"틀렸습니다!",Toast.LENGTH_SHORT).show();

                    String[] mulArr=new String[9];
                    for(int i=0; i<9; i++){
                        mulArr[i]=num1+" X "+(i+1)+" = "+(num1*(i+1));
                    }
                    ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,mulArr);
                    list.setAdapter(adapter);
                }
            }
        });

    }
}
