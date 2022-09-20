package com.example.pomensot;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pomensot.ui.main.Pomen;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.zip.Inflater;


public class CustomAdapter extends ArrayAdapter<Pomen> {
    Context context;
    private ArrayList<Pomen> dataSet;
    LayoutInflater inflter;
    public CustomAdapter(Context applicationContext, ArrayList<Pomen> P_list) {
        super(applicationContext, R.layout.pomen_listview, P_list);
        this.context = applicationContext;
        this.dataSet = P_list;
        inflter = (LayoutInflater.from(applicationContext));
    }
    @Override
    public int getCount() {
        return dataSet.size();
    }
    @Override
    public Pomen getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.pomen_listview, null);
        TextView pomen_name = (TextView) view.findViewById(R.id.pomenName);
        TextView pomen_describtion = (TextView) view.findViewById(R.id.PomenDescribtion);
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        pomen_name.setText(dataSet.get(i).getName());
        pomen_describtion.setText(dataSet.get(i).getDescription());
        icon.setImageResource(R.drawable.profile);
        return view;
    }
}
