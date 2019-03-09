package com.amirahmed.nanoschool.Models;

import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;

public class ChatItem {

    private String message;
    private String user_image;
    private String sender;
    private Date timeStamp;

    public ChatItem() {
        //empty constructor needed
    }

    public ChatItem(String message, String user_image, String sender, Date timeStamp) {
        this.message = message;
        this.user_image = user_image;
        this.sender = sender;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUser_image() {
        return user_image;
    }

    public void setUser_image(String user_image) {
        this.user_image = user_image;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @ServerTimestamp
    public Date getTimestamp() { return timeStamp; }

    public void setTimestamp(Date timestamp) { timeStamp = timestamp; }
}