package com.cookandandroid.ch6_192021;

import android.annotation.SuppressLint;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {

    ActionBar.Tab tabSong1, tabArtist1, tabAlbum1;

    MyTabFragment myFrags[]=new MyTabFragment[3];

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar bar1=getSupportActionBar();

        bar1.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        tabSong1=bar1.newTab();
        tabArtist1=bar1.newTab();
        tabAlbum1=bar1.newTab();

        tabSong1.setText("음악별");
        tabArtist1.setText("가수별");
        tabAlbum1.setText("앨범별");

        tabSong1.setTabListener(this);
        tabArtist1.setTabListener(this);
        tabAlbum1.setTabListener(this);

        bar1.addTab(tabSong1);
        bar1.addTab(tabArtist1);
        bar1.addTab(tabAlbum1);
    }


    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

        MyTabFragment myTabFrag = null;

        if(myFrags[tab.getPosition()]==null){
            myTabFrag=new MyTabFragment();
            Bundle data = new Bundle();
            data.putString("tabName",tab.getText().toString());
            myTabFrag.setArguments(data);
        }else myTabFrag = myFrags[tab.getPosition()];

        ft.replace(android.R.id.content, myTabFrag);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    public class MyTabFragment extends Fragment {
        String tabName;
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle data=getArguments();
            tabName=data.getString("tabName");
        }

        public View onCreateView(LayoutInflater inflatter, ViewGroup container, Bundle savedInstanceState){
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout baseLayout = new LinearLayout(MainActivity.this);
            baseLayout.setOrientation(LinearLayout.VERTICAL);
            baseLayout.setLayoutParams(params);

            if(tabName=="음악별") baseLayout.setBackgroundColor(Color.RED);
            if(tabName=="가수별") baseLayout.setBackgroundColor(Color.GREEN);
            if(tabName=="앨범별") baseLayout.setBackgroundColor(Color.BLUE);

            return baseLayout;
        }
    }
}
