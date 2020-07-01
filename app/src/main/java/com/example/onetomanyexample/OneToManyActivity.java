package com.example.onetomanyexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class OneToManyActivity extends AppCompatActivity {

    private EditText txtName;
    private Button btnAdd, btnSave;
    private List<Student> students = new ArrayList<>();
    private CourseViewModel courseViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_to_many);

        txtName = findViewById(R.id.txtName);
        btnAdd = findViewById(R.id.btnAdd);
        btnSave= findViewById(R.id.btnSave);

        courseViewModel = ViewModelProviders.of(this)
                .get(CourseViewModel.class);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                students.add(new Student(txtName.getText().toString()));
                txtName.setText("");
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getIntent().getExtras();
                String course = bundle.getString("course");
                CourseWithStudents courseWithStudents =
                        new CourseWithStudents(new Course(course), students);

                courseViewModel.insertCourseWithStudents(courseWithStudents);

                Intent intent = new Intent(OneToManyActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
