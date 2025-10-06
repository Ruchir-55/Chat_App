package com.ruchir55.chatapp.models;

public class MessagesModel {

    String senderid;
    String receiverId;
    String messageid;
    String message;

    public MessagesModel() {

    }

    public MessagesModel(String senderid, String receiverId, String messageid, String message) {
        this.message = message;
        this.senderid = senderid;
        this.messageid = messageid;
        this.receiverId = receiverId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public String getMessageid() {
        return messageid;
    }

    public String getMessage() {
        return message;
    }

    public String getSenderid() {
        return senderid;
    }

}
