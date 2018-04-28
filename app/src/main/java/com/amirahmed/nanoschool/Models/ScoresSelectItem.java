package com.amirahmed.nanoschool.Models;


public class ScoresSelectItem {

    public String name;
    public String subjectname;
    public String percentage;


    public ScoresSelectItem(String name, String subjectname, String percentage) {
        this.name = name;
        this.subjectname = subjectname;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
}
