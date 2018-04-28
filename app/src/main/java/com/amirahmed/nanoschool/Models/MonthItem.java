package com.amirahmed.nanoschool.Models;



public class MonthItem {

    public String examDate1;
    public String examDate2;
    public String exam;
    public String teacherName;
    public String finalScore;
    public String passScore;

    public MonthItem(String examDate1, String examDate2, String exam, String teacherName, String finalScore, String passScore) {
        this.examDate1 = examDate1;
        this.examDate2 = examDate2;
        this.exam = exam;
        this.teacherName = teacherName;
        this.finalScore = finalScore;
        this.passScore = passScore;
    }

    public String getExamDate1() {
        return examDate1;
    }

    public void setExamDate1(String examDate1) {
        this.examDate1 = examDate1;
    }

    public String getExamDate2() {
        return examDate2;
    }

    public void setExamDate2(String examDate2) {
        this.examDate2 = examDate2;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(String finalScore) {
        this.finalScore = finalScore;
    }

    public String getPassScore() {
        return passScore;
    }

    public void setPassScore(String passScore) {
        this.passScore = passScore;
    }
}
