package com.example.pomensot.ui.main;

import android.os.AsyncTask;

import java.io.IOException;

public class MyHttpRequest {
    public static final String REQUEST_METHOD = "GET";
    public static final int READ_TIMEOUT = 15000;
    public static final int CONNECTION_TIMEOUT = 15000;
    public String url0;
    public String result;
    public MyHttpRequest(String uu){
        this.url0 = uu;
    }
    protected void onPostExecute(Boolean result) {

    }
}