package com.example.emon.alamdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Alarm! Alarm!! Alarm!!!", Toast.LENGTH_LONG)
                .show();
        // play sound
        // send sms
    }
}
