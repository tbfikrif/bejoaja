package com.babage.b370;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
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


public class InformanDua extends AppCompatActivity {

    CircleImageView btnv,btng,btnc,imgv;
    ArrayList<String> imagesList = new ArrayList<String>();

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //menghilangkan ActionBar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_informan_dua);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher_foreground);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);

        btnv = (CircleImageView) findViewById(R.id.btnV);
        btng = (CircleImageView) findViewById(R.id.btnG);
        btnc = (CircleImageView) findViewById(R.id.btnC);
        imgv = (CircleImageView) findViewById(R.id.imgv);

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

                goVideo();


            }
        });

        btng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goGallery();


            }
        });

        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goChat();


            }
        });

        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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

                    showLoginDialog();

            }
        })
                .OnNegativeClicked(new FancyAlertDialogListener() {
                    @Override
                    public void OnClick() {

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
                            dialog.dismiss();
                        }
                    });

                dialog.show();

    }


    public void goVideo(){
        Intent i = new Intent(InformanDua.this, vdplay.class);
        startActivity(i);
        Toasty.warning(this, "Koneksi Internet Diperlukan", Toast.LENGTH_LONG, true).show();

    }

    private void showLoginDialog()
    {
        LayoutInflater li = LayoutInflater.from(this);
        View prompt = li.inflate(R.layout.login_dialog, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this,R.style.MyDialogTheme);
        alertDialogBuilder.setView(prompt);
        alertDialogBuilder.setTitle("Hack Account");

        final EditText userName = (EditText) prompt.findViewById(R.id.login_name);
        final EditText passWord = (EditText) prompt.findViewById(R.id.login_password);
        final String usersGet=(String) userName.getText().toString();
        final String passwordGet=(String) passWord.getText().toString();


        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if ((userName.getText().toString().equals("bejo")) && (passWord.getText().toString().equals("123"))) {

                    Intent i = new Intent(InformanDua.this,LevelTwo.class);
                    startActivity(i);
                    finish();

                } else {
                    Toasty.error(getApplicationContext(), "Username/Password Tidak Cocok", Toast.LENGTH_SHORT, true).show();
                    int oldLife = prefs.getInt("changeAnswer", 5);
                    if (oldLife > 0) {
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("changeAnswer", oldLife - 1);
                        editor.apply();
                    } else {
                        Toasty.error(getApplicationContext(), "Kesempatan Jawab sudah habis", Toast.LENGTH_SHORT, true).show();
                    }

                }

            }
        }).setNegativeButton("BACK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }).show();



    }

}