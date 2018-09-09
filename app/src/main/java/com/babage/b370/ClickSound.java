package com.babage.b370;

import android.content.Context;
import android.media.MediaPlayer;

public class ClickSound {

    private static final String TAG = ClickSound.class.toString();

    private static final ClickSound INSTANCE = new ClickSound();

    public MediaPlayer click;

    private ClickSound() {

    }

    public static ClickSound getInstance() {
        return INSTANCE;
    }

    private Context context;

    public void init(Context context) {
        this.context = context;
        click = MediaPlayer.create(context, R.raw.click2);
        click.setLooping(false);
    }

    public void playSound() {
        click.start();
    }

    public void stopSound() {
        click.setLooping(false);
        click.stop();
    }
}
