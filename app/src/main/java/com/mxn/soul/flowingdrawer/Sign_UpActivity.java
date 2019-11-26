package com.mxn.soul.flowingdrawer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Sign_UpActivity extends AppCompatActivity {
    private DatabaseReference database;
    private EditText nickname,userid,password,password2,useremail,useremailcode;
    private Button btn_nickname,btn_userid,btn_useremail,btn_useremailcode,btn_join,btn_cancel;
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


        btn_nickname.setOnClickListener(new View.OnClickListener() {//닉네임 중복 버튼을 눌렀을때
            @Override
            public void onClick(View view) {
                //닉네임 중복확인
            }
        });

        btn_userid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ID중복 확인
            }
        });



    }
}
