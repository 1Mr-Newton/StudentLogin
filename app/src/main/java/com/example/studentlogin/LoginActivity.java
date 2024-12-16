package com.example.studentlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextLoginEmail, editTextLoginPassword;
    private Button buttonLogin;
    private String registeredEmail, registeredPassword;
    private String name, age, programme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        editTextLoginEmail = findViewById(R.id.editTextLoginEmail);
        editTextLoginPassword = findViewById(R.id.editTextLoginPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        // Get registration data from intent
        Intent intent = getIntent();
        if (intent != null) {
            registeredEmail = intent.getStringExtra("email");
            registeredPassword = intent.getStringExtra("password");
            name = intent.getStringExtra("name");
            age = intent.getStringExtra("age");
            programme = intent.getStringExtra("programme");

            // Pre-fill email if coming from registration
            if (registeredEmail != null) {
                editTextLoginEmail.setText(registeredEmail);
            }
        }

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextLoginEmail.getText().toString().trim();
                String password = editTextLoginPassword.getText().toString().trim();

                if (validateLogin(email, password)) {
                    // Pass data to LandingActivity
                    Intent landingIntent = new Intent(LoginActivity.this, LandingActivity.class);
                    landingIntent.putExtra("name", name);
                    landingIntent.putExtra("age", age);
                    landingIntent.putExtra("programme", programme);
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

        if (email.equals(registeredEmail) && password.equals(registeredPassword)) {
            return true;
        } else {
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
} 