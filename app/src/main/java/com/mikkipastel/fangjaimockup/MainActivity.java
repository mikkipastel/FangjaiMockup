package com.mikkipastel.fangjaimockup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mikkipastel.fangjaimockup.Fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            //1st created
            //place fragment
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.contentContainer, MainFragment.newInstance())
                    .commit();
        }
    }
}
