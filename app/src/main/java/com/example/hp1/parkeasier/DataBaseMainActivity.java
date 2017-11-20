package com.example.hp1.parkeasier;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DataBaseMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base_main);


        FirebaseDatabase firebaseDatabase =FirebaseDatabase.getInstance();
        DatabaseReference databaseReference =firebaseDatabase.getReference("massage");
        databaseReference.setValue("hello");
    }
}
