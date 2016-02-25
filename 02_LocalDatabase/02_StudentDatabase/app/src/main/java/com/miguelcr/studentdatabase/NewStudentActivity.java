package com.miguelcr.studentdatabase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.miguelcr.studentdatabase.dao.StudentDao;
import com.miguelcr.studentdatabase.entities.Student;

public class NewStudentActivity extends AppCompatActivity {
    private EditText editTextName, editTextAge;
    private String selectedSex = null;
    private StudentDao studentDao;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_student);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextAge = (EditText) findViewById(R.id.editTextAge);
        btnSave = (Button) findViewById(R.id.buttonSave);

        studentDao = DabataseConnection.getStudentDao(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String age = editTextAge.getText().toString();

                if(name.isEmpty() || age.isEmpty() || selectedSex.equals(null)) {
                    Toast.makeText(NewStudentActivity.this,"Fill all fields",Toast.LENGTH_LONG).show();
                } else {
                    Student newStudent = new Student();
                    newStudent.setName(name);
                    newStudent.setAge(Integer.valueOf(age));
                    newStudent.setSex(selectedSex);

                    studentDao.insert(newStudent);

                    // Destroy the activity and return the result
                    setResult(RESULT_OK);
                    finish();

                }

            }
        });

    }

    public void changeSex(View v) {
        int id = v.getId();
        if(id==R.id.radioButtonMale) {
            selectedSex = "male";
        } else {
            selectedSex = "female";
        }
    }
}
