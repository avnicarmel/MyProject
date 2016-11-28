package com.example.user.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    Button m_submit,m_cancel;
    EditText m_userName, m_password, m_email;
    RadioGroup m_radioG;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        m_submit = (Button)findViewById(R.id.submitButton);
        m_cancel=  (Button)findViewById(R.id.cancelButton);

        m_userName=(EditText)findViewById(R.id.username);
        m_password=(EditText)findViewById(R.id.passwordText);
        m_email=(EditText)findViewById(R.id.emailText);

        m_radioG=(RadioGroup)findViewById(R.id.RGroup);

        m_cancel.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
            }
        });


        m_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckDetails();

            }
        });
    }


    private void CheckDetails() {

        int selectedId = m_radioG.getCheckedRadioButtonId();
        if(m_userName.getText().toString().equals("")
             || m_password.getText().toString().equals("")
             || m_email.getText().toString().equals("")
             || selectedId == -1)
              {
                    AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(context);

                    dlgAlert.setMessage("Enter username, password and email");
                    dlgAlert.setTitle("Error");
                    dlgAlert.setPositiveButton("OK", null);
                    dlgAlert.setCancelable(true);
                    dlgAlert.create().show();

                    dlgAlert.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            });
                }
                //query - email exist
                else if(m_email.getText().toString().equals("@"))
                {
                    AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(context);

                    dlgAlert.setMessage("user with this email already exist in the system");
                    dlgAlert.setTitle("Error");
                    dlgAlert.setPositiveButton("OK", null);
                    dlgAlert.setCancelable(true);
                    dlgAlert.create().show();

                    dlgAlert.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                }
                //login
                else{
                    //  SentEmail();
                    //query - add user
                    Toast.makeText(context, "WELCOME", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(context, MainActivity.class);
                    startActivity(intent);
                }
            }

//            private void SentEmail() {
//
//                String content = "Thank you for enrooling to דרגותו \n your username: "+ m_userName+"\n"+"password: "+m_password;
//
//                Intent i = new Intent(Intent.ACTION_SEND);
//                i.setType("message/rfc822");
//                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{m_email.getText().toString()});
//                i.putExtra(Intent.EXTRA_SUBJECT, "ברוכים הבאים לדרגותו");
//                i.putExtra(Intent.EXTRA_TEXT   ,content  );
//                try {
//                    startActivity(Intent.createChooser(i, "Send mail..."));
//                } catch (ActivityNotFoundException ex) {
//                    Toast.makeText(context, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
//                }
//
//            }

    }

