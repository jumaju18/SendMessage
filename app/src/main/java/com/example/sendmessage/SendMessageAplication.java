package com.example.sendmessage;

import android.app.Application;

import com.example.sendmessage.modelo.User;

public class SendMessageAplication extends Application {
    private User user;

    @Override
    public void onCreate() {
        super.onCreate();
        user = new User("jf", "jf", "jumaju01_@hotmail.com");
    }

    public User getUser() {
        return user;
    }
}
