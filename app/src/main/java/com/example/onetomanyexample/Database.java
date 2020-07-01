package com.example.onetomanyexample;


import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {
        Course.class,
        Student.class
}
        , version = 2
        , exportSchema = false
)
public abstract class Database extends RoomDatabase {

    public abstract CourseDao courseDao();

    private static volatile Database INSTANCE;
    public static Database getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Database.class, "db_example")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
