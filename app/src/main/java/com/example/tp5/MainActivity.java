package com.example.tp5;

import android.app.Notification;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {
    private Button button1, button2;
    private NotificationManagerCompat notificationManager;
    private EditText editTextTitle, editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views AFTER setContentView()
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextMessage = findViewById(R.id.editTextMessage);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        // Initialize NotificationManagerCompat
        notificationManager = NotificationManagerCompat.from(this);

        // Set button click listeners
        button1.setOnClickListener(v -> creerNotification1());
        button2.setOnClickListener(v -> creerNotification2());
    }

    private void creerNotification1() {
        // Access views here (after they are initialized)
        String title = editTextTitle.getText().toString().trim();
        String message = editTextMessage.getText().toString().trim();

        Notification notification = new NotificationCompat.Builder(this, ApplicationNotification.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground) // Ensure this icon exists
                .setContentTitle(title.isEmpty() ? "Notification 1" : title)
                .setContentText(message.isEmpty() ? "Ceci est une notification du canal 1" : message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true)
                .build();

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        notificationManager.notify(1, notification);
    }

    private void creerNotification2() {
        // Access views here (after they are initialized)
        String title = editTextTitle.getText().toString().trim();
        String message = editTextMessage.getText().toString().trim();

        Notification notification = new NotificationCompat.Builder(this, ApplicationNotification.CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground) // Ensure this icon exists
                .setContentTitle(title.isEmpty() ? "Notification 2" : title)
                .setContentText(message.isEmpty() ? "Ceci est une notification du canal 2" : message)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setAutoCancel(true)
                .build();

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        notificationManager.notify(2, notification);
    }
}