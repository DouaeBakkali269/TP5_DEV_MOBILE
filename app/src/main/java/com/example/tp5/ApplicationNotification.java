package com.example.tp5;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class ApplicationNotification extends Application {
    public static final String CHANNEL_1_ID = "channel1";
    public static final String CHANNEL_2_ID = "channel2";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannels();
    }

    private void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1_ID, "Canal 1",
                    NotificationManager.IMPORTANCE_HIGH);
            channel1.setDescription("Ceci est le canal 1");

            NotificationChannel channel2 = new NotificationChannel(
                    CHANNEL_2_ID, "Canal 2",
                    NotificationManager.IMPORTANCE_LOW);
            channel2.setDescription("Ceci est le canal 2");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel2);
            manager.createNotificationChannel(channel1);

        }
    }
}