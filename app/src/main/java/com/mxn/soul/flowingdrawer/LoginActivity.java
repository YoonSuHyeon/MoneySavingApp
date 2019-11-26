package com.mxn.soul.flowingdrawer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {
private Button ok;
private TextView find;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ok=findViewById(R.id.btn_ok);
        find=findViewById(R.id.tv_find);

        ok.setOnClickListener(new View.OnClickListener() {//확인 버튼을 눌렀을때
            @Override
            public void onClick(View view) {
                Intent okintent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(okintent);
            }
        });
        find.setOnClickListener(new View.OnClickListener() { //아이디 비밀 번호 찾기 TextView 를 눌렀을때
            @Override
            public void onClick(View view) {
                Intent findintent = new Intent(LoginActivity.this,Find_ID_PWActivity.class);
                startActivity(findintent);
            }
        });
    }
}
