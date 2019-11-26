package com.mxn.soul.flowingdrawer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.Inet4Address;

public class HomeActivity extends AppCompatActivity {
    private Button login,signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        login = findViewById(R.id.btn_login);
        signup =findViewById(R.id.btn_signup);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginintent = new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(loginintent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signupintent = new Intent(HomeActivity.this,Sign_UpActivity.class);
                startActivity(signupintent);
            }
        });

    }
}
