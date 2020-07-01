package com.example.onetomanyexample;


import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

/*** EXCLUSIVE CLASS TO MANAGE ONE TO MANY IN ROOM  ***/
public class CourseWithStudents {

    @Embedded
    public Course course;
    @Relation(
            parentColumn = "id_course",
            entityColumn = "id_student"
    )
    public List<Student> students;

    public CourseWithStudents(Course course, List<Student> students) {
        this.course = course;
        this.students = students;
    }



}
