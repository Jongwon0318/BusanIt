package com.cookandandroid.project6_1516_plus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex06_15);

        Button btnStart, btnStop;
        final ViewFlipper vFlipper;
        final ImageView dog;

        btnStart=(Button) findViewById(R.id.btnStart);
        btnStop=(Button) findViewById(R.id.btnStop);
        vFlipper=(ViewFlipper) findViewById(R.id.viewFilpper1);
        dog=(ImageView) findViewById(R.id.dog);

        dog.setVisibility(View.INVISIBLE);
//
//        btnStart.setOnHoverListener(new View.OnHoverListener() {
//            @Override
//            public boolean onHover(View v, MotionEvent event) {
//                dog.setVisibility(View.VISIBLE);
//                return false;
//            }
//        });
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dog.setVisibility(View.VISIBLE);
                vFlipper.startFlipping();
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vFlipper.stopFlipping();
            }
        });
    }
}
