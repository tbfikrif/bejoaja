package com.babage.b370;

import android.graphics.Bitmap;
import android.widget.ImageView;

import java.util.ArrayList;

public class ChatModel {
    public String chatMessage;
    private ImageView mImages;
    public boolean isSend;

    public ChatModel(String chatMessage,ImageView mImages,boolean isSend){
        this.chatMessage=chatMessage;
        this.mImages=mImages;
        this.isSend=isSend;
    }

    public String getChatMessage(){
        return chatMessage;
    }

    public void setChatMessage(String chatMessage) {
        this.chatMessage=chatMessage;
    }

    public ImageView getmImages(){
        return mImages;
    }

    public void setmImages(ImageView mImages){
        this.mImages=mImages;
    }

    public boolean isSend(){
        return isSend;
    }

}
