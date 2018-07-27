package com.babage.b370;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class IntroScreen extends Activity {

    private static int WELCOME_TIMEOUT = 18300;
    Button btnSkip;
    ConstraintLayout cd;
    int test=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //menghilangkan ActionBar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_intro_screen);
        cd = (ConstraintLayout)findViewById(R.id.cs);

        final TypeWriter tw = findViewById(R.id.typeWriter);

        tw.setText("");
        tw.setCharacterDelay(150);
        tw.animateText(getResources().getString(R.string.welcomeText));





           final Handler handler = new Handler();

           handler.postDelayed(new Runnable() {
               @Override
               public void run() {
                   Intent welcome = new Intent(IntroScreen.this, MainActivity.class);
                   startActivity(welcome);
                   finish();
               }
           }, WELCOME_TIMEOUT);

        cd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.removeCallbacksAndMessages(null);
                Intent mainGo = new Intent(IntroScreen.this, MainActivity.class);
                startActivity(mainGo);

                finish();
            }
        });



    }


}
