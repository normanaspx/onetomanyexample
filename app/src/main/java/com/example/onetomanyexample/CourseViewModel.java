package com.example.onetomanyexample;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class CourseViewModel extends AndroidViewModel {

    public CourseViewModel(@NonNull Application application) {
        super(application);
        courseRepository = new CourseRepository(application);
    }

    private CourseRepository courseRepository;

    public void insertCourseWithStudents(CourseWithStudents courseWithStudents){
        courseRepository.insert(courseWithStudents);
    }
}
