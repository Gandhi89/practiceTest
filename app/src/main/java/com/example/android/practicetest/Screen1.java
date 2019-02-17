package com.example.android.practicetest;

import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.android.practicetest.BroadcastReceiver.Receiver;
import com.example.android.practicetest.Service.ScheduledService;

public class Screen1 extends AppCompatActivity {

    Button Toast, Snackbar, Notification, JobScheduler;
    Receiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast = findViewById(R.id.screen2_topic1);
        Snackbar = findViewById(R.id.Topic2);
        Notification = findViewById(R.id.Topic4);
        JobScheduler = findViewById(R.id.Topic3);
        receiver = new Receiver();
        registerReceiver(receiver, new IntentFilter(com.example.android.practicetest.NotificationUtil.Notification.ACTION_CANCEL_NOTIFICATION));
        registerReceiver(receiver, new IntentFilter(com.example.android.practicetest.NotificationUtil.Notification.ACTION_UPDATE_NOTIFICATION));
    }

    /**
     * Toast Button will execute this method
     *
     * @param view
     */
    public void showToast(View view) {
        android.widget.Toast.makeText(this, "This is example of Toast", android.widget.Toast.LENGTH_SHORT).show();
    }

    /**
     * Snackbar button will execute this method
     *
     * @param view
     */
    public void showSnackbar(View view) {
        final android.support.design.widget.Snackbar snackbar = android.support.design.widget.Snackbar.make(view, "This is example of Snackbar",
                android.support.design.widget.Snackbar.LENGTH_LONG);
        snackbar.show();
        snackbar.setAction("dismiss", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snackbar.dismiss();
            }
        });
    }

    /**
     * Notification button will execute this method
     *
     * @param view
     */
    public void showNotification(View view) {

        com.example.android.practicetest.NotificationUtil.Notification.notifyUser(this);

    }

    /**
     * JobScheduler button will execute this method
     *
     * @param view
     */
    public void scheduleTask(View view) {
        ComponentName componentName = new ComponentName(this, ScheduledService.class);
        JobInfo jobInfo = new JobInfo.Builder(123, componentName)
                .setPeriodic(15 * 60 * 1000)
                .setPersisted(true)
                .build();
        android.app.job.JobScheduler scheduler = (android.app.job.JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        scheduler.schedule(jobInfo);
    }

    @Override
    public void onDetachedFromWindow() {
        unregisterReceiver(receiver);
        super.onDetachedFromWindow();
    }


}
