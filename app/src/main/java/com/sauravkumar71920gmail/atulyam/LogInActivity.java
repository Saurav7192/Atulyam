package com.sauravkumar71920gmail.atulyam;

        import android.content.Intent;
        import android.graphics.Typeface;
        import android.support.annotation.NonNull;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.AppCompatAutoCompleteTextView;
        import android.support.v7.widget.AppCompatButton;
        import android.view.View;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.OnFailureListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;

public class LogInActivity extends AppCompatActivity {

    AppCompatAutoCompleteTextView mloginEmail;
    AppCompatAutoCompleteTextView mloginPassword;

    AppCompatButton mloginButton;

    TextView mNotAmemberView;


    FirebaseUser mFirebaseUser;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();


        mloginEmail = (AppCompatAutoCompleteTextView) findViewById(R.id.loginEmail);
        mloginPassword = (AppCompatAutoCompleteTextView) findViewById(R.id.loginPassword);

        mloginButton = (AppCompatButton) findViewById(R.id.loginAppButton);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "Forte.ttf");
        mloginButton.setTypeface(typeface);

        mNotAmemberView = (TextView) findViewById(R.id.textView2);

        mloginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = mloginEmail.getText().toString().trim();
                String password = mloginPassword.getText().toString().trim();

                mFirebaseAuth.signInWithEmailAndPassword(email,password).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(LogInActivity.this,e.getMessage().toString(),Toast.LENGTH_SHORT).show();

                    }
                }).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(LogInActivity.this,MainActivity.class));
                        }
                        else{
                            Toast.makeText(LogInActivity.this,"Login failed",Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });

        mNotAmemberView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LogInActivity.this,SignUpActivity.class));
            }
        });



    }

    public void onBackPressed() {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
