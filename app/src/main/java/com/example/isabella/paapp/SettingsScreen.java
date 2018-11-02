package com.example.isabella.paapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingsScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_screen);

        //This is the button from the settings screen that goes to the calibrate screen
        Button CalibrateScreenBtn = findViewById(R.id.CalibrateBtn);
        CalibrateScreenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), CalibrateScreen.class);
                startActivity(startIntent);
            }
        });
    }

}
