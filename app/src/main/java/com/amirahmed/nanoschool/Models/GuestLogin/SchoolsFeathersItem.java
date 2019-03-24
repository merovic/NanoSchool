package com.amirahmed.nanoschool.Models.GuestLogin;

public class SchoolsFeathersItem {

    String background;
    String logo;
    String text;

    public SchoolsFeathersItem(String background, String logo, String text) {
        this.background = background;
        this.logo = logo;
        this.text = text;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
