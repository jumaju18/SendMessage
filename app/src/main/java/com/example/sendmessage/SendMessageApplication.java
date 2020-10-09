package com.example.sendmessage;

import android.app.Application;

import com.example.sendmessage.model.User;

public class SendMessageApplication extends Application {

    private User user;

    @Override
    public void onCreate() {
        super.onCreate();
        user = new User("Israel", "Israel", "ejemplo@gmail.com");
    }

    public User getUser() {
        return user;
    }
}
