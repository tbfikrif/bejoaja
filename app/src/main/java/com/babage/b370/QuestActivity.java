package com.babage.b370;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class QuestActivity extends Activity {

    final Context context = this;
    Button q1, q2, q3, q4, q5, q6, q7, q8;
    MediaPlayer background, click, distortion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //menghilangkan ActionBar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_quest);

        background = MediaPlayer.create(QuestActivity.this, R.raw.background_quest);
        click = MediaPlayer.create(QuestActivity.this, R.raw.click2);
        distortion = MediaPlayer.create(QuestActivity.this, R.raw.hit_distortion);

        TextView textViewQuest = findViewById(R.id.textViewQuest);
        q1 = findViewById(R.id.Q1);
        q2 = findViewById(R.id.Q2);
        q3 = findViewById(R.id.Q3);
        q4 = findViewById(R.id.Q4);
        q5 = findViewById(R.id.Q5);
        q6 = findViewById(R.id.Q6);
        q7 = findViewById(R.id.Q7);
        q8 = findViewById(R.id.Q8);

        textViewQuest.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/youmurdererbb_reg.otf"));
        q1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/youmurdererbb_reg.otf"));
        q2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/youmurdererbb_reg.otf"));
        q3.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/youmurdererbb_reg.otf"));
        q4.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/youmurdererbb_reg.otf"));
        q5.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/youmurdererbb_reg.otf"));
        q6.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/youmurdererbb_reg.otf"));
        q7.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/youmurdererbb_reg.otf"));
        q8.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/youmurdererbb_reg.otf"));


        this.q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                level2();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        background.pause();
    }

    @Override
    protected void onStart() {
        super.onStart();
        background.start();
    }

    public void InformasiBerbohong(){
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.informasiberbohong);

        //AlertDialog.Builder builder = new AlertDialog.Builder(QuestActivity.this);
        //View view = getLayoutInflater().inflate(R.layout.informasiberbohong, null);
        Button okButton = dialog.findViewById(R.id.btnOk);
        okButton.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/youmurdererbb_reg.otf"));
        ImageView galeri = dialog.findViewById(R.id.galeri);
        //final AlertDialog dialog = builder.create();

        okButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent(QuestActivity.this, LevelOne.class);
                background.stop();
                distortion.start();
                QuestActivity.this.finish();
                startActivity(intent);
            }
        });

        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                click.start();
                galeriBerbohongOnClick();
            }
        });

        dialog.show();
    }

    public void berbohongOnClick(View v){
        click.start();
        InformasiBerbohong();
    }

    public void galeriBerbohongOnClick(){
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.galeriberbohong);

        Button tutupButton = dialog.findViewById(R.id.btnTutup);
        TextView galeriTitle = dialog.findViewById(R.id.galeriTitle);
        tutupButton.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/youmurdererbb_reg.otf"));
        galeriTitle.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/youmurdererbb_reg.otf"));

        tutupButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                click.start();
                InformasiBerbohong();
            }
        });

        dialog.show();
    }

    public void level2(){
        final DatabaseHelper dbHelper = new DatabaseHelper(this);
        User user = dbHelper.queryUser("l1");
        if (user != null) {
            //Bundle mBundle = new Bundle();
            //mBundle.putString("user", user.getValue());
            Intent intent = new Intent(QuestActivity.this, LevelTwo.class);
            //intent.putExtras(mBundle);
            startActivity(intent);
            QuestActivity.this.finish();
            Toast.makeText(QuestActivity.this, "Level Unlock ", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(QuestActivity.this, "Level Locked", Toast.LENGTH_SHORT).show();
        }


    }

}
