package com.example.pomensot.ui.main;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pomensot.CustomAdapter;
import com.example.pomensot.HttpGetRequest;
import com.example.pomensot.Links;
import com.example.pomensot.MainPage;
import com.example.pomensot.R;

import org.json.JSONArray;
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
import java.net.URL;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ElectricalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ElectricalFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public View view;
    public getElectricians requst;
    ListView simpleList;
    ArrayList<Pomen> pomen_list = new ArrayList<Pomen>();
    //MyAdapter myAdapter;
    //RecyclerView recyclerView;
    //String countryList[] = {"Elshaikh", "Nabil", "AbdulRahman", "Aisyah", "Ang", "NewZealand"};
    //int flags[] = {R.drawable.user, R.drawable.profile, R.drawable.user, R.drawable.profile, R.drawable.user, R.drawable.profile};

    public ElectricalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ElectricalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ElectricalFragment newInstance() {
        ElectricalFragment fragment = new ElectricalFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_electrical, container, false);
        simpleList = view.findViewById(R.id.simpleListView);
        //recyclerView= view.findViewById( R.id.rv );
        TextView rr = view.findViewById(R.id.respon);
        Bundle bundle = getArguments();
        String message = bundle.getString("message");
        requst = new getElectricians();

        requst.execute();
        rr.setText(message);
        //Request Electric Pomen list from server

        return view;//inflater.inflate(R.layout.fragment_electrical, container, false);
    }
    public class getElectricians extends AsyncTask<String, Void, String> {
        public static final String REQUEST_METHOD = "GET";
        public static final int READ_TIMEOUT = 15000;
        public static final int CONNECTION_TIMEOUT = 15000;
        public String stringUrl;//= params[0];
        public String Result_String = "HHHHHHHHH";
        URL GetUrl = null;
        @Override
        protected void onPreExecute() {
            stringUrl = Links.url_getElectrician;//= params[0];
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
        @Override
        protected void onPostExecute(String s) {
            System.out.println("MyHttpRequestTask Result :[[" +Result_String+"]]");
            pomen_list = getPomenFromJSON(Result_String);
            CustomAdapter customAdapter = new CustomAdapter(getContext().getApplicationContext(),pomen_list);
            simpleList.setAdapter(customAdapter);
        }
        public ArrayList<Pomen> getPomenFromJSON(String JSON_STRING){
            ArrayList<Pomen> p_list = new ArrayList<Pomen>();
            try{
                JSONObject  jsonRootObject = new JSONObject(JSON_STRING);
                //Get the instance of JSONArray that contains JSONObjects
                JSONArray p_a = jsonRootObject.optJSONArray("data");
                //JSONObject emp=(new JSONObject(JSON_STRING)).getJSONObject(JSON_STRING);
                //JSONArray p_a = emp.getJSONArray("data");
                for(int i=0;i<p_a.length();i++)
                {
                    JSONObject aj = p_a.getJSONObject(i);
                    Pomen a = new Pomen(aj.getString("name"),
                            aj.getString("email"),
                            aj.getString("image"),
                            aj.getString("location"),
                            aj.getString("address"));
                    System.out.println("MMMMMMM JSON Res["+i+"] = "+a.name);
                    p_list.add(a);
                }
                return p_list;
            }catch (Exception e) {e.printStackTrace();}
            return null;
        }
    }
}