package com.example.onetomanyexample;

import android.app.Application;
import android.os.AsyncTask;

public class CourseRepository {

    private CourseDao courseDao;

    public CourseRepository(Application application) {
        Database database = Database.getDatabase(application);
        courseDao = database.courseDao();
    }

    public void insert(CourseWithStudents courseWithStudents) {
        new insertAsync(courseDao).execute(courseWithStudents);
    }

    private static class insertAsync extends AsyncTask<CourseWithStudents, Void, Void> {
        private CourseDao courseDaoAsync;

        insertAsync(CourseDao courseDao) {
            courseDaoAsync = courseDao;
        }

        @Override
        protected Void doInBackground(CourseWithStudents... courseWithStudents) {

            long identifier = courseDaoAsync.insertCourse(courseWithStudents[0].course);

            for (Student student : courseWithStudents[0].students) {
                student.setId_fkcourse(identifier);
            }
            courseDaoAsync.insertStudents(courseWithStudents[0].students);
            return null;
        }
    }

}
