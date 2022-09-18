package com.example.pomensot;

import android.annotation.SuppressLint;
import android.content.Context;
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

import com.example.pomensot.ui.main.CarServiceFragment;
import com.example.pomensot.ui.main.ConstructionFragment;
import com.example.pomensot.ui.main.ElectricalFragment;
import com.example.pomensot.ui.main.GardeningFragment;
import com.example.pomensot.ui.main.PipingFragment;
import com.example.pomensot.ui.main.PlaceholderFragment;

import java.util.concurrent.ConcurrentHashMap;

public class MainPage extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    protected FragmentContainerView current_fragment_view;
    String[] tabs = {"Electrical",
            "Piping",
            "Car Service",
            "Construction",
            "Gardening",};

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_v3);
        current_fragment_view = findViewById(R.id.fragmentContainer);
        openFragment(0);

        Spinner spin = findViewById(R.id.spinner1);
        spin.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);



        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,tabs);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);


    }
    //Performing action onItemSelected and onNothing selected

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(),tabs[0] , Toast.LENGTH_LONG).show();
        openFragment(i);
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    private void openFragment(int index) {
        FragmentManager fragmentManager =  getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
        Fragment current_fragment = getCurrentFragment(index);
        fragmentTransaction.replace(R.id.fragmentContainer, current_fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    public Fragment getCurrentFragment(int index)
    {
        Fragment current_f;
        switch (index){
            case 0: current_f = ElectricalFragment.newInstance(); break;
            case 1: current_f = GardeningFragment.newInstance(); break;
            case 2: current_f = ConstructionFragment.newInstance(); break;
            case 3: current_f = PipingFragment.newInstance(); break;
            case 4: current_f = CarServiceFragment.newInstance(); break;
            default: current_f = ElectricalFragment.newInstance();
        }
        return current_f;
    }
}
