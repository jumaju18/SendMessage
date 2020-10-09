package com.example.sendmessage.model;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Objects;


/**
 * Clase POJO que modelo un mensaje de la aplicación
 * @author Israel Navarrete
 * @version 1-0 06/10/2020
 */
public class Message implements Serializable {

    private User user;
    private String message;
    private String date;

    public Message(User user, String message, String date) {
        this.user = user;
        this.message = message;
        this.date = date;
    }

    public Message() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @NonNull
    @Override
    public String toString() {
        return "User{" +
                "user='" + user + '\'' +
                ", message='" + message +'\'' +
                ", date" + date + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (!user.equals(message.user)) return false;
        return date.equals(message.date);
    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }
}
