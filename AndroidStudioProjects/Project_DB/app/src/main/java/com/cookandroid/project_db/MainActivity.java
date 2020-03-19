package com.cookandroid.project_db;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.cookandroid.project_db.Network.NetworkGet;
import com.cookandroid.project_db.Network.NetworkInsert;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button refreshBtn, addBtn;
    private ListView listView;
    private Custom_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView) findViewById(R.id.listView);
        adapter=new Custom_Adapter(MainActivity.this, new ArrayList<UserInfo>(), R.layout.adapter_userinfo);
        listView.setAdapter(adapter);

        refreshBtn=(Button) findViewById(R.id.btnRefresh);
        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new NetworkGet((Custom_Adapter)listView.getAdapter()).execute("");
            }
        });

        addBtn=(Button) findViewById(R.id.btn_add);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View v=getLayoutInflater().inflate(R.layout.dialog_add,null);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("멤버 추가")
                        .setView(v)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String id=((EditText)v.findViewById(R.id.edtID)).getText().toString();
                                String name=((EditText)v.findViewById(R.id.edtName)).getText().toString();
                                String phone=((EditText)v.findViewById(R.id.edtPhone)).getText().toString();
                                String grade=((EditText)v.findViewById(R.id.edtGrade)).getText().toString();

                                new NetworkInsert(adapter).execute(id,name,phone,grade);
                            }
                        })
                        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .setCancelable(false)
                        .show();
            }
        });
        //전체 불러오기
        new NetworkGet((Custom_Adapter)listView.getAdapter()).execute("");
    }

    public class myAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 0;
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
            return null;
        }
    }
}
