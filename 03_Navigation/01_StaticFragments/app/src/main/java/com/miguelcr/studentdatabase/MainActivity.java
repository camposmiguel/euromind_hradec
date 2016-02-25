package com.miguelcr.studentdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.miguelcr.studentdatabase.dao.StudentDao;
import com.miguelcr.studentdatabase.entities.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listViewStudents;
    private StudentAdapter adapter;
    private List<Student> students;
    private StudentDao studentDao;
    private final int OPERATION_ADD_STUDENT = 1;
    private final int OPERATION_EDIT_STUDENT = 2;

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
                Intent i = new Intent(MainActivity.this, NewStudentActivity.class);
                startActivityForResult(i, OPERATION_ADD_STUDENT);
            }
        });

        studentDao = DabataseConnection.getStudentDao(this);
        students = new ArrayList<>();
        students.addAll(studentDao.loadAll());

        listViewStudents = (ListView) findViewById(R.id.listViewStudents);
        adapter = new StudentAdapter(this,students);
        listViewStudents.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==OPERATION_ADD_STUDENT) {
            students.clear();
            students.addAll(studentDao.loadAll());
            adapter.notifyDataSetChanged();

        } else if(requestCode==OPERATION_EDIT_STUDENT) {

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
