package com.example.emon.alamdemo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {
    private EditText etTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etTime = (EditText) findViewById(R.id.etTime);
    }

    public void setAlarm(View v) {
        String timeStr = etTime.getText().toString();
        int interval = Integer.parseInt(timeStr);
        long time = new GregorianCalendar().getTimeInMillis()
                + (interval * 1000);

        Intent alarmIntent = new Intent(this, AlarmReceiver.class);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, time, PendingIntent
                .getBroadcast(this, 1, alarmIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT));
    }

    public void setAlarmRepeat(View v) {
        String timeStr = etTime.getText().toString();
        int interval = Integer.parseInt(timeStr);
        long time = new GregorianCalendar().getTimeInMillis()
                + (interval * 1000);

        Intent alarmIntent = new Intent(this, AlarmReceiver.class);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, time,
                interval * 1000, PendingIntent.getBroadcast(this, 1,
                        alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT));
    }
}
