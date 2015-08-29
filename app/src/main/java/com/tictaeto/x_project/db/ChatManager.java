package com.tictaeto.x_project.db;

import com.tictaeto.x_project.items.ChatItem;

/**
 * Created by DEN on 29.08.2015.
 */
public final class ChatManager {
    private static ChatManager instance = null;

    private ChatManager() {
    }

    public static ChatManager getInstance() {
        if (instance == null) {
            instance = new ChatManager();
        }
        return instance;
    }

    public ChatItem getChatBiID(int id) {
        return new ChatItem();
    }
}
