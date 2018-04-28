package com.amirahmed.nanoschool.Models;



public class TermItem {

    public String title;
    public int subject;

    public TermItem(String title, int subject) {
        this.title = title;
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSubject() {
        return subject;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }
}
