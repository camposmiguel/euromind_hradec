package com.miguelcr.optionsmenu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView studentsListView;
    //String[] students;
    List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //students = new String[] {"Tom", "John", "Lukas", "David", "..."};
        studentList = new ArrayList<>();
        studentList.add(new Student(R.drawable.ic_female,18,"Maria"));
        studentList.add(new Student(R.drawable.ic_male,21,"Martin"));
        studentList.add(new Student(R.drawable.ic_male,19,"Lukas"));


        // Get the reference for the ListView component that exists in the layout
        studentsListView = (ListView) findViewById(R.id.listViewStudents);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                //android.R.layout.simple_list_item_1, students);

        StudentAdapter adapter = new StudentAdapter(MainActivity.this, R.layout.item_list_student,studentList);

        studentsListView.setAdapter(adapter);

        // Click on the items of the ListView
        studentsListView.setOnItemClickListener(this);
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.options_menu_users, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_add_user:
                Toast.makeText(this,"Click on Add User",Toast.LENGTH_LONG).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this, "Click on: "+studentList.get(position), Toast.LENGTH_SHORT).show();
        view.animate().rotationX(360).setDuration(2000);
    }
}
