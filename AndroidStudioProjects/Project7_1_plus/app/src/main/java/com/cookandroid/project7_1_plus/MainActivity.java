package com.cookandroid.project7_1_plus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    EditText edtAngle;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtAngle=(EditText) findViewById(R.id.edtAngle);
        imageView=(ImageView) findViewById(R.id.imageView);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
//        MenuInflater mInflater=getMenuInflater();
//        mInflater.inflate();
        menu.add(0,1,0, "그림 회전");

        menu.add(1,2,0,"한라산");
        menu.add(1,3,0,"추자도");
        menu.add(1,4,0,"범섬");
        menu.getItem(1).setChecked(true);
        imageView.setImageResource(R.drawable.jeju2);
        menu.setGroupCheckable(1,true,true);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case 1: imageView.setRotation(Integer.parseInt(edtAngle.getText().toString())); return true;
            case 2: item.setChecked(true); imageView.setImageResource(R.drawable.jeju2); return true;
            case 3: item.setChecked(true); imageView.setImageResource(R.drawable.jeju12);; return true;
            case 4: item.setChecked(true); imageView.setImageResource(R.drawable.jeju1);; return true;
        }
        return false;
    }
}
