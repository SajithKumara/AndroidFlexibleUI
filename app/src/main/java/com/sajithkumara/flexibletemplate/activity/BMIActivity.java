package com.sajithkumara.flexibletemplate.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.sajithkumara.flexibletemplate.R;

public class BMIActivity extends AppCompatActivity {
    // Put all the java controlling code in BMIFragment. No need to code here.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        this.finish(); // end this activity and go back
        return super.onOptionsItemSelected(item);
    }
}
