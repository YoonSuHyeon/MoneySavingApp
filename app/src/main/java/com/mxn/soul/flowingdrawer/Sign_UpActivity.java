package com.mxn.soul.flowingdrawer;

import android.content.Intent;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.StringTokenizer;

public class Sign_UpActivity extends AppCompatActivity {
    private DatabaseReference database;
    private EditText nickname,userid,password,password2,useremail,useremailcode;
    private Button btn_nickname,btn_userid,btn_useremail,btn_useremailcode,btn_join,btn_cancel;
    GMailSender gMailSender;
    int checkuserid=0,checkusernickname=0,checkpassword=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up);
        database= FirebaseDatabase.getInstance().getReference();
        nickname=findViewById(R.id.et_nickname);
        btn_nickname=findViewById(R.id.btn_nickname);
        userid=findViewById(R.id.et_userID);
        btn_userid=findViewById(R.id.btn_userID);
        password=findViewById(R.id.et_Password);
        password2=findViewById(R.id.et_Password2);
        useremail=findViewById(R.id.et_userEmail);
        btn_useremail=findViewById(R.id.btn_userEmail);
        useremailcode=findViewById(R.id.et_userMailcode);
        btn_useremailcode=findViewById(R.id.btn_userEmailcode);
        btn_cancel=findViewById(R.id.btn_cancel);
        btn_join=findViewById(R.id.btn_join);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .permitDiskReads()
                .permitDiskWrites()
                .permitNetwork().build());  //이메일 사용을 위한 준비
        gMailSender = new GMailSender("tngus4753","youn4948!!"); //gmail 아이디 보내는사람


        btn_nickname.setOnClickListener(new View.OnClickListener() {//닉네임 중복 버튼을 눌렀을때
            @Override
            public void onClick(View view) {
                //닉네임 중복확인
                DatabaseReference table_user = database.child("Users");
                ValueEventListener vListener = new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                            for (DataSnapshot da : dataSnapshot.getChildren()) {
                                String mynickname = nickname.getText().toString();
                                String dbnickname = da.child("nickname").getValue(String.class);
                                if (mynickname.equals(dbnickname)) {
                                    Toast.makeText(Sign_UpActivity.this, "중복된 닉네임 입니다.", Toast.LENGTH_SHORT).show();
                                    checkusernickname = 1; //1이면 중복된 닉네임이 존재할경우
                                    break;
                                }
                            }
                        }
                        if(checkusernickname==0){
                            Toast.makeText(Sign_UpActivity.this, "사용가능한 닉네임 입니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onCancelled (@NonNull DatabaseError databaseError){

                    }

                };
                table_user.addListenerForSingleValueEvent(vListener);
            }
        });




        btn_userid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ID중복 확인
                DatabaseReference table_user = database.child("Users");
                ValueEventListener vListener = new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                            for (DataSnapshot da : dataSnapshot.getChildren()) {
                                String id = userid.getText().toString();
                                String dbId = da.child("id").getValue(String.class);
                                if (id.equals(dbId)) {
                                    Toast.makeText(Sign_UpActivity.this, "아이디가 이미 있습니다.", Toast.LENGTH_SHORT).show();
                                    checkuserid = 1; //1이면 중복된 아이디가 존재할경우
                                    break;
                                }
                            }
                        }
                        if(checkuserid==0){
                            Toast.makeText(Sign_UpActivity.this, "사용가능한 아이디 입니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onCancelled (@NonNull DatabaseError databaseError){

                    }

                };
                table_user.addListenerForSingleValueEvent(vListener);
            }
        });

        btn_useremail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //중복된 이메일이 있는지 확인
            }
        });




    }
}
