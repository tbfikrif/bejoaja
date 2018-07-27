package com.babage.b370;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class IntroScreen extends Activity {

    private static int WELCOME_TIMEOUT = 19000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //menghilangkan ActionBar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_intro_screen);

        final TypeWriter tw = findViewById(R.id.typeWriter);

        tw.setText("");
        tw.setCharacterDelay(150);
        tw.animateText(getResources().getString(R.string.welcomeText));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent welcome = new Intent(IntroScreen.this, MainActivity.class);
                startActivity(welcome);
                finish();
            }
        }, WELCOME_TIMEOUT); //19000 L = 19 detik
    }

    public void ScreenTap(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }
}
