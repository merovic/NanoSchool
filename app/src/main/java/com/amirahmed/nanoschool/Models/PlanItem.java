package com.amirahmed.nanoschool.Models;



public class PlanItem {

    public String subjectName;
    public String teacherName;
    public String title;
    public String goals;
    public String homework;
    public String attachments;

    public PlanItem(String subjectName, String teacherName, String title, String goals, String homework, String attachments) {
        this.subjectName = subjectName;
        this.teacherName = teacherName;
        this.title = title;
        this.goals = goals;
        this.homework = homework;
        this.attachments = attachments;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getHomework() {
        return homework;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }
}
