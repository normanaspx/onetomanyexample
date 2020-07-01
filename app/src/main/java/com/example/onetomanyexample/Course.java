package com.example.onetomanyexample;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "course")
public class Course {

    @PrimaryKey(autoGenerate = true)
    private long id_course;
    private String courseName;

    public long getId_course() {
        return id_course;
    }

    public void setId_course(long id_course) {
        this.id_course = id_course;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Course(String courseName) {
        this.courseName = courseName;
    }

}
