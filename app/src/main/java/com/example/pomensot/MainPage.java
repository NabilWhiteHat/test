package com.example.pomensot;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.pomensot.ui.main.Pomen;
import com.example.pomensot.ui.main.WelcomeFragment;
import com.example.pomensot.ui.main.aboutFragment;
import com.example.pomensot.ui.main.CarServiceFragment;
import com.example.pomensot.ui.main.ConstructionFragment;
import com.example.pomensot.ui.main.ElectricalFragment;
import com.example.pomensot.ui.main.GardeningFragment;
import com.example.pomensot.ui.main.PipingFragment;

import java.util.ArrayList;

public class MainPage extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    String url = "http://pomen.atwebpages.com/api/getPomens.php?app_id=1";
    public HttpGetRequest http_requester;
    public String json_return;
    String myurl = "http://pomen.atwebpages.com/api/getPomens.php?app_id=1";
    public FragmentContainerView current_fragment_view;
    String[] tabs = {"Home","Electrical",
            "Piping",
            "Car Service",
            "Construction",
            "Gardening",};

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_v3);
        http_requester = new HttpGetRequest();
        http_requester.execute(myurl);
        json_return = http_requester.Result_String;
        //Run the first fragment
        current_fragment_view = findViewById(R.id.fragmentContainer);
        openFragment(110);
        //Display the drop down list
        Spinner spin = findViewById(R.id.spinner1);
        spin.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        //Change in dropdown list selection
            //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,tabs);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);


        //rr.setText(http_requester.Result_String);


    }
    //Performing action onItemSelected and onNothing selected

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        openFragment(i);
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        openFragment(110);
    }

    private void openFragment(int index) {
        Bundle b = new Bundle();
        b.putString("message", json_return);

        //fragmentTransaction.add(R.id.frameLayout, myFragment).commit();

        FragmentManager fragmentManager =  getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
        Fragment current_fragment = getCurrentFragment(index);
        current_fragment.setArguments(b);
        fragmentTransaction.replace(R.id.fragmentContainer, current_fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    public Fragment getCurrentFragment(int index)
    {
        Fragment current_f;
        switch (index){
            case 0: current_f = WelcomeFragment.newInstance(); break;
            case 1: current_f = ElectricalFragment.newInstance(); break;
            case 2: current_f = GardeningFragment.newInstance(); break;
            case 3: current_f = ConstructionFragment.newInstance(); break;
            case 4: current_f = PipingFragment.newInstance(); break;
            case 5: current_f = CarServiceFragment.newInstance(); break;
            default: current_f = WelcomeFragment.newInstance();
        }
        return current_f;
    }
    public static final ArrayList<Pomen> getPomen_list()
    {
        ArrayList<Pomen> dataSet = new ArrayList<Pomen>();
        Pomen aa = new Pomen("Mohamed","Computer Engineer");
        dataSet.add(aa);

        Pomen bb = new Pomen("Abdul","Computer Security Engineer");
        dataSet.add(bb);

        Pomen cc = new Pomen("Aisyah","Computer FrontEnd Designer");
        dataSet.add(cc);

        Pomen dd = new Pomen("Ang","Computer Hardware Engineer");
        dataSet.add(dd);

        Pomen ee = new Pomen("Nabil","Computer Backend Developer");
        dataSet.add(ee);

        Pomen xx = new Pomen("Nabil","Computer Backend Developer");
        dataSet.add(xx);

        Pomen ees = new Pomen("Nabil","Computer Backend Developer");
        dataSet.add(ees);

        Pomen ww = new Pomen("Nabil","Computer Backend Developer");
        dataSet.add(ww);

        Pomen ff = new Pomen("AAAA Nabil","Computer Backend Developer");
        dataSet.add(ff);
        return dataSet;
    }
}
