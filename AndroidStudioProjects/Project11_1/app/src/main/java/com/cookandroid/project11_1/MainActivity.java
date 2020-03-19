package com.cookandroid.project11_1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Integer[] posterID={R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,R.drawable.mov04,R.drawable.mov05
                        ,R.drawable.mov06,R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,R.drawable.mov10
                        ,R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,R.drawable.mov04,R.drawable.mov05
                        ,R.drawable.mov06,R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,R.drawable.mov10
                        ,R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,R.drawable.mov04,R.drawable.mov05
                        ,R.drawable.mov06,R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,R.drawable.mov10};

    String[] movieName={"써니", "완득이", "괴물", "라디오 스타", "비열한 거리"
                        ,"왕의 남자", "아일랜드", "웰컴 투 동막골", "헬보이-골든 아미","백 투 더 퓨처",
                        "써니", "완득이", "괴물", "라디오 스타", "비열한 거리"
                        ,"왕의 남자", "아일랜드", "웰컴 투 동막골", "헬보이-골든 아미","백 투 더 퓨처",
                        "써니", "완득이", "괴물", "라디오 스타", "비열한 거리"
                        ,"왕의 남자", "아일랜드", "웰컴 투 동막골", "헬보이-골든 아미","백 투 더 퓨처"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그리드뷰 영화 포스터");

        final GridView gv=(GridView) findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);
    }

    public class MyGridAdapter extends BaseAdapter{
        Context context;

        public MyGridAdapter(Context c){
            context=c;
        }

        @Override
        public int getCount() {
            return posterID.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final ImageView imageView=new ImageView(context);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(250,375));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,5,5);
            imageView.setImageResource(posterID[position]);

            final int pos=position;

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog, null);

                    AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                    builder.setNegativeButton("닫기",null);

                    AlertDialog dlg=builder.create();

                    ImageView ivPoster=(ImageView) dialogView.findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(posterID[pos]);
                    ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    ivPoster.setPadding(5,5,5,5);
                    dlg.setTitle(movieName[pos]);
                    dlg.setIcon(R.drawable.movie_icon);
                    dlg.setView(dialogView);

                    dlg.show();
                    dlg.getWindow().setLayout(1000,1500);
                }
            });

            return imageView;
        }
    }
}


