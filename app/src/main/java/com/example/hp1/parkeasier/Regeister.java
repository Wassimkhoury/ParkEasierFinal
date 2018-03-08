package com.example.hp1.parkeasier;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Regeister extends AppCompatActivity implements View.OnClickListener{
    TextView tv2;
    EditText etMail, etPass;
    Button bt1;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private final String TAG = "FIREBASE LOG: ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regeister);

        tv2 = (TextView) findViewById(R.id.tv2);
        etMail = (EditText) findViewById(R.id.etMail);
        etPass = (EditText) findViewById(R.id.etPassword);

        bt1 = (Button) findViewById(R.id.button2);
        bt1.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };
    }

    public void createAccount(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(Regeister.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }else{
                            Intent i = new Intent(Regeister.this, LogInActivity.class);
                            startActivity(i);
                        }
                        // ...
                    }
                });
    }
    @Override
    public void onClick(View v) {
        createAccount(etMail.getText().toString(), etPass.getText().toString());

    }
}
