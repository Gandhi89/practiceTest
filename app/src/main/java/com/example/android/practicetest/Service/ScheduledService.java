package com.example.android.practicetest.Service;

import android.app.job.JobParameters;
import android.app.job.JobService;

import com.example.android.practicetest.NotificationUtil.Notification;

public class ScheduledService extends JobService {

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Notification.notifyUser(ScheduledService.this);
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
