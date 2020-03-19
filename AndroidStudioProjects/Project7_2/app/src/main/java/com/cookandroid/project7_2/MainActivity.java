package com.cookandroid.project7_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;

import android.content.ClipData;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayout;
    Button btnBackground, btnButton;
    MenuView.ItemView itemRed,itemGreen,itemBlue,subRotate,subSize;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        baseLayout=(LinearLayout) findViewById(R.id.baseLayout);

        btnBackground=(Button) findViewById(R.id.btnBackground);
        btnButton=(Button) findViewById(R.id.btnButton);

        registerForContextMenu(btnBackground);
        registerForContextMenu(btnButton);

        btnBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onHelp(v);
            }
        });

        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onHelp(v);
            }
        });
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater=getMenuInflater();
        if(v==btnBackground){
            menu.setHeaderTitle("배경색 변경");
            menu.setHeaderIcon(R.drawable.icon1);
            menuInflater.inflate(R.menu.menu, menu);
//            menu.add(0,1,0,"배경색(빨강)");
//            menu.add(0,2,0,"배경색(초록)");
//            menu.add(0,3,0,"배경색(파랑)");
//            menu.setGroupVisible(0,true);
        }
        if(v==btnButton){
            menu.setHeaderTitle("버튼 변경");
            menu.setHeaderIcon(R.drawable.icon2);
            menuInflater.inflate(R.menu.menu2, menu);
//            menu.add(1,1,0,"버튼 45도 회전");
//            menu.add(1,2,0,"버튼 2배 확대");
//            menu.setGroupVisible(1,true);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.itemRed: baseLayout.setBackgroundColor(Color.RED); return true;
            case R.id.itemBlue: baseLayout.setBackgroundColor(Color.BLUE); return true;
            case R.id.itemGreen: baseLayout.setBackgroundColor(Color.GREEN);return true;
            case R.id.subRotate: btnButton.setRotation(45); return true;
            case R.id.subSize: btnButton.setScaleX(2); return true;
        }
//        switch (item.getGroupId()){
//            case 0: switch (item.getItemId()){
//                case 1: baseLayout.setBackgroundColor(Color.RED); return true;
//                case 2: baseLayout.setBackgroundColor(Color.GREEN); return true;
//                case 3: baseLayout.setBackgroundColor(Color.BLUE); return true;
//            }
//            case 1: switch (item.getItemId()){
//                case 1: btnButton.setRotation(45); return true;
//                case 2: btnButton.setScaleX(2); return true;
//            }
//        }
        return false;
    }

    public void onHelp(View v){
        openContextMenu(v);
    }


}
