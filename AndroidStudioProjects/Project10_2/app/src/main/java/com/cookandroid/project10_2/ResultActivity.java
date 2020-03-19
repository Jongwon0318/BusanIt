package com.cookandroid.project10_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {


    Button btnReturn;

    int[] idarr={R.id.tv1,R.id.tv2,R.id.tv3,R.id.tv4,R.id.tv5,R.id.tv6,R.id.tv7,R.id.tv8,R.id.tv9,
                R.id.rbar1,R.id.rbar2,R.id.rbar3,R.id.rbar4,R.id.rbar5,R.id.rbar6,R.id.rbar7,R.id.rbar8,R.id.rbar9};

    int[] imageField={R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5
                     ,R.drawable.pic6,R.drawable.pic7,R.drawable.pic8,R.drawable.pic9};

    TextView tvWon;
    ImageView ivWon;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("투표 결과");

        Intent intent = getIntent();
        float[] voteResult=intent.getFloatArrayExtra("VoteCount");
        String[] imageName=intent.getStringArrayExtra("ImageName");

        TextView[] tvarr=new TextView[imageName.length];
        RatingBar[] rarr=new RatingBar[imageName.length];

        //Binding
        for(int i=0; i<18; i++){
            if(i<9){ // 0 1 2 3 4 5 6 7 8
                tvarr[i]=(TextView) findViewById(idarr[i]);
                tvarr[i].setText(imageName[i]);
            }else{
                rarr[i-9]=(RatingBar) findViewById(idarr[i]);
                rarr[i-9].setRating(voteResult[i-9]);
            }
        }

        int maxNum=0;
        for(int i=1; i<9; i++){
            if(voteResult[i]>voteResult[i-1]){
                maxNum=i;
            }
        }

        tvWon=(TextView) findViewById(R.id.tvWon);
        ivWon=(ImageView) findViewById(R.id.ivWon);

        tvWon.setText(tvarr[maxNum].getText().toString());
        ivWon.setImageResource(imageField[maxNum]);

        btnReturn=(Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
