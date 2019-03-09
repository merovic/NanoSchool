package com.amirahmed.nanoschool.Models.GuestLogin;

public class CultureItem {

    String imageURL;
    String title;
    String subtitle;
    String date;
    String content;

    public CultureItem(String title, String subtitle, String date, String content) {
        this.title = title;
        this.subtitle = subtitle;
        this.date = date;
        this.content = content;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
