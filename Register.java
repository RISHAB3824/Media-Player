package com.example.rishab.muzikkk;






import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button reg1=(Button) findViewById(R.id.buttonRegister_reg);

        reg1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText username=(EditText)findViewById(R.id.editusername_reg);
                EditText password=(EditText)findViewById(R.id.editpassword_reg);
                EditText email1=(EditText)findViewById(R.id.editemail);
                EditText name1=(EditText)findViewById(R.id.editname);
                EditText contact1=(EditText)findViewById(R.id.editcontact_no);

                username.setError("Enter Credentials");
                password.setError("Enter Password < 8");
                name1.setError("Please Enter Ur Name");

                String uname=username.getText().toString();
                String pwd=password.getText().toString();
                String email=email1.getText().toString();
                String name=name1.getText().toString();
                String contact=contact1.getText().toString();

                UserDbHelper udb=new UserDbHelper(Register.this);
                boolean b=udb.add_user(uname,pwd,email,name,contact);
                if(b==true)
                {
                    Toast.makeText(getApplicationContext(), "Successfully Registered",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(getApplicationContext(),Login.class);
                    startActivity(intent);
                }else
                {
                    Toast.makeText(getApplicationContext(), "not Registered", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}



