package com.example.hp1.parkeasier;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Regeister extends AppCompatActivity implements View.OnClickListener{
    TextView tv2;
    EditText et4;
    Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regeister);
        tv2 = (TextView) findViewById(R.id.tv2);
        et4 = (EditText) findViewById(R.id.et4);
        bt1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


    }
}
