package com.amirahmed.nanoschool.Models;



public class SchoolEvent {

    String eventName;
    String dayName;
    String dayMonth;
    String dateHijry;


    public SchoolEvent(String eventName, String dayName, String dayMonth, String dateHijry) {
        this.eventName = eventName;
        this.dayName = dayName;
        this.dayMonth = dayMonth;
        this.dateHijry = dateHijry;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public String getDayMonth() {
        return dayMonth;
    }

    public void setDayMonth(String dayMonth) {
        this.dayMonth = dayMonth;
    }

    public String getDateHijry() {
        return dateHijry;
    }

    public void setDateHijry(String dateHijry) {
        this.dateHijry = dateHijry;
    }
}
