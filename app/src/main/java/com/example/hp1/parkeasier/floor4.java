package com.example.hp1.parkeasier;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class floor4 extends AppCompatActivity implements View.OnClickListener {

    Button[] btn = new Button[12];
    int[] ids = {R.id.BT1, R.id.BT2, R.id.BT3, R.id.BT4, R.id.BT5, R.id.BT6, R.id.BT7, R.id.BT8, R.id.BT9, R.id.BT10, R.id.BT11, R.id.BT12};

    boolean[] state = {false, false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};

    Button[] btnp = new Button[2];
    int[] idsp ={R.id.BTP1, R.id.BTP2};

    Button[] btnb = new Button[2];
    int[] idsb ={R.id.BTB1, R.id.BTB2};
    int count =0;

    TextView tv;

    Spinner spCoffee1;
    Spinner spCoffee2;
    Spinner spCoffee3;

    Adapter adapter3;
    Adapter adapter2;
    Adapter adapter1;

    String[] spList = {"None", "disablity", "pregnant"};
    String[] spList2 = {"None", "Gym", "shopping",};
    String[] spList3 = {"floor2", "floor1"};

    boolean flag1=false;

    Intent[] intents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor4);


        tv  = (TextView) findViewById(R.id.textView2);

        for (int i = 0; i < btn.length; i++) {
            btn[i] = (Button) findViewById(ids[i]);
            btn[i].setOnClickListener(this);
        }
        for (int i = 0; i < btnp.length; i++) {
            btnp[i] = (Button) findViewById(idsp[i]);
            btnp[i].setOnClickListener(this);
        }
        for (int i = 0; i < btnb.length; i++) {
            btnb[i] = (Button) findViewById(idsb[i]);
            btnb[i].setOnClickListener(this);
        }

        spCoffee1 = (Spinner) findViewById(R.id.spCoffee1);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spList);
        spCoffee1.setAdapter(adapter1);
        spCoffee1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
                if(position==1){
                    for(int i=0;i<btnb.length;i++)
                        btnb[i].startAnimation(animation);
                }
                if(position==2){
                    for(int i=0;i<btnp.length;i++)
                        btnp[i].startAnimation(animation);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spCoffee2 = (Spinner) findViewById(R.id.spCoffee2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spList2);
        spCoffee2.setAdapter(adapter2);
        spCoffee2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
                if(position==1){
                    for(int i=7;i<btn.length;i++)
                        btn[i].startAnimation(animation);
                }
                if(position==2){
                    for(int i=0;i<7;i++)
                        btn[i].startAnimation(animation);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spCoffee3 = (Spinner) findViewById(R.id.spCoffee3);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spList3);
        spCoffee3.setAdapter(adapter3);
        spCoffee3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==1)
                    startActivity(new Intent(floor4.this,MainActivity2.class));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        startTimer();
        for (int i = 0; i < btn.length; i++) {
            if (btn[i] == v)
                if(state[i]==false) {
                    btn[i].setBackgroundColor(Color.RED);
                    btn[i].setText("full");
                    state[i] = true;
                } else{
                    state[i] = false;
                    btn[i].setBackgroundColor(getResources().getColor(R.color.green));
                    btn[i].setText("empty");
                }
        }
        for (int i = 0; i < btnp.length; i++) {
            if (btnp[i] == v)
                if(state[i]==false) {
                    btnp[i].setBackgroundColor(Color.RED);
                    btnp[i].setText("full");
                    state[i] = true;
                } else{
                    state[i] = false;
                    btnp[i].setBackgroundColor(getResources().getColor(R.color.purple));
                    btnp[i].setText("empty");

                }
        }
        for (int i = 0; i < btnb.length; i++) {

            if (btnb[i] == v)
                if(state[i]==false) {
                    btnb[i].setBackgroundColor(Color.RED);
                    btnb[i].setText("full");
                    state[i] = true;
                } else{
                    state[i] = false;
                    btnb[i].setBackgroundColor(getResources().getColor(R.color.blue));
                    btnb[i].setText("empty");
                }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        AlertDialog.Builder Builder = new AlertDialog.Builder(this);
        Builder.setTitle("About");
        Builder.setMessage("our application is to let you win more time spending with friends and familys insted searching for parking places");

        Builder.setPositiveButton("Done",new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialog,int which){
                // Toast.makeText(getApplicationContext(),"Ok", Toast.LENGTH_LONG).show();
            }


        });
        AlertDialog ad=Builder.create();
        ad.show();


        return super.onOptionsItemSelected(item);
    }

    public void startTimer(){
        Timer T=new Timer();
        T.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        count++;
                    }
                });
            }
        }, 1000, 1000);
    }
}

