package com.example.onetomanyexample;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface CourseDao {

    @Transaction
    @Insert
    long insertCourse(Course course);

    @Insert
    void insertStudents(List<Student> students);

}
