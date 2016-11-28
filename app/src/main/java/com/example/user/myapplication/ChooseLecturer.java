package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ChooseLecturer extends AppCompatActivity {

    String[] m_lecturerList1= new String[]{
            "A",
            "B",
            "C"
    };

    String m_lecturerSelected;
    ArrayAdapter m_lecturerAdapter;
    ListView m_LecturerListView;

    Button m_RankButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_lecturer);


        m_RankButton = (Button) findViewById(R.id.RankButton2);
        m_LecturerListView = (ListView) findViewById(R.id.LecturerList);

        m_lecturerAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, m_lecturerList1);

        m_LecturerListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);


        if( m_LecturerListView != null){
            m_LecturerListView.setAdapter(m_lecturerAdapter);
        }

        m_LecturerListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                m_lecturerSelected = m_lecturerList1[position];
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
