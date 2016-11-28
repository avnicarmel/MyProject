package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ChooseLecturer extends AppCompatActivity {

    String[] m_lecturerList;
    DBHelper _myDB;

    String m_lecturerSelected;
    ArrayAdapter m_lecturerAdapter;
    ListView m_LecturerListView;

    Button m_RankButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_lecturer);
        _myDB = new DBHelper(this);

        ArrayList<String> res = new ArrayList<String>();
        res = _myDB.getProfByInstitude("");

        m_lecturerList = new String[res.size()];
        for(int i=0; i < res.size() ; i++){
            m_lecturerList[i] = res.get(i);
        }



        m_RankButton = (Button) findViewById(R.id.RankButton2);
        m_LecturerListView = (ListView) findViewById(R.id.LecturerList);

        m_lecturerAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, m_lecturerList);

        m_LecturerListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);


        if( m_LecturerListView != null){
            m_LecturerListView.setAdapter(m_lecturerAdapter);
        }

        m_LecturerListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                m_lecturerSelected = m_lecturerList[position];
            }
        });


        m_RankButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                GetInfo();

            }

            private void GetInfo() {

                //


            }


        });

    }
}
