package com.example.isabella.paapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.view.View;


public class ReviewScreen extends AppCompatActivity {

    CheckBox Activity_checkbox;
    CheckBox HR_checkbox;
    CheckBox GSR_checkbox;
    CheckBox RR_checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_screen);
        Activity_checkbox = (CheckBox)findViewById(R.id.checkBoxActivity);
        HR_checkbox = (CheckBox)findViewById(R.id.checkBoxHR);
        GSR_checkbox = (CheckBox)findViewById(R.id.checkBoxGSR);
        RR_checkbox = (CheckBox)findViewById(R.id.checkBoxRR);
    }

    public void onCheckboxClicked(View v)
    //this method is to pass the checkbox options
    // to display method which will display HR, GSR,
    // Activity, or RR depending on the user input
    {

        if(Activity_checkbox.isChecked())
        {
            // true,do the task

        }
        else
        {

        }

    }

}
