package com.tictaeto.x_project.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.tictaeto.x_project.items.ChatItem;

import java.util.ArrayList;

/**
 * Created by Denis Ligin on 29.08.2015.
 */
public final class ChatManager implements ColumnConstants {
    private static ChatManager instance = null;
    private DBHelper dbHelper;

    private ChatManager() {
        dbHelper = DBHelper.get();
    }

    public static ChatManager get() {
        if (instance == null) {
            instance = new ChatManager();
        }
        return instance;
    }

    public ChatItem getChatBiID(int id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ChatItem chatItem = new ChatItem();
        Cursor cursor = db.rawQuery("select * from chat where id=?", new String[]{String.valueOf(id)});

        chatItem.setChatID(id);
        chatItem.setName(cursor.getString(Chat.CHAT_NAME));
        chatItem.setDateTime(cursor.getString(Chat.LAST_MESSAGE_DATE_TIME));

        cursor.close();
        db.close();

        return chatItem;
    }

    public ArrayList<ChatItem> getChatList() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ArrayList<ChatItem> chatItemList = new ArrayList<ChatItem>();
        Cursor cursor = db.rawQuery("select * from chat order by last_message_datetime", null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ChatItem chatItem = new ChatItem();
            chatItem.setChatID(cursor.getInt(Chat.ID));
            chatItem.setName(cursor.getString(Chat.CHAT_NAME));
            chatItem.setDateTime(cursor.getString(Chat.LAST_MESSAGE_DATE_TIME));

            chatItemList.add(chatItem);
        }
        cursor.close();
        db.close();
        return chatItemList;
    }

    public void saveChat(ChatItem item) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        //cv.put();
        db.insert("chat", null, cv);
    }
}
