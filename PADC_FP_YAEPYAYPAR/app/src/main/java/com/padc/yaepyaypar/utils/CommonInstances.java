package com.padc.yaepyaypar.Utils;

import com.google.gson.Gson;

/**
 * Created by mkt on 9/17/2016.
 */
public class CommonInstances {
    private static Gson gson = new Gson();

    public static Gson getGsonInstance() {
        return gson;
    }
}
