package com.sauravkumar71920gmail.atulyam;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.text.SpannableString;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.sauravkumar71920gmail.atulyam.adapter.TopicsAdapter;

import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity {


  public   TextInputLayout mNameTextInputLayout;
  public   TextInputEditText mNameEditText;

  public   TextInputLayout mRollTextInputLayout;
  public   TextInputEditText   mRollEditText;

    TextInputLayout mEmailTextInputLayout;
    TextInputEditText mEmailEditText;

    TextInputLayout mPasswordTextInputLayout;
    TextInputEditText mPasswordEditText;

    AppCompatButton mSignUpButton;

        FirebaseUser mFirebaseUser;
        FirebaseAuth mFirebaseAuth;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


          mFirebaseAuth = FirebaseAuth.getInstance();
          mFirebaseUser = mFirebaseAuth.getCurrentUser();


        mNameTextInputLayout = (TextInputLayout) findViewById(R.id.nameTextInput);
        mNameEditText = (TextInputEditText) findViewById(R.id.nameEditText);

        mRollTextInputLayout = (TextInputLayout) findViewById(R.id.rollTextInput);
        mRollEditText = (TextInputEditText) findViewById(R.id.rollEditText);

        mEmailTextInputLayout = (TextInputLayout) findViewById(R.id.emailTextInput);
        mEmailEditText = (TextInputEditText) findViewById(R.id.emailEditText);

        mPasswordTextInputLayout = (TextInputLayout) findViewById(R.id.passwordTextInput);
        mPasswordEditText = (TextInputEditText) findViewById(R.id.passwordEditText);

        mSignUpButton = (AppCompatButton)findViewById(R.id.signUpAppCompat);


        Typeface typeface = Typeface.createFromAsset(getAssets(), "Forte.ttf");
        mSignUpButton.setTypeface(typeface);



       mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String  Name = mNameEditText.getText().toString().trim();
                String Roll = mRollEditText.getText().toString().trim();
                String email = mEmailEditText.getText().toString().trim();
                String password = mPasswordEditText.getText().toString().trim();



              mFirebaseAuth.createUserWithEmailAndPassword(email, password).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SignUpActivity.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                }).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                        } else {
                            Toast.makeText(SignUpActivity.this, "Sign up failed!", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
               /* mSignUpButton.setEnabled(false);
                mSignUpButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));*/
            }
        });
    }



}













