package com.example.pomensot.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.pomensot.CustomAdapter;
import com.example.pomensot.MainPage;
import com.example.pomensot.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CarServiceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CarServiceFragment extends Fragment {

    public View view;
    ListView simpleList;
    private ArrayList<Pomen> Pomen_list;
    //String countryList[] = {"Elshaikh", "Nabil", "AbdulRahman", "Aisyah", "Ang", "NewZealand"};
    int flags[] = {R.drawable.user, R.drawable.profile, R.drawable.user, R.drawable.profile, R.drawable.user, R.drawable.profile};

    public CarServiceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CarServiceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CarServiceFragment newInstance() {
        CarServiceFragment fragment = new CarServiceFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_car_service, container, false);
        simpleList = view.findViewById(R.id.simpleListView);
        CustomAdapter customAdapter = new CustomAdapter(getContext().getApplicationContext(), MainPage.getPomen_list());
        simpleList.setAdapter(customAdapter);
        return view;//inflater.inflate(R.layout.fragment_electrical, container, false);
    }

}