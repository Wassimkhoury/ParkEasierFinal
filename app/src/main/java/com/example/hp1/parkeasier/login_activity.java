package com.example.hp1.parkeasier;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class login_activity extends AppCompatActivity implements View.OnClickListener{
    EditText et2;
    TextView tv1;
    EditText et3;
    Button bt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        bt3 = (Button) findViewById(R.id.bt3);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        tv1 = (TextView) findViewById(R.id.tv1);
        bt3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(et2.getText().toString().length()<8){

        }

        if(et3.getText().toString().length()<8){

}
        else{

        }
    }

}
