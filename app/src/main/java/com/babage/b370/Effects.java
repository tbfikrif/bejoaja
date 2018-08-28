package com.babage.b370;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;

public class Effects {

    private static final String TAG = Effects.class.toString();

    private static final Effects INSTANCE = new Effects();

    public MediaPlayer keystroke;

    private Effects() {

    }

    public static Effects getInstance() {
        return INSTANCE;
    }

    private Context context;

    public void init(Context context) {
        this.context = context;
        keystroke = MediaPlayer.create(context, R.raw.keystroke);
        keystroke.setLooping(true);
    }

    public void playSound() {
        keystroke.start();
    }

    public void stopSound() {
        keystroke.setLooping(false);
        keystroke.stop();
    }
}
