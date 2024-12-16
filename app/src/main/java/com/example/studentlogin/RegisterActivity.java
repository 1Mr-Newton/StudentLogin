package com.example.studentlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private EditText inputStudentName, inputStudentAge, inputStudentEmail, inputStudentProgramme, inputStudentPassword;
    private Button btnRegisterStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize views
        inputStudentName = findViewById(R.id.editTextName);
        inputStudentAge = findViewById(R.id.editTextAge);
        inputStudentEmail = findViewById(R.id.editTextEmail);
        inputStudentProgramme = findViewById(R.id.editTextProgramme);
        inputStudentPassword = findViewById(R.id.editTextPassword);
        btnRegisterStudent = findViewById(R.id.buttonRegister);

        btnRegisterStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()) {
                    // Create intent to pass data to LoginActivity
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    intent.putExtra("email", inputStudentEmail.getText().toString().trim());
                    intent.putExtra("password", inputStudentPassword.getText().toString().trim());
                    intent.putExtra("name", inputStudentName.getText().toString().trim());
                    intent.putExtra("age", inputStudentAge.getText().toString().trim());
                    intent.putExtra("programme", inputStudentProgramme.getText().toString().trim());
                    
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private boolean validateInput() {
        if (inputStudentName.getText().toString().trim().isEmpty() ||
            inputStudentAge.getText().toString().trim().isEmpty() ||
            inputStudentEmail.getText().toString().trim().isEmpty() ||
            inputStudentProgramme.getText().toString().trim().isEmpty() ||
            inputStudentPassword.getText().toString().trim().isEmpty()) {
            
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
} 