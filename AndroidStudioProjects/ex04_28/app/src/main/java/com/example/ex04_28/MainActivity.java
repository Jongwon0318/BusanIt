package com.example.ex04_28;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView Text1,Text2;
    CheckBox ChkAgree;
    RadioGroup Rgroup1;
    RadioButton RdoDog, RdoCat, RdoRabbit;
    Button BtnOK;
    ImageView imgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex04_28);

        Text1 = (TextView) findViewById(R.id.Text1);
        Text2 = (TextView) findViewById(R.id.Text2);

        ChkAgree = (CheckBox) findViewById(R.id.ChkAgree);

        Rgroup1 = (RadioGroup) findViewById(R.id.Rgroup1);

        RdoDog = (RadioButton) findViewById(R.id.RdoDog);
        RdoCat = (RadioButton) findViewById(R.id.RdoCat);
        RdoRabbit = (RadioButton) findViewById(R.id.RdoRabbit);

        BtnOK = (Button) findViewById(R.id.BtnOK);

        imgPet = (ImageView) findViewById(R.id.imgPet);

        ChkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ChkAgree.isChecked()){
                    Text2.setVisibility(View.VISIBLE);
                    Rgroup1.setVisibility(View.VISIBLE);
                    BtnOK.setVisibility(View.VISIBLE);
                    imgPet.setVisibility(View.VISIBLE);
                }else{
                    Text2.setVisibility(View.INVISIBLE);
                    Rgroup1.setVisibility(View.INVISIBLE);
                    BtnOK.setVisibility(View.INVISIBLE);
                    imgPet.setVisibility(View.INVISIBLE);
                }
            }
        });
        BtnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (Rgroup1.getCheckedRadioButtonId()){
                    case R.id.RdoDog:imgPet.setImageResource(R.drawable.dog); break;
                    case R.id.RdoCat:imgPet.setImageResource(R.drawable.cat); break;
                    case R.id.RdoRabbit:imgPet.setImageResource(R.drawable.rabbit); break;
                    default:
                        Toast.makeText(MainActivity.this,"동물 먼저 선택하세요",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
