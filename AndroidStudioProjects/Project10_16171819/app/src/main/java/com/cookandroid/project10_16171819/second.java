package com.cookandroid.project10_16171819;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("Second Activity");

        TextView tvCal=(TextView) findViewById(R.id.tvCal);
        Button btnReturn=(Button) findViewById(R.id.btnReturn);

        Intent inIntent=getIntent();
        String num1=inIntent.getStringExtra("num1");
        String num2=inIntent.getStringExtra("num2");

        tvCal.append(inIntent.getStringExtra("cal"));

        double res=0;

        switch (inIntent.getStringExtra("cal")){
            case "plus": res=Double.parseDouble(num1)+Double.parseDouble(num2); break;
            case "sub": res=Double.parseDouble(num1)-Double.parseDouble(num2); break;
            case "mul": res=Double.parseDouble(num1)*Double.parseDouble(num2); break;
            case "div": res=Double.parseDouble(num1)/Double.parseDouble(num2); break;
        }

        final double finalRes = res;

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outIntent=new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("Res", finalRes);
                setResult(RESULT_OK,outIntent);
                finish();
            }
        });


    }
}
