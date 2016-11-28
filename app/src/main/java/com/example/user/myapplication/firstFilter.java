package com.example.user.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class firstFilter extends AppCompatActivity {

    String[] m_lecturerList= new String[]{
            "A",
            "B",
            "C"
    };


    String[] m_courseList= new String[]{
            "1",
            "2",
            "3"
    };
    String m_lecturerSelected = "";
    String m_courseSelected = "";

    Button m_rank;

    ArrayAdapter m_lecturerAdapter, m_courseAdapter;
    ListView m_LecturerListView, m_courseListView;

    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_filter);

        m_LecturerListView = (ListView) findViewById(R.id.LecturerList);
        m_courseListView =  (ListView) findViewById(R.id.CourseList);

        m_lecturerAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, m_lecturerList);
        m_courseAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, m_courseList);

        m_LecturerListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        m_courseListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);


        if( m_LecturerListView != null){
            m_LecturerListView.setAdapter(m_lecturerAdapter);
        }
        if( m_courseListView != null){
            m_courseListView.setAdapter(m_courseAdapter);
        }

        m_LecturerListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                m_lecturerSelected = m_lecturerList[position];
            }
            });

        m_courseListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                m_courseSelected = m_courseList[position];
            }
        });

        m_rank = (Button)findViewById(R.id.RankButton);


        m_rank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                GetInfo();

            }


        });
    }
    private void GetInfo() {

        if(m_courseSelected.equals("") && m_lecturerSelected.equals("")){
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(context);

            dlgAlert.setMessage("please choose lecturer of course");
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

        if(!m_courseSelected.equals("") && !m_lecturerSelected.equals("")){
           // firstquery
        }
        else if(!m_courseSelected.equals("") ){
            Intent intent = new Intent(context, LecturerWindow.class);
            startActivity(intent);
            //secondquery
        }
        else if(!m_lecturerSelected.equals("") ){
            Intent intent = new Intent(context, ChooseLecturer.class);
            startActivity(intent);
            //thirdquery
        }

    }
}
