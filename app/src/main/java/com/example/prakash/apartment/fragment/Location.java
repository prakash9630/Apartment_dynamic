package com.example.prakash.apartment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.prakash.apartment.R;

/**
 * Created by prakash on 3/30/2017.
 */

public class Location extends Fragment {
    View mainView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mainView=inflater.inflate(R.layout.location_layout,container,false);






        return mainView;
    }
}
