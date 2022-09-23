package com.example.pomensot.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pomensot.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.zip.Inflater;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<Pomen>modelArrayList;
    private Context context;
    //generate constructor

    public MyAdapter(ArrayList<Pomen> modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.singleview,parent,false );
        return new ViewHolder (view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        //set data
        Pomen model=modelArrayList.get ( position );
        Picasso.with ( context ).load ( model.getImage() )
                .error ( R.mipmap.ic_launcher )
                .into ( holder.imageView );
        //for text
        holder.textView.setText ( model.getName () );

    }

    @Override
    public int getItemCount() {
        return modelArrayList.size ();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super ( itemView );
            imageView=(ImageView)itemView.findViewById ( R.id.imageview );
            textView=(TextView)itemView.findViewById ( R.id.textview );
        }
    }
}