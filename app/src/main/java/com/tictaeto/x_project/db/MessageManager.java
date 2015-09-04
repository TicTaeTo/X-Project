package com.tictaeto.x_project.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.tictaeto.x_project.items.MessageItem;

/**
 * Created by Denis Ligin on 04.09.2015.
 */
public final class MessageManager implements ColumnConstants {
    private static MessageManager instance = null;
    private DBHelper dbHelper;

    private MessageManager() {
        dbHelper = DBHelper.get();
    }

    public static MessageManager get() {
        if (instance == null) {
            instance = new MessageManager();
        }
        return instance;
    }

    public MessageItem getMessageById(int id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        MessageItem messageItem = new MessageItem();
        Cursor cursor = db.rawQuery("select * from message where id = " + String.valueOf(id), null);

        messageItem.setMessageID(id);
        messageItem.setChatID(cursor.getInt(Message.CHAT_ID));
        messageItem.setContactID(cursor.getInt(Message.CONTACT_ID));
        messageItem.setContent(cursor.getString(Message.CONTENT));
        messageItem.setDateTime(cursor.getString(Message.MESSAGE_DATE_TIME));

        cursor.close();
        db.close();

        return messageItem;
    }
}
