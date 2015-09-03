package com.tictaeto.x_project.items;

import java.util.List;

/**
 * Created by DEN on 29.08.2015.
 */
public class ChatItem {

    private int chatID;
    private String name;
    private List<String> messages;
    private String dateTime;

    public int getChatID() {
        return chatID;
    }

    public void setChatID(int chatID) {
        this.chatID = chatID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public String getLastMessageDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

}
