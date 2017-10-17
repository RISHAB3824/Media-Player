package com.example.rishab.muzikkk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button sigin=(Button) findViewById(R.id.btn_login);
        TextView reg=(TextView)findViewById(R.id.btnregister);

        sigin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText username=(EditText)findViewById(R.id.editTextusername);
                EditText password=(EditText)findViewById(R.id.editTextpwd);

                String uname=username.getText().toString();
                String pwd=password.getText().toString();
                UserDbHelper udb=new UserDbHelper(Login.this);

                ArrayList<String> al= udb.getUserDetail(uname,pwd);
                String name1=al.get(0);
                String email1=al.get(1);
                Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("name2",name1);
                intent.putExtra("email2",email1);
                startActivity(intent);
            }
        });

        reg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                Intent intent= new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });
    }
}
