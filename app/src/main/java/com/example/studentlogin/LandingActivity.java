package com.example.studentlogin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LandingActivity extends AppCompatActivity {
    private TextView textViewFullName, textViewAge, textViewProgramme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        // Initialize views
        textViewFullName = findViewById(R.id.textViewFullName);
        textViewAge = findViewById(R.id.textViewAge);
        textViewProgramme = findViewById(R.id.textViewProgramme);

        // Get data from intent
        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("name");
            String age = intent.getStringExtra("age");
            String programme = intent.getStringExtra("programme");

            // Display the information
            textViewFullName.setText("Full Name: " + name);
            textViewAge.setText("Age: " + age);
            textViewProgramme.setText("Programme: " + programme);
        }
    }
} 