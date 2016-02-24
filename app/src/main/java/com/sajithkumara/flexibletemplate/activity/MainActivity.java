package com.sajithkumara.flexibletemplate.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.sajithkumara.flexibletemplate.R;
import com.sajithkumara.flexibletemplate.fragment.BMIFragment;
import com.sajithkumara.flexibletemplate.fragment.BMRFragment;
import com.sajithkumara.flexibletemplate.fragment.MenuFragment;

// this is the first view which includes MenuFragment
public class MainActivity extends AppCompatActivity implements MenuFragment.OnMenuItemSelectedListener {
    FrameLayout frameContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // there are 2 activity_main.xml files.
                                                // 1 for phones(in layout), a for tablets (in layout-sw600dp)

        frameContainer = (FrameLayout) findViewById(R.id.frame_container);
        if (frameContainer == null) {
            // If we have a phone activity_main.xml in layout folder loads.Do nothing here.
        } else {
            // If we have a tablet activity_main.xml in layout-sw600dp folder loads.
            // load the BMIFragment in the frame_container
            BMIFragment sef = new BMIFragment();
            changeFragment(sef);  // replace the fragments
        }
    }

    @Override
    public void onMenuItemSelect(int layoutId) {  // Listener interface in MenuFragment
        Intent intent = null;
        if (frameContainer == null) {  // If we have a phone.......
            switch (layoutId) { // layoutId pass from MenuFragment
                case 1: // if layoutId = 1, load BMIActivity(not BMIFragment)
                    intent = new Intent(this, BMIActivity.class);
                    intent.putExtra("layoutId", layoutId);
                    startActivity(intent);
                    return;
                case 2:// if layoutId = 2, load BMRActivity(not BMRFragment)
                    intent = new Intent(this, BMRActivity.class);
                    startActivity(intent);
                    return;
            }
        } else {   // If we have a tablet.......
            switch (layoutId) {
                case 1: //load BMIFragment
                    BMIFragment sef = new BMIFragment();
                    changeFragment(sef);
                    return;
                case 2: //load BMRFragment
                    BMRFragment bmiFragment = new BMRFragment();
                    changeFragment(bmiFragment);
                    return;
            }
        }
    }

    private void changeFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = null;
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fragment);
        fragmentTransaction.commit();
    }

}
