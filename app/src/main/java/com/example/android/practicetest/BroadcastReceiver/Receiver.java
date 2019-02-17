package com.example.android.practicetest.BroadcastReceiver;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.android.practicetest.NotificationUtil.Notification;

public class Receiver extends BroadcastReceiver {
    private static final String TAG = "Receiver";

    public Receiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: ");
        if (intent.getAction().equals(Notification.ACTION_CANCEL_NOTIFICATION)) {
            int notificationId = intent.getIntExtra("notificationID", 0);
            Log.d(TAG, "onReceive: notificationID " + notificationId);
            NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            manager.cancel(notificationId);
        }
        if (intent.getAction().equals(Notification.ACTION_UPDATE_NOTIFICATION)) {
            Notification.updatedNotification(context);
        }
    }
}
