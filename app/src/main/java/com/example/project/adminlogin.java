package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class adminlogin extends AppCompatActivity {
    Button login;
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);
        login =(Button)findViewById(R.id.buttonlogin);
        username=(EditText)findViewById(R.id.editTextusername);
        password=(EditText)findViewById(R.id.editTextpassword);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name = username.getText().toString();
                String pass_word = password.getText().toString();
                if (TextUtils.isEmpty(user_name))
                {
                    username.setError("Invalid User Name");
                }
                else if(TextUtils.isEmpty(pass_word))
                {
                    password.setError("Invalid Password");
                }
                else
                {
                    if(user_name.equals("admin") & pass_word.equals("admin")){
                        Intent intent =new Intent(adminlogin.this,MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}