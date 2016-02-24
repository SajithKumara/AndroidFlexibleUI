package com.sajithkumara.flexibletemplate.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.sajithkumara.flexibletemplate.R;

public class BMIFragment extends Fragment {
    Button btnToast;

    public BMIFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_bmi, container, false);

        //adding action bar and setting backward navigation
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (getActivity().getClass().getSimpleName().equals("BMIActivity")) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        actionBar.setTitle("BMI Calculator");

        btnToast = (Button)v.findViewById(R.id.btnToast);
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"You clicked toast message button!!!",Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }

}
