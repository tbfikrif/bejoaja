package com.babage.b370;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    MediaPlayer background, click;

    Button playButton;
    Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //menghilangkan ActionBar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        background = MediaPlayer.create(MainActivity.this, R.raw.background_mainmenu);
        click = MediaPlayer.create(this, R.raw.click2);
        //background.start();

        TextView gameTitle = findViewById(R.id.gameTitle);
        TextView gameDecription = findViewById(R.id.decription);
        playButton = findViewById(R.id.playButton);
        exitButton = findViewById(R.id.exitButton);
        gameTitle.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/youmurdererbb_reg.otf"));
        gameDecription.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/youmurdererbb_reg.otf"));
        playButton.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/youmurdererbb_reg.otf"));
        exitButton.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/youmurdererbb_reg.otf"));
    }

    @Override
    protected void onStart() {
        super.onStart();
        background.start();
    }

    public void playGame(View view){
        Intent intent = new Intent(this, QuestActivity.class);
        click.start();
        background.pause();
        //background.stop();
        startActivity(intent);
    }

    public void exitGame(View view){
        click.start();
        finish();
        System.exit(0);
    }
}
