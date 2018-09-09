package com.babage.b370;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import es.dmoral.toasty.Toasty;

public class VideoPlayerLevel1 extends AppCompatActivity {

    VideoView video;
    MediaController media;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_video_player);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String uri = intent.getStringExtra(LevelOne.EXTRA_VIDEO_URI);

        video = findViewById(R.id.videoView);

        new BackgroundAsyncTask()
                .execute(uri);
    }

    public class BackgroundAsyncTask extends AsyncTask<String, Uri, Void> {
        Integer track = 0;
        ProgressDialog dialog;

        protected void onPreExecute() {
            dialog = new ProgressDialog(VideoPlayerLevel1.this);
            dialog.setMessage("Loading, Mohon tunggu...");
            dialog.setCancelable(true);
            dialog.show();
        }

        protected void onProgressUpdate(final Uri... uri) {
            try {
                media=new MediaController(VideoPlayerLevel1.this);
                video.setMediaController(media);
                media.setPrevNextListeners(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // next button clicked
                        Toasty.success(VideoPlayerLevel1.this, "Misi Berhasil!, GZ.", Toast.LENGTH_SHORT, true).show();
                        Intent intents = new Intent(VideoPlayerLevel1.this,QuestActivity.class);
                        startActivity(intents);
                        finish();
                    }
                }, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toasty.success(VideoPlayerLevel1.this, "Misi Berhasil!, GZ.", Toast.LENGTH_SHORT, true).show();
                        Intent intents = new Intent(VideoPlayerLevel1.this,QuestActivity.class);
                        startActivity(intents);
                        finish();
                    }
                });
                media.show(10000);

                video.setVideoURI(uri[0]);
                video.requestFocus();
                video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

                    public void onPrepared(MediaPlayer arg0) {
                        video.start();
                        dialog.dismiss();
                    }
                });

                video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toasty.success(VideoPlayerLevel1.this, "Misi Berhasil!, GZ.", Toast.LENGTH_SHORT, true).show();
                        Intent intents = new Intent(VideoPlayerLevel1.this,QuestActivity.class);
                        startActivity(intents);
                        finish();
                    }
                });

            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (SecurityException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected Void doInBackground(String... params) {
            try {
                Uri uri = Uri.parse(params[0]);
                publishProgress(uri);
            } catch (Exception e) {
                e.printStackTrace();

            }
            return null;
        }
    }
}
