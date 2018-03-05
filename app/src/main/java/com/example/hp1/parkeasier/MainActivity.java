package com.example.hp1.parkeasier;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
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
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import static com.example.hp1.parkeasier.R.id.BT10;
import static com.example.hp1.parkeasier.R.id.BT11;
import static com.example.hp1.parkeasier.R.id.BT12;
import static com.example.hp1.parkeasier.R.id.BT7;
import static com.example.hp1.parkeasier.R.id.BT8;
import static com.example.hp1.parkeasier.R.id.BT9;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button[] btn = new Button[11];
    int[] ids = {R.id.BT1 ,R.id.BT2, R.id.BT3, R.id.BT4, R.id.BT5, R.id.BT6, BT7, BT8, BT9, BT10, BT11, BT12};

    boolean[] state = { false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};

    Button[] btnp = new Button[2];
    int[] idsp ={R.id.BTP1, R.id.BTP2};

    Button[] btnb = new Button[2];
    int[] idsb ={R.id.BTB1, R.id.BTB2};

    Spinner spCoffee1;
    Spinner spCoffee2;
    Spinner spCoffee3;

    private long timeWhenStopped = 0;
    private boolean stopClicked;
    private Chronometer chronometer;

    String[] spList = {"None", "disablity", "pregnant"};
    String[] spList2 = {"None", "Gym", "shopping",};
    String[] spList3 = {"floor1", "floor2"};

    boolean flag1=false;

    Intent[] intents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = (Chronometer) findViewById(R.id.chronometer);


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
                    startActivity(new Intent(MainActivity.this,Floor2.class));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View v) {

        for (int i = 0; i < btn.length; i++) {
            if (btn[i] == v)
                if(state[i]==false) {
                    btn[i].setBackgroundColor(Color.RED);
                    btn[i].setText("full");
                    state[i] = true;
                    startButtonClick(v);
                } else{
                    state[i] = false;
                    btn[i].setBackgroundColor(getResources().getColor(R.color.green));
                    btn[i].setText("empty");
                    stopButtonClick(v);

                }
            }
        for (int i = 0; i < btnp.length; i++) {
            if (btnp[i] == v)
                if(state[i]==false) {
                    btnp[i].setBackgroundColor(Color.RED);
                    btnp[i].setText("full");
                    state[i] = true;
                    startButtonClick(v);
                } else{
                    state[i] = false;
                    btnp[i].setBackgroundColor(getResources().getColor(R.color.purple));
                    btnp[i].setText("empty");
                    stopButtonClick(v);

                }
        }
        for (int i = 0; i < btnb.length; i++) {

            if (btnb[i] == v)
                if(state[i]==false) {
                    btnb[i].setBackgroundColor(Color.RED);
                    btnb[i].setText("full");
                    state[i] = true;
                    startButtonClick(v);
                } else{
                    state[i] = false;
                    btnb[i].setBackgroundColor(getResources().getColor(R.color.blue));
                    btnb[i].setText("empty");
                    stopButtonClick(v);
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

    public void startButtonClick(View v) {
        chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
        chronometer.start();
        scheduleNotification(this,3600000,1);
        stopClicked = false;

    }

    // the method for when we press the 'stop' button
    public void stopButtonClick(View v){
        if (!stopClicked)  {
            timeWhenStopped =SystemClock.elapsedRealtime() - chronometer.getBase();
            int seconds = (int) timeWhenStopped / 1000;
            chronometer.stop();
            stopClicked = true;
            chronometer.setBase(SystemClock.elapsedRealtime());
            timeWhenStopped = 0;
            ticketprice(seconds);

        }
    }
    public void ticketprice(int seconds){
        AlertDialog.Builder Builder = new AlertDialog.Builder(this);
        Builder.setTitle("ticketprice");
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println( sdf.format(cal.getTime()) );

        int hours = seconds/60;
        double rate=hours*1.5;
        Builder.setMessage("your ticketprice is "+rate+" shekels" );
        Builder.setPositiveButton("Done",new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialog,int which){

            }
        });
        AlertDialog ad=Builder.create();
        ad.show();


    }
    public void scheduleNotification(Context context, long delay, int notificationId) {//delay is after how much time(in millis) from current time you want to schedule the notification

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentTitle(context.getString(R.string.title))
                .setContentText(context.getString(R.string.content))
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.parkingq)
                .setLargeIcon(((BitmapDrawable) context.getResources().getDrawable(R.drawable.parkingq)).getBitmap())
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));

        Intent intent = new Intent(context, TestActivity.class);
        PendingIntent activity = PendingIntent.getActivity(context, notificationId, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setContentIntent(activity);

        Notification notification = builder.build();

        Intent notificationIntent = new Intent(context, MyNotificationPublisher.class);
        notificationIntent.putExtra(MyNotificationPublisher.NOTIFICATION_ID, notificationId);
        notificationIntent.putExtra(MyNotificationPublisher.NOTIFICATION, notification);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, notificationId, notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        long futureInMillis = SystemClock.elapsedRealtime() + delay;
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, pendingIntent);
    }


}

