package com.tictaeto.x_project.db;

/**
 * Created by DEN on 29.08.2015.
 */
public final class ContactManager {
    private static ContactManager instance = null;

    private ContactManager() {
    }

    public  static ContactManager getInstance(){
        if(instance==null){
            instance = new ContactManager();
        }
        return instance;
    }
}

