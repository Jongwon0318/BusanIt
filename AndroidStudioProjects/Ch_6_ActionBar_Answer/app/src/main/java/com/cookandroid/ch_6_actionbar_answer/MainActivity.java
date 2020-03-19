package com.cookandroid.ch_6_actionbar_answer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {
    //Want to connect Listener(onCreate method) by itself.

    //Declare Member Variable to connect Fragment, make tabs.
    ActionBar.Tab tab1,tab2,tab3;

    //Make 3-spaced array which can contain Fragments while creating Fragments.
    MyTabFragment[] myFrags=new MyTabFragment[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //1.Setting ActionBar(Menu) - getSupportActionBar()
        ActionBar bar=getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        tab1=bar.newTab();
        tab1.setText("탭1");
        //Connecting Listener
        tab1.setTabListener(this);
        bar.addTab(tab1);

        tab2=bar.newTab();
        tab2.setText("탭2");
        tab2.setTabListener(this);
        bar.addTab(tab2);

        tab3=bar.newTab();
        tab3.setText("탭3");
        tab3.setTabListener(this);
        bar.addTab(tab3);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        //Create sole Fragment.
        MyTabFragment myFragment=null;

        //When Tab clicked initially, there's no Fragments.
        if(myFrags[tab.getPosition()]==null) {
            myFragment = new MyTabFragment();
            Bundle data = new Bundle();
            data.putString("tabName", tab.getText().toString());
            myFragment.setArguments(data);
            myFrags[tab.getPosition()]=myFragment;
        }else{
            myFragment=myFrags[tab.getPosition()];
        }

        ft.replace(android.R.id.content,myFragment);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    //2.Making Fragment (inner class) ->Fragment has an equal level comparing to View and AppCompatActivity has it.
    //*** Purpose of static class = Sharing.
    public static class MyTabFragment extends Fragment{
        String tabName;

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle data = getArguments();
            //To get tabName from ActionBar using Bundle and send that to Fragment
            tabName=data.getString("tabName");
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            //To make design of Fragment
            //2Ways : 1.Connect xml 2.Coding directly

            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);

//            LinearLayout baseLayout=new LinearLayout(MainActivity.this);
            LinearLayout baseLayout=new LinearLayout(getActivity());
            baseLayout.setLayoutParams(params);

            //Setting Fragment's View from ActionBar-Tab's tabName
            if(tabName.equals("탭1")){
                //To set content to Fragment
                baseLayout.setBackgroundColor(Color.RED);
            }
            if(tabName.equals("탭2")){
                //To set content to Fragment
                baseLayout.setBackgroundColor(Color.GREEN);
            }
            if(tabName.equals("탭3")){
                //To set content to Fragment
                baseLayout.setBackgroundColor(Color.BLUE);
            }

            return baseLayout;
        }
    }
}