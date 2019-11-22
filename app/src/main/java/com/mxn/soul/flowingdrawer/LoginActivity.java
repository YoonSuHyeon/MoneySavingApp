package com.mxn.soul.flowingdrawer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {
    Button loginButton;
    TextView findIdTextView,sign_up_TextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton =findViewById(R.id.loginButton);
        findIdTextView= findViewById(R.id.findIdTextView);
        sign_up_TextView= findViewById(R.id.sign_up_TextView);

        loginButton.setOnClickListener(new View.OnClickListener() { //Click loginButton
            @Override
            public void onClick(View view) {
                Intent loginintent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(loginintent);
            }
        });

        findIdTextView.setOnClickListener(new View.OnClickListener() {//Click findIdTextView
            @Override
            public void onClick(View view) {
                Intent findIdintent=new Intent(LoginActivity.this,Find_ID_PWActivity.class);
                startActivity(findIdintent);
            }
        });

        sign_up_TextView.setOnClickListener(new View.OnClickListener() {//Click sign_up_TextView
            @Override
            public void onClick(View view) {
                Intent sign_upintent=new Intent(LoginActivity.this,Sign_UpActivity.class);
                startActivity(sign_upintent);
            }
        });
    }
}
