package com.tictaeto.x_project.utils;

import android.app.Application;
import android.content.Context;

/**
 * Created by Denis Ligin on 03.09.2015.
 */
public class ApplicationManager extends Application {
    private static ApplicationManager instance = null;

    private ApplicationManager() {
    }

    public static ApplicationManager get() {
        if (instance == null) {
            instance = new ApplicationManager();
        }
        return instance;
    }

    public static Context getContext() {
        return get().getBaseContext();
    }
}
