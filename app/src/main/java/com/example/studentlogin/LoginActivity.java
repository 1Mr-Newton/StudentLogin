package com.example.studentlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText inputLoginEmail, inputLoginPassword;
    private Button btnStudentLogin;
    private String storedEmail, storedPassword;
    private String studentName, studentAge, studentProgramme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        inputLoginEmail = findViewById(R.id.editTextLoginEmail);
        inputLoginPassword = findViewById(R.id.editTextLoginPassword);
        btnStudentLogin = findViewById(R.id.buttonLogin);

        // Get registration data from intent
        Intent intent = getIntent();
        if (intent != null) {
            storedEmail = intent.getStringExtra("email");
            storedPassword = intent.getStringExtra("password");
            studentName = intent.getStringExtra("name");
            studentAge = intent.getStringExtra("age");
            studentProgramme = intent.getStringExtra("programme");

            // Pre-fill email if coming from registration
            if (storedEmail != null) {
                inputLoginEmail.setText(storedEmail);
            }
        }

        btnStudentLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputLoginEmail.getText().toString().trim();
                String password = inputLoginPassword.getText().toString().trim();

                if (validateLogin(email, password)) {
                    // Pass data to LandingActivity
                    Intent landingIntent = new Intent(LoginActivity.this, LandingActivity.class);
                    landingIntent.putExtra("name", studentName);
                    landingIntent.putExtra("age", studentAge);
                    landingIntent.putExtra("programme", studentProgramme);
                    startActivity(landingIntent);
                    finish();
                }
            }
        });
    }

    private boolean validateLogin(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (email.equals(storedEmail) && password.equals(storedPassword)) {
            return true;
        } else {
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
} 