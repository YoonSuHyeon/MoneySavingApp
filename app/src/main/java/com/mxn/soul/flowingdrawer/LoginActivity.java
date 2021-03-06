package com.mxn.soul.flowingdrawer;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class LoginActivity extends AppCompatActivity {

    private String dbparent;
    private Button ok;
    private TextView find;
    private EditText et_id,et_password;
    private DatabaseReference database;
    private int checklogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ok = findViewById(R.id.btn_ok);
        find = findViewById(R.id.tv_find);
        et_id=findViewById(R.id.et_id);
        et_password=findViewById(R.id.et_password);



        database = FirebaseDatabase.getInstance().getReference();
        ok.setOnClickListener(new View.OnClickListener() {//확인 버튼을 눌렀을때
            @Override
            public void onClick(View view) {
                login();

            }
        });
        find.setOnClickListener(new View.OnClickListener() { //아이디 비밀 번호 찾기 TextView 를 눌렀을때
            @Override
            public void onClick(View view) {
                Intent findintent = new Intent(LoginActivity.this, Find_ID_PWActivity.class);
                startActivity(findintent);
            }
        });
    }

    public void login() {
        checklogin = 0;
        DatabaseReference table_user = database.child("Users");
        ValueEventListener vListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                    for (DataSnapshot da : dataSnapshot.getChildren()) {
                        String checkId = et_id.getText().toString();
                        String checkpassword = et_password.getText().toString();

                        String dbId = da.child("id").getValue(String.class);
                        String dbpassword = da.child("password").getValue(String.class);


                        if (checkId.equals(dbId) && checkpassword.equals(dbpassword)) {
                            dbparent = da.getKey();
                            checklogin = 1;
                            break;

                        }
                    }
                }
                if (checklogin == 1) {
                    Toast.makeText(LoginActivity.this, "로그인이 되었습니다.", Toast.LENGTH_SHORT).show();

                    Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
                    loginIntent.putExtra("uid", dbparent); // 유저의 UID를 인텐트로 보내기 위함
                    startActivity(loginIntent);
                    }
                else {
                    Toast.makeText(LoginActivity.this, "로그인 실패.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        };
        table_user.addListenerForSingleValueEvent(vListener);

    }
}