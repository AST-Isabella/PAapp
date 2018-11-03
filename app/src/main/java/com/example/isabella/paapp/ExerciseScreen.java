package com.example.isabella.paapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExerciseScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_screen);
        //This is the button from the exercise screen that goes to the StartExercise screen
        Button startExerciseBtn = findViewById(R.id.startExerciseBtn);
        startExerciseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),StartExerciseScreen.class);
                startActivity(startIntent);
            }
        });
        //This is the button from the exercise screen that goes to the ReviewExercise screen
        Button reviewExerciseBtn = findViewById(R.id.reviewExerciseBtn);
        reviewExerciseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),ReviewExerciseScreen.class);
                startActivity(startIntent);
            }
        });
        //This is the button from the exercise screen that goes to the ExerciseInstructions screen
        Button exerciseInstructionsBtn = findViewById(R.id.exerciseInstructionsBtn);
        exerciseInstructionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),ExerciseInstructionsScreen.class);
                startActivity(startIntent);
            }
        });

    }
}
