package com.rumble.sample;


import android.app.NotificationManager;
import android.util.Log;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.SystemService;

@EBean
public class MyClass {

    @SystemService
    NotificationManager notificationManager;

    @Bean
    MyOtherClass myOther;

    public MyClass() {
        // notificationManager and myOther are null
    }

    public int doSomething()
    {
        return 3;
    }

    @AfterInject
    public void doSomethingAfterInjection() {
        // notificationManager and myOther are set

        int y = myOther.getOne();
        Log.v("tag", String.valueOf(y));
    }

}