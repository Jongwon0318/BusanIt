package com.cookandroid.project_b_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edt1,edt2,edt3,edt4,edt5;
    CheckBox cb1,cb2,cb3,cb4;
    Spinner spinner;
    Button btn;
    TextView tv1,tv2,tv3;
    Gallery gallery;
    String[] spArr={"Appearance(외모)","Ability(능력)","Personality(성격)","Lineage(가문)","Faith(신앙)"};
    ArrayList<Integer> piArrList=new ArrayList<Integer>();
    View dialogView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1=(EditText) findViewById(R.id.edt1);
        edt2=(EditText) findViewById(R.id.edt2);
        edt3=(EditText) findViewById(R.id.edt3);
        edt4=(EditText) findViewById(R.id.edt4);
        edt5=(EditText) findViewById(R.id.edt5);

        cb1=(CheckBox) findViewById(R.id.cb1);
        cb2=(CheckBox) findViewById(R.id.cb2);
        cb3=(CheckBox) findViewById(R.id.cb3);
        cb4=(CheckBox) findViewById(R.id.cb4);

        spinner=(Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,spArr);
        spinner.setAdapter(adapter);

        btn=(Button) findViewById(R.id.btn);

        tv1=(TextView) findViewById(R.id.tv1);
        tv2=(TextView) findViewById(R.id.tv2);
        tv3=(TextView) findViewById(R.id.tv3);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Clearing ArrayList
                piArrList.clear();

                //Check edt1
                if(edt1.getText().toString().equals("")){
                    AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                    AlertDialog dlg=builder.create();
                    dialogView=(View) View.inflate(MainActivity.this,R.layout.dialog,null);
                    dlg.setView(dialogView);
                    //dlg 크기설정..
                    dlg.show();
                    WindowManager.LayoutParams params1=new WindowManager.LayoutParams();
                    params1.copyFrom(dlg.getWindow().getAttributes());
                    params1.width=650;
                    params1.height=WindowManager.LayoutParams.WRAP_CONTENT;
                    dlg.getWindow().setAttributes(params1);
                    return;
                }
                //Check edt2,edt3,edt4,edt5

                if(cb1.isChecked()&&edt2.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"시간을 입력하세요(코딩)",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(cb2.isChecked()&&edt3.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"시간을 입력하세요(독서)",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(cb3.isChecked()&&edt4.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"시간을 입력하세요(영어)",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(cb4.isChecked()&&edt5.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"시간을 입력하세요(운동)",Toast.LENGTH_SHORT).show();
                    return;
                }


                //Setting tv1
                String sleeptime=edt1.getText().toString();
                tv1.setText("나는 "+sleeptime+"시간 잠을 잡니다!");

                //Setting tv2
                int workH=0;
                if(cb1.isChecked()){
                    workH+=Integer.parseInt(edt2.getText().toString());
                    piArrList.add(R.drawable.programming);
                }
                if(cb2.isChecked()){
                    workH+=Integer.parseInt(edt3.getText().toString());
                    piArrList.add(R.drawable.book_reading);
                }
                if(cb3.isChecked()){
                    workH+=Integer.parseInt(edt4.getText().toString());
                    piArrList.add(R.drawable.engligh_study);
                }
                if(cb4.isChecked()){
                    workH+=Integer.parseInt(edt5.getText().toString());
                    piArrList.add(R.drawable.work_out);
                }
                tv2.setText("나는 꿈을 위해 "+workH+"시간 투자합니다!");

                //Setting tv3
                String idol="";
                switch (spinner.getSelectedItemPosition()){
                    case 0:idol=spArr[0]; break;
                    case 1:idol=spArr[1]; break;
                    case 2:idol=spArr[2]; break;
                    case 3:idol=spArr[3]; break;
                    case 4:idol=spArr[4]; break;
                };
                tv3.setText("나의 이상형은 "+idol+" 입니다!");

                //Setting Gallery
                gallery=(Gallery) findViewById(R.id.gallery);
                MyGalleryAdapter adapter=new MyGalleryAdapter(MainActivity.this);
                gallery.setAdapter(adapter);

            }
        });
     }
     public class MyGalleryAdapter extends BaseAdapter{
         Context context;

         public MyGalleryAdapter(Context c){
             context=c;
         }

         @Override
         public int getCount() {
             return piArrList.size();
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
             imageView.setImageResource(piArrList.get(position));
             imageView.setPadding(30,30,30,30);
             imageView.setLayoutParams(new Gallery.LayoutParams(600,600));
             return imageView;
         }
     }
}
