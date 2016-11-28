package com.example.user.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button m_register, m_login;
    EditText m_userName,m_password;
    Context context = this;
    DBHelper _myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _myDB= new DBHelper(this);
        _myDB.start();  // initialize the DB
        m_register = (Button)findViewById(R.id.registerButton);
        m_login = (Button)findViewById(R.id.loginButton);

        m_userName= (EditText)findViewById(R.id.nameEditText);
        m_password = (EditText)findViewById(R.id.passwordEditText);

        m_userName.setText("litaf");
        m_password.setText("2");

        m_userName.setSingleLine(true);
        m_password.setSingleLine(true);

        m_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), Register.class);
                startActivity(intent);
            }
        });

        m_login.setOnClickListener(new View.OnClickListener() {
                            @Override
            public void onClick(View v)
            {
                if(m_userName.getText().toString().equals("") && m_password.getText().toString().equals(""))
                {
                    AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(context);

                    dlgAlert.setMessage("insert password and username");
                    dlgAlert.setTitle("Error");
                    dlgAlert.setPositiveButton("OK", null);
                    dlgAlert.setCancelable(true);
                    dlgAlert.create().show();

                    dlgAlert.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                return;
                                }
                            });
                }
                else{
                    Intent intent = new Intent(v.getContext(), firstFilter.class);
                    startActivity(intent);

                }
            }
        });

    }
}
