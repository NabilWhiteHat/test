package com.example.pomensot;

import android.os.AsyncTask;
import android.util.Log;

import com.example.pomensot.ui.main.ServiceHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpGetRequest extends AsyncTask<String, Void, String> {
    public static final String REQUEST_METHOD = "GET";
    public static final int READ_TIMEOUT = 15000;
    public static final int CONNECTION_TIMEOUT = 15000;
    public String stringUrl;//= params[0];
    public String Result_String = "HHHHHHHHH";
    URL GetUrl = null;

//    public HttpGetRequest(String url_) {
//        stringUrl = url_;
//    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected String doInBackground(String... strings) {

        try {
            GetUrl = new URL(stringUrl);
            HttpURLConnection conn = (HttpURLConnection) GetUrl.openConnection();
            // setting the  Request Method Type
            conn.setRequestMethod("GET");
            // adding the headers for request
            conn.setRequestProperty("Content-Type", "application/json");
            try{
                //to tell the connection object that we will be wrting some data on the server and then will fetch the output result
                conn.setDoOutput(true);
                // this is used for just in case we don't know about the data size associated with our request
                conn.setChunkedStreamingMode(0);

                // to write tha data in our request
                OutputStream outputStream = new BufferedOutputStream(conn.getOutputStream());
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                outputStreamWriter.write("AA");
                outputStreamWriter.flush();
                outputStreamWriter.close();

                // to read the response data from our request
                InputStream inputStream;
                if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    inputStream = new BufferedInputStream(conn.getInputStream());
                }else {
                    inputStream = new BufferedInputStream(conn.getErrorStream());
                }

                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    sb.append(line +"\n");
                }
                inputStream.close();
                Result_String = sb.toString();

                // to log the response code of your request
                System.out.println("MyHttpRequestTask doInBackground : " +conn.getResponseCode());
                 // to log the response message from your server after you have tried the request.
                System.out.println("MyHttpRequestTask doInBackground : " +conn.getResponseMessage());
                System.out.println("MyHttpRequestTask Result : " +Result_String);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    // this is done so that there are no open connections left when this task is going to complete
                conn.disconnect();
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result_String;
    }
}
