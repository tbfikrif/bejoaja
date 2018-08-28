package com.babage.b370;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.droidbyme.dialoglib.DroidDialog;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.mzelzoghbi.zgallery.ZGallery;
import com.mzelzoghbi.zgallery.entities.ZColor;
import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;
import com.shashank.sony.fancydialoglib.FancyAlertDialogListener;
import com.shashank.sony.fancydialoglib.Icon;

import java.util.ArrayList;

public class MainActivity extends Activity {

    MediaPlayer background, click;
    private FloatingActionButton fab;
    Button playButton;
    Button exitButton;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //menghilangkan ActionBar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);


        //addTestDevice("7E8C91EDBC508517346F63D16A0844CD")// Add your real device id here
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("7E8C91EDBC508517346F63D16A0844CD").build();
        mAdView.loadAd(adRequest);


        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the user is about to return
                // to the app after tapping on an ad.
            }
        });


        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                new DroidDialog.Builder(MainActivity.this)
//                        .icon(R.mipmap.ic_launcher_round)
//                        .title("Cara Bermain")
//                        .color(R.color.background,R.id.background,R.color.textColor)
//                        .content("1. Pahami Informasi melalui : \n- Gallery\n- Video\n- Atau mengklik icon profile client.\n\n2. Lalu jawab setiap pertanyaan menggunakan : \n- Tap pilihan ganda\n- atau isian masukkan. ")
//                        .cancelable(true, true)
//                        .positiveButton("OK", new DroidDialog.onPositiveListener() {
//                            @Override
//                            public void onPositive(Dialog droidDialog) {
//                                droidDialog.dismiss();
//                            }
//                        }).show();
                    final Dialog dialog = new Dialog(MainActivity.this);
                    dialog.setContentView(R.layout.panduanpermainan);

                    //AlertDialog.Builder builder = new AlertDialog.Builder(QuestActivity.this);
                    //View view = getLayoutInflater().inflate(R.layout.informasiberbohong, null);
                    Button okButton = dialog.findViewById(R.id.btnOk);
                    //final AlertDialog dialog = builder.create();
                    okButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });

                    dialog.show();
            }
        });
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

        final FancyAlertDialog.Builder fancy= new FancyAlertDialog.Builder(this);

        fancy.setTitle("Terimakasih");
        fancy.setBackgroundColor(Color.parseColor("#ffffff")) ; //Don't pass R.color.colorvalue
        fancy.setMessage("Anda yakin ingin keluar ?");
        fancy.setNegativeBtnText("Tidak");
        fancy.setPositiveBtnBackground(Color.parseColor("#E51F28"));  //Don't pass R.color.colorvalue
        fancy.setPositiveBtnText("Iya");
        fancy.setNegativeBtnBackground(Color.parseColor("#4c4b4d"));  //Don't pass R.color.colorvalue
        fancy.setAnimation(Animation.POP);
        fancy.isCancellable(true);
        fancy.setIcon(R.mipmap.ic_launcher_round, Icon.Visible);
        fancy.OnPositiveClicked(new FancyAlertDialogListener() {
                    @Override
                    public void OnClick() {
                        click.start();
                        finish();
                        System.exit(0);
                    }
                })
                .OnNegativeClicked(new FancyAlertDialogListener() {
                    @Override
                    public void OnClick() {

                    }
                })
                .build();

    }

    @Override
    public void onBackPressed() {
        final FancyAlertDialog.Builder fancy= new FancyAlertDialog.Builder(this);

        fancy.setTitle("Terimakasih");
        fancy.setBackgroundColor(Color.parseColor("#ffffff")) ; //Don't pass R.color.colorvalue
        fancy.setMessage("Anda yakin ingin keluar ?");
        fancy.setNegativeBtnText("Tidak");
        fancy.setPositiveBtnBackground(Color.parseColor("#E51F28"));  //Don't pass R.color.colorvalue
        fancy.setPositiveBtnText("Iya");
        fancy.setNegativeBtnBackground(Color.parseColor("#4c4b4d"));  //Don't pass R.color.colorvalue
        fancy.setAnimation(Animation.POP);
        fancy.isCancellable(true);
        fancy.setIcon(R.mipmap.ic_launcher_round, Icon.Visible);
        fancy.OnPositiveClicked(new FancyAlertDialogListener() {
            @Override
            public void OnClick() {
                click.start();
                finish();
                System.exit(0);

            }
        })
                .OnNegativeClicked(new FancyAlertDialogListener() {
                    @Override
                    public void OnClick() {

                    }
                })
                .build();
    }

}
