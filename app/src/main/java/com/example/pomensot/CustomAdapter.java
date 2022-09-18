package com.example.pomensot;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;


public class CustomAdapter extends BaseAdapter {
    Context context;
    String pomen_List[];
    int flags[];
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, String[] pomen_List_, int[] flags) {
        this.context = context;
        this.pomen_List = pomen_List_;
        this.flags = flags;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return pomen_List.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.pomen_listview, null);
        TextView country = (TextView) view.findViewById(R.id.textView);
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        country.setText(pomen_List[i]);
        icon.setImageResource(flags[i]);
        return view;
    }
}
