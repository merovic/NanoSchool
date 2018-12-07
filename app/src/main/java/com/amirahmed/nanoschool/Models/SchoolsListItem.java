package com.amirahmed.nanoschool.Models;

public class SchoolsListItem {


    String schoolName;
    String schoolStatus;
    String schoolType;
    String schoolDistance;

    public SchoolsListItem(String schoolName, String schoolStatus, String schoolDistance, String schoolType) {
        this.schoolName = schoolName;
        this.schoolStatus = schoolStatus;
        this.schoolDistance = schoolDistance;
        this.schoolType = schoolType;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolStatus() {
        return schoolStatus;
    }

    public void setSchoolStatus(String schoolStatus) {
        this.schoolStatus = schoolStatus;
    }

    public String getSchoolDistance() {
        return schoolDistance;
    }

    public void setSchoolDistance(String schoolDistance) {
        this.schoolDistance = schoolDistance;
    }

    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
    }
}
