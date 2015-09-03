package com.tictaeto.x_project.utils;

import android.app.Application;

/**
 * Created by DEN on 03.09.2015.
 */
public class ApplicationManager extends Application {
    private static ApplicationManager instance;

    private ApplicationManager() {
    }

    public static ApplicationManager get() {
        if (instance == null) {
            instance = new ApplicationManager();
        }
        return instance;
    }
}
