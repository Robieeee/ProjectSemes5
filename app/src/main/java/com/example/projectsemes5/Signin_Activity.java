package com.example.projectsemes5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signin_Activity extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText signinEmail, signinPass;
    private TextView signupRedirect;
    private Button signinButton;
    boolean passwordVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        auth = FirebaseAuth.getInstance();
        signinEmail = findViewById(R.id.signinemail);
        signinPass = findViewById(R.id.signinpass);
        signupRedirect = findViewById(R.id.signupredirect);
        signinButton = findViewById(R.id.signinbutton);

        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = signinEmail.getText().toString();
                String pass = signinPass.getText().toString();

                if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    if (!pass.isEmpty()) {
                        auth.signInWithEmailAndPassword(email, pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(Signin_Activity.this, "Signin Successful", Toast.LENGTH_SHORT).show();
                                String name = getIntent().getStringExtra("userName");
                                startActivity(new Intent(Signin_Activity.this, HomeActivity.class).putExtra("userName", name));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Signin_Activity.this, "Signin Failed", Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else {
                        signinPass.setError("Password cannot be empty");
                    }
                } else if (email.isEmpty()) {
                    signinEmail.setError("Email cannot be empty");
                } else {
                    signinEmail.setError("Please enter valid email");
                }
            }
        });

        signupRedirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Signin_Activity.this, Signup_Activity.class));
            }
        });

        signinPass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right = 2;
                if (event.getAction() == MotionEvent.ACTION_UP){
                    if (event.getRawX() >= signinPass.getRight() - signinPass.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=signinPass.getSelectionEnd();
                        if (passwordVisible){
                            signinPass.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.password_ic, 0);
                            signinPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible = false;
                        }else {
                            signinPass.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.passoff_ic, 0);
                            signinPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible = true;
                        }
                        signinPass.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

    }
}