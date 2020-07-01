package com.example.onetomanyexample;

import android.app.Application;

public class OneToManyApplication extends Application {

    public static OneToManyApplication getInstance(){
        return  instance;
    }
    private static OneToManyApplication instance;

    @Override
    public void onCreate() {
        instance=this;
        super.onCreate();
    }
}
