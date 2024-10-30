package com.example.fragments;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonFragment1 = findViewById(R.id.button_fragment1);
        Button buttonFragment2 = findViewById(R.id.button_fragment2);

        // Verifica la orientación del dispositivo
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if (findViewById(R.id.fragment_container_1) != null && findViewById(R.id.fragment_container_2) != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_1, new First_Fragment())
                        .replace(R.id.fragment_container_2, new Second_Fragment())
                        .commit();
            }
        } else {
            if (findViewById(R.id.fragment_container) != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new First_Fragment())
                        .commit();

                buttonFragment1.setOnClickListener(v -> replaceFragment(new First_Fragment()));
                buttonFragment2.setOnClickListener(v -> replaceFragment(new Second_Fragment()));
            }
        }
    }

    private void replaceFragment(Fragment fragment) {
        if (findViewById(R.id.fragment_container) != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}
