package com.tictaeto.x_project.db;

/**
 * Created by Denis Ligin on 04.09.2015.
 */
public interface ColumnConstants {
    //Chat table
    interface Chat {
        int ID = 1;
        int CHAT_NAME = 2;
        int LAST_MESSAGE_DATE_TIME = 3;
        int IMAGE_ID = 4;

    }

    interface Message {
        int ID = 1;
        int CHAT_ID = 2;
        int CONTACT_ID = 3;
        int CONTENT = 4;
        int MESSAGE_DATE_TIME = 5;
    }

    interface Contact {
        int ID = 1;
        int NAME = 2;
    }
}
