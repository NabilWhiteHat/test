package com.example.pomensot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.pomensot.R.id;
import com.example.pomensot.databinding.ActivityMainBinding;
import com.example.pomensot.ui.main.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class Layout1 extends AppCompatActivity {

    String [] items = {"About", "Electrical", "Piping", "Car Service", "Construction" , "Gardening"};


    ImageButton ImageButton;

    AutoCompleteTextView autoCompleteTxt;

    ArrayAdapter<String> adapterItems;




    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout1);

        //variable declaration

        ImageButton = findViewById(R.id.imgbtn);


        // intent page
        ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Layout1.this, WebsiteView.class);
                startActivity(intent);

            }
        });




        // part for dropdown item
        autoCompleteTxt = findViewById(id.auto_complete_txt);

        adapterItems = new ArrayAdapter<String>(this,R.layout.pomen_listview,items);

        autoCompleteTxt.setAdapter(adapterItems);

        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"item: "+ item, Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void onBackPressed() {

        Toast.makeText(this, "This will interfere with exciting from the app", Toast.LENGTH_SHORT).show();
    }
}