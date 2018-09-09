package com.babage.b370.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;

import com.babage.b370.MainActivity;
import com.babage.b370.R;

import static android.content.Context.MODE_PRIVATE;
import static com.babage.b370.QuestActivity.PREFS_NAME;

public class NotificationPublisher extends BroadcastReceiver{
    public static String NOTIFICATION_ID = "notification-id";
    public static String NOTIFICATION = "notification";
    SharedPreferences prefs;

    public void onReceive(Context context, Intent intent) {
        MediaPlayer notif = MediaPlayer.create(context, R.raw.none);
        notif.start();

        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        Notification notification = intent.getParcelableExtra(NOTIFICATION);
        int id = intent.getIntExtra(NOTIFICATION_ID, 0);
        notificationManager.notify(id, notification);

        prefs = context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("canWatchAds" , true);
        editor.apply();
    }
}
