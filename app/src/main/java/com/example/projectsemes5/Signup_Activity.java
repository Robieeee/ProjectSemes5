package com.example.projectsemes5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup_Activity extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText signupEmail, signupFullName, signupPass;
    private Button signupButton;
    private TextView signinRedirect;
    boolean passwordVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        auth = FirebaseAuth.getInstance();
        signupEmail = findViewById(R.id.signupemail);
        signupFullName = findViewById(R.id.signupfullname);
        signupPass = findViewById(R.id.signuppass);
        signupButton = findViewById(R.id.signupbutton);
        signinRedirect = findViewById(R.id.signinredirect);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = signupEmail.getText().toString().trim();
                String name = signupFullName.getText().toString().trim();
                String pass = signupPass.getText().toString().trim();

                if (user.isEmpty()){
                    signupEmail.setError("Email cannot be empty");
                }
                if (name.isEmpty()){
                    signupFullName.setError("Full name cannot be empty");
                }
                if (pass.isEmpty()){
                    signupPass.setError("Password cannot be empty");
                } else {
                    auth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(Signup_Activity.this,"SignUp Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Signup_Activity.this, Signin_Activity.class).putExtra("userName", name));
                            } else {
                                Toast.makeText(Signup_Activity.this, "SignUp Failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        signinRedirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Signup_Activity.this, Signin_Activity.class));
            }
        });

        signupPass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right = 2;
                if (event.getAction() == MotionEvent.ACTION_UP){
                    if (event.getRawX() >= signupPass.getRight() - signupPass.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=signupPass.getSelectionEnd();
                        if (passwordVisible){
                            signupPass.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.password_ic, 0);
                            signupPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible = false;
                        }else {
                            signupPass.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.passoff_ic, 0);
                            signupPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible = true;
                        }
                        signupPass.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

    }
}