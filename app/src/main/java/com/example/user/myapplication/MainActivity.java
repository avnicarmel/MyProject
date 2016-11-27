package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button m_register, m_login;
    EditText m_userName,m_password;
    TextView m_errorMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_register = (Button)findViewById(R.id.registerButton);
        m_login = (Button)findViewById(R.id.loginButton);

        m_userName= (EditText)findViewById(R.id.nameEditText);
        m_password = (EditText)findViewById(R.id.passwordEditText);

        m_errorMessage =(TextView) findViewById(R.id.errorText);

        m_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_register);

            }
        });

        m_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(m_userName.toString() == "" || m_password.toString() == "")
                {
                    m_errorMessage.post(new Runnable() {
                        public void run() {
                            m_errorMessage.setText("insert user name and password");

                        }
                    });

                }
            }
        });

    }
}
