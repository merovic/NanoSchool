package com.amirahmed.nanoschool.Models.GuestLogin;

public class FeesItem {

    String title;
    String total;
    String uniform;
    String books;
    String bus;

    public FeesItem(String title, String total, String uniform, String books, String bus) {
        this.title = title;
        this.total = total;
        this.uniform = uniform;
        this.books = books;
        this.bus = bus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getUniform() {
        return uniform;
    }

    public void setUniform(String uniform) {
        this.uniform = uniform;
    }

    public String getBooks() {
        return books;
    }

    public void setBooks(String books) {
        this.books = books;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }
}
