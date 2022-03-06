package com.example.travelguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import android.widget.EditText;
import android.widget.ProgressBar;

import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity {
    private EditText inputEmail, inputPassword;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        inputEmail = findViewById(R.id.email);
        inputPassword = findViewById(R.id.password);
        progressBar = findViewById(R.id.progressBar);

    }

    public void signup(View view) {
        String email = inputEmail.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.length() < 6) {
            Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),"Registration is successful",Toast.LENGTH_SHORT).show();
                        } else {
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                Toast.makeText(getApplicationContext(), "User is already registered", Toast.LENGTH_SHORT).show();
                            }

                            else {
                                Toast.makeText(getApplicationContext(), "Error : "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                            }

                        } // ...
                    }
                });


    }

    public void login(View view) {
        finish();
    }



}
