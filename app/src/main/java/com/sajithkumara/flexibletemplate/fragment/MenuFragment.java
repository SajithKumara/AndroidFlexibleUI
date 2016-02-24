package com.sajithkumara.flexibletemplate.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sajithkumara.flexibletemplate.R;

public class MenuFragment extends Fragment {

    private OnMenuItemSelectedListener mListener;
    CardView cardViewBMI, cardViewBMR;

    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
        return fragment;
    }

    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_menu, container, false);

        cardViewBMI = (CardView) v.findViewById(R.id.cardBMI);
        cardViewBMR = (CardView) v.findViewById(R.id.cardBMR);

        cardViewBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMenuItemSelected(1); // layoutId = 1 to identify BMI card view click
            }
        });
        cardViewBMR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMenuItemSelected(2); // layoutId = 2 to identify BMR card view click
            }
        });
        return v;
    }

    public void onMenuItemSelected(int layoutId) {
        if (mListener != null) {
            mListener.onMenuItemSelect(layoutId);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnMenuItemSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnMenuItemSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnMenuItemSelectedListener {
        public void onMenuItemSelect(int layoutId);
    }

}
