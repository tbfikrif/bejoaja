package com.babage.b370;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mzelzoghbi.zgallery.ZGallery;
import com.mzelzoghbi.zgallery.entities.ZColor;
import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;
import com.shashank.sony.fancydialoglib.FancyAlertDialogListener;
import com.shashank.sony.fancydialoglib.Icon;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import es.dmoral.toasty.Toasty;

import static com.babage.b370.QuestActivity.PREFS_NAME;


public class Informan extends AppCompatActivity {

    CircleImageView imgv;
    ImageView btnc, btng, btnv;
    ArrayList<String> imagesList = new ArrayList<String>();

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //menghilangkan ActionBar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_informan);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher_foreground);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);

        ClickSound.getInstance().init(getApplicationContext());

        btnv = findViewById(R.id.btnV);
        btng = findViewById(R.id.btnG);
        btnc = findViewById(R.id.btnC);
        imgv = findViewById(R.id.imgv);

        imagesList.add("https://image.ibb.co/ew843z/20170607_170607_0022.jpg");
        imagesList.add("https://preview.ibb.co/jfRzLe/20170607_170607_0030.jpg");
        imagesList.add("https://image.ibb.co/gYRc6K/1533013736723.jpg");
        imagesList.add("https://preview.ibb.co/iXZEmK/1533013798894.jpg");
        imagesList.add("https://preview.ibb.co/eJdw0e/1533013816514.jpg");
        imagesList.add("https://preview.ibb.co/eKoqRK/1533013833097.jpg");
        imagesList.add("https://preview.ibb.co/jdS0RK/1533014128823.jpg");
        imagesList.add("https://preview.ibb.co/f0AFtz/1533014293149.jpg");
        imagesList.add("https://preview.ibb.co/mNprYz/1533014302309.jpg");
        imagesList.add("https://image.ibb.co/eWnpLe/1533014333293.jpg");
        imagesList.add("https://preview.ibb.co/kgRARK/1533014368948.jpg");
        imagesList.add("https://image.ibb.co/iUgwYz/1533014389572.jpg");

        prefs = this.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        btnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickSound.getInstance().playSound();
                goVideo();

            }
        });

        btng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickSound.getInstance().playSound();
                goGallery();

            }
        });

        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickSound.getInstance().playSound();
                goChat();

            }
        });

        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickSound.getInstance().playSound();
                goInformation();
            }
        });


    }

    public void goGallery() {

        ZGallery.with(this,imagesList /*your string arraylist of image urls*/)
                .setToolbarTitleColor(ZColor.WHITE) // toolbar title color
                .setGalleryBackgroundColor(ZColor.BLACK) // activity background color
                .setToolbarColorResId(R.color.colorPrimary) // toolbar color
                .setTitle("NEYSA GALLERY") // toolbar title
                .show();

    }

    public void goChat(){

        final FancyAlertDialog.Builder fancy= new FancyAlertDialog.Builder(this);

        fancy.setTitle("Misi Menyelamatkan");
        fancy.setBackgroundColor(Color.parseColor("#ffffff")) ;
        fancy.setMessage("Anda yakin ingin mengambil misi ini ?");
        fancy.setNegativeBtnText("Tidak");
        fancy.setPositiveBtnBackground(Color.parseColor("#E51F28"));
        fancy.setPositiveBtnText("Iya");
        fancy.setNegativeBtnBackground(Color.parseColor("#4c4b4d"));
        fancy.setAnimation(Animation.SLIDE);
        fancy.isCancellable(true);
        fancy.setIcon(R.mipmap.ic_launcher_round, Icon.Visible);
        fancy.OnPositiveClicked(new FancyAlertDialogListener() {
            @Override
            public void OnClick() {
                ClickSound.getInstance().playSound();
                int oldLife = prefs.getInt("changeAnswer", 5);
                if (oldLife > 0) {
                    Intent i = new Intent(getApplicationContext(),LevelOne.class);
                    startActivity(i);
                    Informan.this.finish();
                } else {
                    Toasty.error(getApplicationContext(), "Kesempatan Jawab sudah habis", Toast.LENGTH_SHORT, true).show();
                }
            }
        })
                .OnNegativeClicked(new FancyAlertDialogListener() {
                    @Override
                    public void OnClick() {
                        ClickSound.getInstance().playSound();
                    }
                })
                .build();


    }

    public void goInformation(){


                    final Dialog dialog = new Dialog(this);
                    dialog.setContentView(R.layout.informasiberbohong);

                    //AlertDialog.Builder builder = new AlertDialog.Builder(QuestActivity.this);
                    //View view = getLayoutInflater().inflate(R.layout.informasiberbohong, null);
                    Button okButton = dialog.findViewById(R.id.btnOk);
                    //final AlertDialog dialog = builder.create();
                    okButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ClickSound.getInstance().playSound();
                            dialog.dismiss();
                        }
                    });

                dialog.show();

    }


    public void goVideo(){
        Intent i = new Intent(Informan.this, vdplay.class);
        startActivity(i);

    }

}
