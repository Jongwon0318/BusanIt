package com.cookandroid.project11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("갤러리 영화 포스터");

        Gallery gallery=(Gallery) findViewById(R.id.gallery1);
        MyGalleryAdapter galAdapter=new MyGalleryAdapter(this);
        gallery.setAdapter(galAdapter);
    }

    public class MyGalleryAdapter extends BaseAdapter{
        Context context;

        int[] posterID={R.drawable.mov11,R.drawable.mov12,R.drawable.mov13,R.drawable.mov14,R.drawable.mov15
                        ,R.drawable.mov16,R.drawable.mov17,R.drawable.mov18,R.drawable.mov19,R.drawable.mov20};

        String[] posterName={"여인의 향기", "쥬라기 공원", "포레스트 검프", "사랑의 블랙홀", "혹성탈출-진화의 시작"
                            ,"아름다운 비행","내 이름은 칸","해리포터-죽음의 성물","마더","킹콩을 들다"};

        public MyGalleryAdapter (Context c){
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
            ImageView imageView=new ImageView(context);
            imageView.setLayoutParams(new Gallery.LayoutParams(200,300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,5,5);
            imageView.setImageResource(posterID[position]);

            final ImageView ivPoster=(ImageView) findViewById(R.id.ivPoster);
            if(ivPoster.getDrawable()==null){
                ivPoster.setImageResource(posterID[0]);
            }

            final int pos=position;

            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    ivPoster.setImageResource(posterID[pos]);
                    Toast posterToast=new Toast(context);
                    View ToastView=View.inflate(context,R.layout.toast,null);
                    posterToast.setView(ToastView);
                    TextView toastText=(TextView) ToastView.findViewById(R.id.toastText);
                    toastText.setText(posterName[pos]);
                    posterToast.show();

                    return false;
                }
            });

            return imageView;
        }
    }
}
