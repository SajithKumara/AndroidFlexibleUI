package com.sajithkumara.flexibletemplate.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sajithkumara.flexibletemplate.R;

public class BMRFragment extends Fragment {

    public BMRFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_bmr, container, false);

        //adding action bar and setting backward navigation
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (getActivity().getClass().getSimpleName().equals("BMRActivity")) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        actionBar.setTitle("BMR Calculator");

        return v;
    }
}
