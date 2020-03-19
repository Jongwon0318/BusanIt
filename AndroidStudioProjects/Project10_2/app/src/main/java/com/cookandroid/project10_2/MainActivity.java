package com.cookandroid.project10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView[] ivarr=new ImageView[9];
    Button btnFinish;

    int[] idarr={R.id.iv1,R.id.iv2,R.id.iv3,R.id.iv4,R.id.iv5,R.id.iv6,R.id.iv7,R.id.iv8,R.id.iv9};

    final float[] voteCount=new float[9];
    final String[] imgName={"독서하는 소녀","꽃장식 모자 소녀","부채를 든 소녀","이레느깡 단 베르앙","잠자는 소녀"
                            ,"테라스의 두 자매","피아노 레슨","피아노 앞의 소녀들","해변에서"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("명화 선호도 투표");

        for(int i=0; i<9; i++){
            voteCount[i]=0;
        }

        for(int i=0; i<9; i++){
            final int index;
            index=i;
            ivarr[i]=(ImageView) findViewById(idarr[i]);
            ivarr[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteCount[index]+=0.5;
                    Toast.makeText(getApplicationContext(),imgName[index]+" : 총 "+(int)(voteCount[index]*2)+" 표",Toast.LENGTH_SHORT).show();
                }
            });
        }
        btnFinish=(Button) findViewById(R.id.btnResult);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("VoteCount",voteCount);
                intent.putExtra("ImageName",imgName);

                startActivity(intent);
            }
        });

    }
}
