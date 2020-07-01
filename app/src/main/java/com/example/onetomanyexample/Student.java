package com.example.onetomanyexample;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "student")
public class Student {

    @PrimaryKey(autoGenerate = true)
    private long id_student;

    @ForeignKey
            (entity = Course.class,
                    parentColumns = "id_course",
                    childColumns = "id_fkcourse",
                    onDelete = CASCADE
            )
    private long id_fkcourse;

    private String studentName;

    public long getId_student() {
        return id_student;
    }

    public Student(String studentName) {
        this.studentName = studentName;
    }

    public void setId_student(long id_student) {
        this.id_student = id_student;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public long getId_fkcourse() {
        return id_fkcourse;
    }

    public void setId_fkcourse(long id_course) {
        this.id_fkcourse = id_course;
    }


}
