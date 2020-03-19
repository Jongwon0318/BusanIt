package com.cookandroid.project_a_2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.DialogTitle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] arr={"A","B","O","AB"};

    ArrayList<Integer> arrlist=new ArrayList<Integer>();

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edt1=(EditText) findViewById(R.id.edt1);
        final EditText edt2=(EditText) findViewById(R.id.edt2);

        final RadioGroup rgr=(RadioGroup) findViewById(R.id.rgr);
        RadioButton male=(RadioButton) findViewById(R.id.male);
        RadioButton female=(RadioButton) findViewById(R.id.female);

        final Spinner spinner=(Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arr);
        spinner.setAdapter(adapter);

        final CheckBox cb1=(CheckBox) findViewById(R.id.cb1);
        final CheckBox cb2=(CheckBox) findViewById(R.id.cb2);
        final CheckBox cb3=(CheckBox) findViewById(R.id.cb3);

        Button btn1=(Button) findViewById(R.id.btn1);

        final TextView tv1=(TextView) findViewById(R.id.tv1);
        final TextView tv2=(TextView) findViewById(R.id.tv2);

        btn1.setOnClickListener(new View.OnClickListener() {
            String gender;
            String bloodtype;
            double height;
            double weight;
            double bmi;

            @Override
            public void onClick(View v) {
                //Check cb1,cb2,cb3;
                if(!cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked()){
                    Toast.makeText(getApplicationContext(),"습관을 선택하십시오",Toast.LENGTH_SHORT).show();
                    return;
                }


                //Check edt1,edt2
                if(edt1.getText().toString().equals("")||edt2.getText().toString().equals("")){
                    AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                    AlertDialog dlg=builder.create();

                    //LayoutParams
                    LinearLayout.LayoutParams params=
                            new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                                                          LinearLayout.LayoutParams.MATCH_PARENT);

                    //Title
                    TextView title=new TextView(MainActivity.this);
                    title.setText("키와 체중");
                    title.setTextColor(Color.RED);
                    title.setTextSize(23);
                    title.setPadding(40,30,0,30);

                    //Line
                    View line=new View(MainActivity.this);
                    line.setLayoutParams(params);
                    line.setBackgroundColor(Color.RED);

                    //BaseLayout
                    LinearLayout baseLayout=new LinearLayout(getApplicationContext());
                    baseLayout.setLayoutParams(params);
                    baseLayout.setOrientation(LinearLayout.VERTICAL);
                    baseLayout.setPadding(20,20,20,20);

                    //ContentLayout
                    LinearLayout contentLayout=new LinearLayout(getApplicationContext());
                    contentLayout.setOrientation(LinearLayout.HORIZONTAL);
                    contentLayout.setPadding(0,20,0,0);

                    //ImageView,TextView
                    ImageView imageView=new ImageView(MainActivity.this);
                    imageView.setImageResource(R.drawable.weight);

                    TextView textView=new TextView(MainActivity.this);
                    textView.setText("   키와 체중을 넣어\n   주세요!");
                    textView.setLayoutParams(params);

                    //Binding - ContentLayout / BaseLayout
                    contentLayout.addView(imageView,500,500);
                    contentLayout.addView(textView,500,500);

                    baseLayout.addView(title);
                    baseLayout.addView(line,LinearLayout.LayoutParams.MATCH_PARENT,5);
                    baseLayout.addView(contentLayout,900,500);

                    dlg.setView(baseLayout);
                    dlg.show();
                    return;
                }

                //Setting tv1
                if(rgr.getCheckedRadioButtonId()==R.id.male){
                    gender="남자";
                }else if(rgr.getCheckedRadioButtonId()==R.id.female){
                    gender="여자";
                }else{
                    Toast.makeText(getApplicationContext(),"성별을 선택하십시오",Toast.LENGTH_SHORT).show();
                    return;
                }

                switch(spinner.getSelectedItemPosition()){
                    case 0: bloodtype="A"; break;
                    case 1: bloodtype="B"; break;
                    case 2: bloodtype="O"; break;
                    case 3: bloodtype="AB"; break;
                    default:Toast.makeText(getApplicationContext(),"혈액형을 선택하십시오",Toast.LENGTH_SHORT).show();
                            return;
                }

                tv1.setText(bloodtype+"형 "+gender+"입니다!");

                //Setting tv2
                height=Double.parseDouble(edt1.getText().toString());
                weight=Double.parseDouble(edt2.getText().toString());
                bmi = weight/((height/100)*(height/100));
                bmi=Double.parseDouble(String.format("%.2f", bmi));

                tv2.setText("신체질량지수는 "+bmi+"입니다!");

                //Setting gallery
                arrlist.clear();
                if(cb1.isChecked()){
                    arrlist.add(R.drawable.drinking);
                }if(cb2.isChecked()){
                    arrlist.add(R.drawable.ciga);
                }if(!cb3.isChecked()){
                    arrlist.add(R.drawable.running);
                }

                Gallery gallery=(Gallery) findViewById(R.id.gallery);
                MyGalleryAdapter myGalleryAdapter= new MyGalleryAdapter(MainActivity.this);
                gallery.setAdapter(myGalleryAdapter);
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
            return arrlist.size();
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
            imageView.setLayoutParams(new Gallery.LayoutParams(600,600));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,5,5);
            imageView.setImageResource(arrlist.get(position));
            return imageView;
        }
    }
}
