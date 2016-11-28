package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class LecturerWindow extends AppCompatActivity {

    TextView  m_name;
    EditText m_AttitudeTextViewRank, m_preparednessTextViewRank, m_interestTextViewRank, m_teachingLevelTextViewRank, m_generalRankTextViewRank;
    DBHelper _myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_window);

        _myDB = new DBHelper(this);
        m_name=(TextView)findViewById(R.id.LecturerName);
        //lecturer name query
        m_name.setText("Litaf Kupfer");

        m_AttitudeTextViewRank = (EditText)findViewById(R.id.AttitudeTextViewRank);
        m_AttitudeTextViewRank.setText("5");

        m_preparednessTextViewRank = (EditText)findViewById(R.id.preparednessTextViewRank);
        m_preparednessTextViewRank.setText("7");

        m_interestTextViewRank= (EditText)findViewById(R.id.interestTextViewRank);
        m_interestTextViewRank.setText("8");

        m_teachingLevelTextViewRank=(EditText)findViewById(R.id.teachingLevelTextViewRank);
        m_teachingLevelTextViewRank.setText("8");

        m_generalRankTextViewRank =(EditText)findViewById(R.id.generalRankTextViewRank);
        m_generalRankTextViewRank.setText("9.5");


    }
}
