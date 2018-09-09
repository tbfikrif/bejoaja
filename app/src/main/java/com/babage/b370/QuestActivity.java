package com.babage.b370;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;
import com.shashank.sony.fancydialoglib.FancyAlertDialogListener;
import com.shashank.sony.fancydialoglib.Icon;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import es.dmoral.toasty.Toasty;

/**
 * Created by Herdi_WORK on 15.09.16.
 */

public class QuestActivity extends AppCompatActivity implements RewardedVideoAdListener {
    public static final String PREFS_NAME = "B370PrefsFile";
    private RewardedVideoAd mRewardedVideoAd;
    private RecyclerView rvView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> dataSet;
    SharedPreferences prefs;
    int state=0;
    private TextView tvLife;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //menghilangkan ActionBar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setLogo(R.drawable.kasus);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        setContentView(R.layout.activity_quest);
        dataSet = new ArrayList<>();
        prefs = this.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);


        // Shared Preferences

//        Editor editor = prefs.edit();
//        editor.putInt("changeAnswer", 5);
//        editor.apply();


        initDataset();

        rvView = (RecyclerView) findViewById(R.id.rv_main);
        rvView.setHasFixedSize(true);

        /**
         * Kita menggunakan LinearLayoutManager untuk list standar
         * yang hanya berisi daftar item
         * disusun dari atas ke bawah
         */

        layoutManager = new LinearLayoutManager(this);
        rvView.setLayoutManager(layoutManager);

        adapter = new RecyclerViewAdapter(dataSet);
        rvView.setAdapter(adapter);


    }

    private void initDataset(){

        /**
         * Tambahkan item ke dataset
         * dalam prakteknya bisa bermacam2
         * tidak hanya String seperti di kasus ini
         */
        dataSet.add("Dead Quiz");
        dataSet.add("Who Am I?");
        dataSet.add("Level Belum Tersedia");
        dataSet.add("Level Belum Tersedia");
        dataSet.add("Level Belum Tersedia");



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return true;
    }
    //and this to handle actions
    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_mainMenu2) {
            SharedPreferences prefs = this.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
            DialogCheckAnswer();
            //Toast.makeText(getApplicationContext(),"Jumlah Chance Answer "+String.valueOf(prefs.getInt("changeAnswer", 5)),Toast.LENGTH_SHORT).show();

        } else if (id==R.id.action_settings){

                    rewardads();
                    item.setEnabled(false);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent intent = new Intent(QuestActivity.this, QuestActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        PendingIntent pendingIntent = PendingIntent.getActivity(QuestActivity.this, 0, intent, 0);

                        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(QuestActivity.this)
                                .setSmallIcon(R.mipmap.ic_launcher_foreground)
                                .setContentTitle("Ads Tersedia")
                                .setContentText("Segara dapatkan 10 chance answer")
                                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                                // Set the intent that will fire when the user taps the notification
                                .setContentIntent(pendingIntent)
                                .setAutoCancel(true);
                        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(QuestActivity.this);

                        // notificationId is a unique int for each notification that you must define
                        notificationManager.notify(1, mBuilder.build());

                        item.setEnabled(true);
                    }
                }, 30000);//30 menit // Millisecond 1000 = 1 sec
            }



        return super.onOptionsItemSelected(item);
    }

    public void rewardads(){

        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(this);

        loadRewardedVideoAd();

    }

    private void loadRewardedVideoAd() {
        mRewardedVideoAd.loadAd("ca-app-pub-3940256099942544/5224354917",
                new AdRequest.Builder().build());
    }

    @Override
    public void onRewarded(RewardItem reward) {
        int oldLife = prefs.getInt("changeAnswer", 5);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("changeAnswer", oldLife + 10);
        editor.apply();

        Toast.makeText(getApplicationContext(),"Anda mendapatkan 10 chance answer",Toast.LENGTH_SHORT).show();

        // Reward the user.
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdClosed() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int errorCode) {

    }

    @Override
    public void onRewardedVideoAdLoaded() {
        if (mRewardedVideoAd.isLoaded()) {
            mRewardedVideoAd.show();
        }
    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    private void DialogCheckAnswer() {
        String changeAnswer = String.valueOf(prefs.getInt("changeAnswer", 5));
        final FancyAlertDialog.Builder fancy= new FancyAlertDialog.Builder(this);
        fancy.setTitle("Kesempatan Menjawab");
        fancy.setBackgroundColor(Color.parseColor("#ffffff")) ;
        fancy.setMessage("Tersisa " + changeAnswer + " Kesempatan!");
        fancy.setPositiveBtnBackground(Color.parseColor("#E51F28"));
        fancy.setPositiveBtnText("Ok");
        fancy.setNegativeBtnText("Tutup");
        fancy.setAnimation(Animation.POP);
        fancy.isCancellable(true);
        fancy.setIcon(R.mipmap.ic_launcher_round, Icon.Visible);
        fancy.OnPositiveClicked(new FancyAlertDialogListener() {
            @Override
            public void OnClick() {

            }
        });
        fancy.OnNegativeClicked(new FancyAlertDialogListener() {
            @Override
            public void OnClick() {

            }
        });
        fancy.build();
    }

}
