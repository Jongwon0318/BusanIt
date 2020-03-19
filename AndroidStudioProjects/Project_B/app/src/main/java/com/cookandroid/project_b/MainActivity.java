package com.cookandroid.project_b;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt1, edt2, edt3;
    TextView tv;
    RadioGroup rgr;
    RadioButton add,sub,mul,div;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1=(EditText) findViewById(R.id.edt1);
        edt2=(EditText) findViewById(R.id.edt2);
        edt3=(EditText) findViewById(R.id.edt3);

        tv=(TextView) findViewById(R.id.tv);

        rgr=(RadioGroup) findViewById(R.id.rgr);

        add=(RadioButton) findViewById(R.id.add);
        sub=(RadioButton) findViewById(R.id.sub);
        mul=(RadioButton) findViewById(R.id.mul);
        div=(RadioButton) findViewById(R.id.div);

        btn1=(Button) findViewById(R.id.btn1);

        rgr.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (rgr.getCheckedRadioButtonId()){
                    case R.id.add: tv.setText(" + "); break;
                    case R.id.sub: tv.setText(" - "); break;
                    case R.id.mul: tv.setText(" * "); break;
                    case R.id.div: tv.setText(" / "); break;
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            double num1,num2;
            @Override
            public void onClick(View v) {
                //Check edt1,edt2,rgr
                if(edt1.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"숫자를 입력하세요",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(edt2.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"숫자를 입력하세요",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(rgr.getCheckedRadioButtonId()==RadioGroup.NO_ID){
                    Toast.makeText(getApplicationContext(),"연산을 선택하세요",Toast.LENGTH_SHORT).show();
                    return;
                }

                edt3.setEnabled(true);
                num1=Double.parseDouble(edt1.getText().toString());
                num2=Double.parseDouble(edt2.getText().toString());
                switch (rgr.getCheckedRadioButtonId()){
                    case R.id.add: edt3.setText(num1+num2+""); break;
                    case R.id.sub: edt3.setText(num1-num2+""); break;
                    case R.id.mul: edt3.setText(num1*num2+""); break;
                    case R.id.div: edt3.setText(num1/num2+""); break;
                }
                edt3.setEnabled(false);
                edt3.setTextColor(Color.RED);
            }
        });
    }
}
