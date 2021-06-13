package com.uxfinalproject.wrcomic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    TextInputEditText tf_uname, tf_pass;
    TextView error_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btnLogin);
        tf_uname = findViewById(R.id.tf_username);
        tf_pass = findViewById(R.id.tf_password);
        error_txt = findViewById(R.id.error_txt);

       btnLogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               if(tf_uname.length()>4&&tf_uname.length()<8 && tf_pass.length()>1){
                   error_txt.setVisibility(View.GONE);
                   Intent i = new Intent(LoginActivity.this, MainActivity.class);
                   i.putExtra("nama", String.valueOf(tf_uname.getText()));
                   startActivity(i);
               }else if(tf_uname.length()<1||tf_pass.length()<1){
                   error_txt.setText("Username/Password must be filled");
               }else if(tf_uname.length()<=4||tf_uname.length()>=8){
                   error_txt.setText("Username must be greater than 4 and less than 8");
               }

           }
       });
    }
}