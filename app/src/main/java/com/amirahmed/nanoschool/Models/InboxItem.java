package com.amirahmed.nanoschool.Models;



public class InboxItem {

    public String senderName;
    public String messageHeader;
    public String messageBody;
    public String Date;

    public InboxItem(String senderName, String messageHeader, String messageBody, String date) {
        this.senderName = senderName;
        this.messageHeader = messageHeader;
        this.messageBody = messageBody;
        Date = date;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getMessageHeader() {
        return messageHeader;
    }

    public void setMessageHeader(String messageHeader) {
        this.messageHeader = messageHeader;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
