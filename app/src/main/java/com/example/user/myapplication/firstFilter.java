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

import java.util.ArrayList;

public class firstFilter extends AppCompatActivity {

    String[] m_lecturerList;


    String[] m_courseList;
    String m_lecturerSelected = "";
    String m_courseSelected = "";

    DBHelper _myDB;

    Button m_rank;

    ArrayAdapter m_lecturerAdapter, m_courseAdapter;
    ListView m_LecturerListView, m_courseListView;

    Context context = this;
    String m_institude;

    public void firstFilter(String ins){
        m_institude = ins;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_filter);

        _myDB = new DBHelper(this);

        m_LecturerListView = (ListView) findViewById(R.id.LecturerList);
        m_courseListView =  (ListView) findViewById(R.id.CourseList);

        ArrayList<String> res = new ArrayList<String>();
        res = _myDB.getProfByInstitude(m_institude);

        m_lecturerList = new String[res.size()];
        for(int i=0; i < res.size() ; i++){
            m_lecturerList[i] = res.get(i);
        }

        ArrayList<String> resCu = new ArrayList<String>();
        res = _myDB.getCourseByInstitude(m_institude);

        m_courseList = new String[resCu.size()];
        for(int i=0; i < resCu.size() ; i++){
            m_courseList[i] = res.get(i);
        }


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
        else if(!m_lecturerSelected.equals("") ){

            Intent intent = new Intent(this, LecturerWindow.class);
            startActivity(intent);

            //secondquery
        }
        else if(!m_courseListView.equals("") ){
            Intent intent = new Intent(context, ChooseLecturer.class);
            startActivity(intent);
            //thirdquery
        }

    }
}
