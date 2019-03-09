package com.amirahmed.nanoschool.Utils;

public class FilterSubmission {

    String distance;
    String fees;
    String gender;
    String type;
    String course;


    public FilterSubmission(String distance, String fees, String gender, String type, String course) {
        this.distance = distance;
        this.fees = fees;
        this.gender = gender;
        this.type = type;
        this.course = course;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
