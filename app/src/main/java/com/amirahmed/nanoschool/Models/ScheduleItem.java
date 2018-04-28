package com.amirahmed.nanoschool.Models;


public class ScheduleItem {

    public String className;
    public String subjectName;
    public String classRoom;
    public String from;
    public String to;


    public ScheduleItem(String className, String subjectName, String classRoom, String from, String to) {
        this.className = className;
        this.subjectName = subjectName;
        this.classRoom = classRoom;
        this.from = from;
        this.to = to;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
