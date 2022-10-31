package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.fragments.CommunicationHomeFragment;
import com.example.myapplication.fragments.MessagerieInterneFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init(){
        getSupportFragmentManager().beginTransaction()
                //.setReorderingAllowed(true)
                .add(R.id.fragment_container_message, CommunicationHomeFragment.newInstance())
                //.addToBackStack(null)
                .commit();
    }
}