package com.amirahmed.nanoschool.Models.GuestLogin;

public class ComparisonItem {

    String point1;
    String pointComparison;
    String point2;

    public ComparisonItem(String point1, String pointComparison, String point2) {
        this.point1 = point1;
        this.pointComparison = pointComparison;
        this.point2 = point2;
    }

    public String getPoint1() {
        return point1;
    }

    public void setPoint1(String point1) {
        this.point1 = point1;
    }

    public String getPointComparison() {
        return pointComparison;
    }

    public void setPointComparison(String pointComparison) {
        this.pointComparison = pointComparison;
    }

    public String getPoint2() {
        return point2;
    }

    public void setPoint2(String point2) {
        this.point2 = point2;
    }
}
