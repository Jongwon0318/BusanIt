package com.cookandandroid.project6_1516;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex06_15);

        Button btnPrev,btnNext;
        final ViewFlipper vFlipper;

        btnPrev=(Button) findViewById(R.id.btnPrev);
        btnNext=(Button) findViewById(R.id.btnNext);
        vFlipper=(ViewFlipper) findViewById(R.id.viewFilpper1);

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vFlipper.showPrevious();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vFlipper.showNext();
            }
        });
    }
}
