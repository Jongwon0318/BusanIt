package com.cookandroid.project7_3_plus;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtEmail;
    Button btn1;
    EditText dlgEdtName, dlgEdtEmail;
    TextView toastText1;
    View dialogView,toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사용자 정보 입력");

        edtName=(EditText) findViewById(R.id.edtName);
        edtEmail=(EditText) findViewById(R.id.edtEmail);
        btn1=(Button) findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView=(View) View.inflate(MainActivity.this, R.layout.dlg1,null);
                AlertDialog.Builder dlg=new AlertDialog.Builder(MainActivity.this);

                dlgEdtName=(EditText) dialogView.findViewById(R.id.dlgEdt1);
                dlgEdtEmail=(EditText) dialogView.findViewById(R.id.dlgEdt2);

                dlgEdtName.setText(edtName.getText());
                dlgEdtEmail.setText(edtEmail.getText());

                dlg.setTitle("사용자 정보 입력");
                dlg.setIcon(R.drawable.ic_menu_allfriends);
                dlg.setView(dialogView);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        edtName.setText(dlgEdtName.getText());
                        edtEmail.setText(dlgEdtEmail.getText());
                    }

                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast tst1=new Toast(MainActivity.this);
                        toastView=(View) View.inflate(MainActivity.this, R.layout.toast1,null);
                        toastText1=(TextView) toastView.findViewById(R.id.toastText1);
                        toastText1.setText("취소했습니다.");
                        tst1.setView(toastView);
                        Display display=((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                        tst1.setGravity(Gravity.TOP | Gravity.LEFT,
                                        (int)(Math.random()*display.getWidth()),
                                        (int)(Math.random()*display.getHeight()));
//                        int x=(int)(Math.random()*display.getWidth());
//                        int y=(int)(Math.random()*display.getHeight());
//                        tst1.setGravity(Gravity.TOP | Gravity.LEFT, x, y);
                        tst1.show();
                    }
                });
                dlg.show();
            }
        });
    }
}
