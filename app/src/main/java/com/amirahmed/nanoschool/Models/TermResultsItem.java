package com.amirahmed.nanoschool.Models;



public class TermResultsItem {
    public String result;
    public String subject;

    public TermResultsItem(String result, String subject) {
        this.result = result;
        this.subject = subject;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
