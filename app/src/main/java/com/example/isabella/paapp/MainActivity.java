package com.example.isabella.paapp;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        while(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]
                    {Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        }

        //This is the button from the main screen that goes to the Start screen
        Button StartScreenBtn = findViewById(R.id.StartBtn);
        StartScreenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),StartScreen.class);
                startActivity(startIntent);
            }
        });
        //This is the button from the main screen that goes to the Review screen
        Button ReviewScreenBtn = findViewById(R.id.ReviewBtn);
        ReviewScreenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), ReviewScreen.class);
                startActivity(startIntent);
            }
        });
        //This is the button from the main screen that goes to the Resources screen
        Button ResourcesScreenBtn = findViewById(R.id.ResourcesBtn);
        ResourcesScreenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), ResourcesScreen.class);
                startActivity(startIntent);
            }
        });
        //This is the button from the main screen that goes to the Settings screen
        Button SettingsScreenBtn = findViewById(R.id.SettingsBtn);
        SettingsScreenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SettingsScreen.class);
                startActivity(startIntent);
            }
        });
        //This is the button from the main screen that goes to the Exercises screen
        Button ExerciseScreenBtn = findViewById(R.id.ExerciseBtn);
        ExerciseScreenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), ExerciseScreen.class);
                startActivity(startIntent);
            }
        });
    }
}