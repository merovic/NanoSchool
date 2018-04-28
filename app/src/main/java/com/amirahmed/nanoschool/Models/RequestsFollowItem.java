package com.amirahmed.nanoschool.Models;



public class RequestsFollowItem {

    String requestNumber;
    String requestName;
    int requestStatusPic;
    String requestStatus;

    public RequestsFollowItem(String requestNumber, String requestName, int requestStatusPic, String requestStatus) {
        this.requestNumber = requestNumber;
        this.requestName = requestName;
        this.requestStatusPic = requestStatusPic;
        this.requestStatus = requestStatus;
    }

    public String getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(String requestNumber) {
        this.requestNumber = requestNumber;
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public int getRequestStatusPic() {
        return requestStatusPic;
    }

    public void setRequestStatusPic(int requestStatusPic) {
        this.requestStatusPic = requestStatusPic;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }
}
