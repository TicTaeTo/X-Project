package com.tictaeto.x_project.db;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.tictaeto.x_project.utils.ApplicationManager;

/**
 * Created by Denis Ligin on 30.08.2015.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static DBHelper instance = null;

    private DBHelper() {
        super(ApplicationManager.get().getApplicationContext(), "db", null, 1);
    }

    public static DBHelper get() {
        if (instance == null) {
            instance = new DBHelper();
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table chat(id integer primary key autoincrement," +
                "name text," +
                "last_message_datetime datetime, " +
                "image_id integer)");

        db.execSQL("create table message(id integer primary key autoincrement, " +
                "chat_id integer, " +
                "contact_id integer, " +
                "content text)" +
                "message_date_time datetime");

        db.execSQL("create table contact(id integer primary key autoincrement, " +
                "name text, )");

        db.execSQL("create table chat_contact(chat_id integer, " +
                "contact_id integer)");

        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
