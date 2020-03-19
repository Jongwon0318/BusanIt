package com.example.ex04_28_plus;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView Text1,Text2;
    Switch SwiAgree;
    RadioGroup Rgroup1;
    RadioButton[] rdoArr=new RadioButton[3];
    final int[] rdoidArr={R.id.RdoOreo, R.id.RdoPie, R.id.RdoQ};
    final int[] picArr={R.drawable.oreo,R.drawable.pie,R.drawable.q10};
    ImageView imgAndroid;
    Button BtnExit, BtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Text1=(TextView) findViewById(R.id.Text1);
        Text2=(TextView) findViewById(R.id.Text2);

        SwiAgree=(Switch) findViewById(R.id.SwiAgree);

        Rgroup1=(RadioGroup) findViewById(R.id.Rgroup1);

        for(int i=0; i<3; i++){
            final int final_i=i;
            rdoArr[final_i]=(RadioButton) findViewById(rdoidArr[final_i]);
        }

        imgAndroid=(ImageView) findViewById(R.id.imgAndroid);

        BtnBack=(Button) findViewById(R.id.BtnBack);
        BtnExit=(Button) findViewById(R.id.BtnExit);

        SwiAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true){
                    Text2.setVisibility(View.VISIBLE);
                    Rgroup1.setVisibility(View.VISIBLE);
                    imgAndroid.setVisibility(View.VISIBLE);
                    BtnExit.setVisibility(View.VISIBLE);
                    BtnBack.setVisibility(View.VISIBLE);
                }else{
                    Text2.setVisibility(View.INVISIBLE);
                    Rgroup1.setVisibility(View.INVISIBLE);
                    imgAndroid.setVisibility(View.INVISIBLE);
                    BtnExit.setVisibility(View.INVISIBLE);
                    BtnBack.setVisibility(View.INVISIBLE);
                }
            }
        });

        //final로 써야하는 이유
        for(int i=0; i<3; i++){
            final int final_i = i;
            rdoArr[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imgAndroid.setImageResource(picArr[final_i]);
                }
            });
        }
        //ex) picArr[0] = R.drawable.pie;

//        Rgroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if(checkedId==R.id.RdoOreo){
//                    imgAndroid.setImageResource(R.drawable.oreo);
//                }else if(checkedId==R.id.RdoPie){
//                    imgAndroid.setImageResource(R.drawable.pie);
//                }else if(checkedId==R.id.RdoQ){
//                    imgAndroid.setImageResource(R.drawable.q10);
//                }
//            }
//        });

        BtnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });

        BtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //MainActivity.this.finish();
                //startActivity(MainActivity.this.getIntent());
                Text2.setVisibility(View.INVISIBLE);
                Rgroup1.setVisibility(View.INVISIBLE);
                imgAndroid.setVisibility(View.INVISIBLE);
                BtnExit.setVisibility(View.INVISIBLE);
                BtnBack.setVisibility(View.INVISIBLE);
                SwiAgree.setChecked(false);

                Rgroup1.clearCheck();

                imgAndroid.setImageResource(0);
            }
        });
    }
}
