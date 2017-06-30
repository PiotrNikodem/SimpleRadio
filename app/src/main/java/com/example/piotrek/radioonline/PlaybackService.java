package com.example.piotrek.radioonline;

/**
 * Created by Piotrek on 2017-05-15.
 */

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

public class PlaybackService extends Service {

    private MediaPlayer mediaPlayer;

    public PlaybackService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){

        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(intent.getStringExtra("url"));
            mediaPlayer.prepare();
            Toast t = Toast.makeText(getApplicationContext(), "Laduje", Toast.LENGTH_LONG);
            t.show();
            mediaPlayer.start();

            Intent clickIntent = new Intent(this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), clickIntent, 0);


            Notification notification =
                    new Notification.Builder(this)
                            .setContentTitle(intent.getStringExtra("tytul"))
                            .setContentIntent(pendingIntent)
                            .setContentText("opis")
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .build();

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            notificationManager.notify(0, notification);

        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("PlaybackServie", "Started");
        return START_STICKY;
    }

    @Override
    public void onDestroy(){
        mediaPlayer.stop();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(0);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
