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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GardeningFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GardeningFragment extends Fragment {

    public View view;
    ListView simpleList;
    String countryList[] = {"Elshaikh", "Nabil", "AbdulRahman", "Aisyah", "Ang", "NewZealand"};
    int flags[] = {R.drawable.user, R.drawable.profile, R.drawable.user, R.drawable.profile, R.drawable.user, R.drawable.profile};

    public GardeningFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment GardeningFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GardeningFragment newInstance() {
        GardeningFragment fragment = new GardeningFragment();
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
        view = inflater.inflate(R.layout.fragment_gardening, container, false);
        simpleList = view.findViewById(R.id.simpleListView);
        CustomAdapter customAdapter = new CustomAdapter(getContext().getApplicationContext(), MainPage.getPomen_list());
        simpleList.setAdapter(customAdapter);
        return view;//inflater.inflate(R.layout.fragment_electrical, container, false);
    }
}