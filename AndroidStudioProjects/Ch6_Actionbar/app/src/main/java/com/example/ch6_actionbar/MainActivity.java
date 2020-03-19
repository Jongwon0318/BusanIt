package com.example.ch6_actionbar;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {
    ActionBar.Tab tabSong, tabArtist, tabAlbum;
    MyTabFragment myFrags[]=new MyTabFragment[3];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar bar=getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        tabSong=bar.newTab();
        tabSong.setText("음악별");
        bar.addTab(tabSong);

        tabArtist=bar.newTab();
        tabArtist.setText("가수별");
        bar.addTab(tabArtist);

        tabAlbum=bar.newTab();
        tabAlbum.setText("앨범별");
        bar.addTab(tabAlbum);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        MyTabFragment myTabFrag=null;
        if(myFrags[tab.getPosition()]==null){
            myTabFrag=new MyTabFragment();
            Bundle data=new Bundle();
            data.putString("tabName",tab.getText().toString());
            myTabFrag.setArguments(data);
            myFrags[tab.getPosition()]=myTabFrag;
        }else{
            myTabFrag=myFrags[tab.getPosition()];
        }
        ft.replace(android.R.id.content, myTabFrag);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    public class MyTabFragment extends Fragment{
        String tabName;

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle data=getArguments();
            tabName=data.getString("tabName");
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout baseLayout=new LinearLayout(getApplicationContext());
            baseLayout.setOrientation(LinearLayout.VERTICAL);
            baseLayout.setLayoutParams(params);

            if(tabName.equals("음악별")) baseLayout.setBackgroundColor(Color.RED);
            if(tabName.equals("가수별")) baseLayout.setBackgroundColor(Color.YELLOW);
            if(tabName.equals("앨범별")) baseLayout.setBackgroundColor(Color.GREEN);

            return baseLayout;
        }
    }
}