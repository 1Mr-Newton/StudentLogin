package com.example.studentlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private EditText editTextName, editTextAge, editTextEmail, editTextProgramme, editTextPassword;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize views
        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextProgramme = findViewById(R.id.editTextProgramme);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonRegister = findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()) {
                    // Create intent to pass data to LoginActivity
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    intent.putExtra("email", editTextEmail.getText().toString().trim());
                    intent.putExtra("password", editTextPassword.getText().toString().trim());
                    intent.putExtra("name", editTextName.getText().toString().trim());
                    intent.putExtra("age", editTextAge.getText().toString().trim());
                    intent.putExtra("programme", editTextProgramme.getText().toString().trim());
                    
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private boolean validateInput() {
        if (editTextName.getText().toString().trim().isEmpty() ||
            editTextAge.getText().toString().trim().isEmpty() ||
            editTextEmail.getText().toString().trim().isEmpty() ||
            editTextProgramme.getText().toString().trim().isEmpty() ||
            editTextPassword.getText().toString().trim().isEmpty()) {
            
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
} 