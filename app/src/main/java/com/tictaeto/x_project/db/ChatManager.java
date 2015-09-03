package com.tictaeto.x_project.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.tictaeto.x_project.items.ChatItem;

import java.util.ArrayList;

/**
 * Created by DEN on 29.08.2015.
 */
public final class ChatManager {
    private static ChatManager instance = null;
    private DBHelper dbHelper;

    private ChatManager(Context context) {
        dbHelper = new DBHelper();
    }

    public static ChatManager get(Context context) {
        if (instance == null) {
            instance = new ChatManager(context);
        }
        return instance;
    }

    public ChatItem getChatBiID(int id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ChatItem chatItem = new ChatItem();
        Cursor cursor = db.rawQuery("select * from chat where id=?", new String[]{String.valueOf(id)});
        int idColumn = cursor.getColumnIndex("id");
        int nameColumn = cursor.getColumnIndex("name");

        chatItem.setChatID(Integer.parseInt(cursor.getString(idColumn)));
        chatItem.setName(cursor.getString(nameColumn));

        return chatItem;
    }

    public ArrayList<ChatItem> getChatList() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ArrayList<ChatItem> chatItemList = new ArrayList<ChatItem>();
        Cursor cursor = db.rawQuery("select * from chat order by last_message_datetime", null);
        int idColumn = cursor.getColumnIndex("id");
        int nameColumn = cursor.getColumnIndex("name");
        int dateTimeColumn = cursor.getColumnIndex("last_message_datetime");
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ChatItem chatItem = new ChatItem();
            chatItem.setChatID(cursor.getInt(idColumn));
            chatItem.setName(cursor.getString(nameColumn));
            chatItem.setDateTime(cursor.getString(dateTimeColumn));

            chatItemList.add(chatItem);
        }
        return chatItemList;
    }
}
