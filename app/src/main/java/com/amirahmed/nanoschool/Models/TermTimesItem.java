package com.amirahmed.nanoschool.Models;



public class TermTimesItem {

    public String subjectName;
    public String date;
    public String time;

    public TermTimesItem(String subjectName, String date, String time) {
        this.subjectName = subjectName;
        this.date = date;
        this.time = time;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
