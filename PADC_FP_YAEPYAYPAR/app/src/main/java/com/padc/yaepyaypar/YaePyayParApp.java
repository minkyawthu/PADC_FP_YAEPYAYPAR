package com.padc.yaepyaypar;

import android.app.Application;
import android.content.Context;

/**
 * Created by mkt on 9/4/2016.
 */
public class YaePyayParApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
