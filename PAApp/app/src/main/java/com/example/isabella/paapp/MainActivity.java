package com.example.isabella.paapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //BluetoothAdapter mBluetoothAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mBluetoothAdapter=BluetoothAdapter.getDefaultAdapter();

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
        //This is the button from the main screen that goes to the Info screen
        Button InfoScreenBtn = findViewById(R.id.InfoBtn);
        InfoScreenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), InfoScreen.class);
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

    }
}
