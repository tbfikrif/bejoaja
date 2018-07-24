package com.babage.b370;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreenTemp extends Activity {

    private static int WELCOME_TIMEOUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //menghilangkan ActionBar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen_temp);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent welcome = new Intent(SplashScreenTemp.this, IntroScreen.class);
                startActivity(welcome);
                finish();
            }
        }, WELCOME_TIMEOUT); //4000 L = 4 detik
    }
}
