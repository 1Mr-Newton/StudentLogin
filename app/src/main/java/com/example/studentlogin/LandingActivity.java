package com.example.studentlogin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LandingActivity extends AppCompatActivity {
    private TextView displayStudentName, displayStudentAge, displayStudentProgramme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        // Initialize views
        displayStudentName = findViewById(R.id.textViewFullName);
        displayStudentAge = findViewById(R.id.textViewAge);
        displayStudentProgramme = findViewById(R.id.textViewProgramme);

        // Get data from intent
        Intent intent = getIntent();
        if (intent != null) {
            String studentName = intent.getStringExtra("name");
            String studentAge = intent.getStringExtra("age");
            String studentProgramme = intent.getStringExtra("programme");

            // Display the information
            displayStudentName.setText("Full Name: " + studentName);
            displayStudentAge.setText("Age: " + studentAge);
            displayStudentProgramme.setText("Programme: " + studentProgramme);
        }
    }
} 