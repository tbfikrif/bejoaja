package com.babage.b370;

public class ChatModel {
    public String chatMessage;
    public boolean isSend;

    public ChatModel(String chatMessage,boolean isSend){
        this.chatMessage=chatMessage;
        this.isSend=isSend;
    }

    public String getChatMessage(){
        return chatMessage;
    }

    public void setChatMessage(String chatMessage) {
        this.chatMessage=chatMessage;
    }

    public boolean isSend(){
        return isSend;
    }

}
