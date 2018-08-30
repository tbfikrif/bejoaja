package com.babage.b370;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;
import com.shashank.sony.fancydialoglib.FancyAlertDialogListener;
import com.shashank.sony.fancydialoglib.Icon;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class LevelTwo extends AppCompatActivity {

    List<ChatModel> lstChat = new ArrayList<>();
    EditText e1;
    String isi;
    String alur;
    int life=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //menghilangkan ActionBar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_chatbar_round);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_level_two);

        e1=(EditText) findViewById(R.id.e1);

        final ListView lstView = (ListView)findViewById(R.id.listView);
        CustomAdapterImg adapter = new CustomAdapterImg(lstChat,this);
        lstView.setAdapter(adapter);
        lstView.setDivider(null);
        lstView.setDividerHeight(0);
        lstView.setDescendantFocusability(ListView.FOCUS_BLOCK_DESCENDANTS);

        //isi = stage/ alur = pilihan cerita
        isi="1";
        alur="0";

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.none);
        e1.setHint("Tidak Bekerja!");
        e1.setEnabled(false);


        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int selectedItem = lstView.getPositionForView(view);
                if (selectedItem==0){
                    Toasty.error(LevelTwo.this,"Sasa", Toast.LENGTH_SHORT,true).show();

                } else {
                    Toasty.error(LevelTwo.this,"Sisi", Toast.LENGTH_SHORT,true).show();
                }
            }
        });


        lstChat.add(new ChatModel("Eh ngomong-ngomong malam minggu ke A* yuk?", false));//false

        lstChat.add(new ChatModel("A* itu apaan?, gue gak ada waktu , nanti kalau bisa gue kabarin.", true));

        lstChat.add(new ChatModel("Gak asik dah, ada acara lu?",false));

        lstChat.add(new ChatModel("padahal Reunian kali-kali",false));

        lstChat.add(new ChatModel("Kerjaan kantor biasa, kerjaan akhir bulan selalu numpuk",true));

        lstChat.add(new ChatModel("Lah, gue kira udah keluar dari perusahaan gak jelas itu", false));

        lstChat.add(new ChatModel("Hush ngawur, biarpun perusahaannya gak jelas, gue bisa makan selama ini dari sono", true));

        lstChat.add(new ChatModel("Emang gak ada pikiran cari kerja lain aja gitu?", false));

        lstChat.add(new ChatModel("Heh lu pikir nyari kerja itu kaya ngupil ya?, kalau gampang gue udah pindah dari dulu",true));

        lstChat.add(new ChatModel("Lagian gue udah lama disini, kesel kerja itu wajar lah",true));

        lstChat.add(new ChatModel("Gue tau, tapi gue saranin mending pindah deh, cari yang lebih ngejamin, gue khawatir aja ama lu",false));

        lstChat.add(new ChatModel("Ya udah , gue hargain karena lu peduli ama gue, tapi bener untuk sekarang gue masih bisa bertahan", true));

        lstChat.add(new ChatModel("Terus gue denger-denger lu udah mau nikah ya?", true));

        lstChat.add(new ChatModel("Ini anak bisa aja kalau ngalihin topik", false));

        lstChat.add(new ChatModel("alhamdullilah doain aja semoga lancar, tapi ada beberapa kendala kecil sih", false));

        lstChat.add(new ChatModel("kendala apa?, gedung?, pasangan?", true));

        lstChat.add(new ChatModel("Gedung", false));

        lstChat.add(new ChatModel("Mana coba gue liat fotonya?", true));

        lstChat.add(new ChatModel("Nih", false));//foto

        lstChat.add(new ChatModel("Gila, lu jual ginjal ya?", true));

        lstChat.add(new ChatModel("Kurang ajar, gue nabung 2 tahun ", false));

        lstChat.add(new ChatModel("niat!", true));

        lstChat.add(new ChatModel("Ya iyalah harus niat, nikah kalau gak niat mending gak usah sekalian", false));

        lstChat.add(new ChatModel("Kalau bisa lu bantuin gue cari gedung lain deh, yang lebih murah XD", false));

        lstChat.add(new ChatModel("Iya pasti gue bantu, cuman gue beresin kerjaan dulu, tanggal berapa lu butuh emang?", true));

        lstChat.add(new ChatModel("10 oktober", false));

        lstChat.add(new ChatModel("2 minggu lagi!", true));

        lstChat.add(new ChatModel("gue dari sekarang sampe tanggal 4 pasti lembur terus", true));

        lstChat.add(new ChatModel("wah bener nih lu mau bantu?", false));

        lstChat.add(new ChatModel("iyalah udah kagak ketemu 2 tahun terus bawa kabar baik, masa gue kagak seneng juga", true));

        lstChat.add(new ChatModel("asik, gue cariin cewek deh nanti", false));

        lstChat.add(new ChatModel("Gue udah punya cewe, lu nyuruh gue selingkuh?", true));

        lstChat.add(new ChatModel("Demi tuhan, akhirnya lu punya pacar juga", false));

        lstChat.add(new ChatModel("Sialan, ya udah lu cari aja sendiri gedungnya kalau gitu", true));

        lstChat.add(new ChatModel("eh santai bro, lu kaya emak-emak aja, cepet marah", false));

        lstChat.add(new ChatModel("wkwk, maksud gue, gue gak nyangka aja lu bisa pacaran", false));

        lstChat.add(new ChatModel("padahal dari dulu kerjaan lu cuman liatin langit kadang-kadang makan lumpur", false));

        lstChat.add(new ChatModel("Yaiyalah orang gue masih bocah", true));

        lstChat.add(new ChatModel("Lu juga sama aja, hobi lu liatin pantat bu marnikan guru PPKN?", true));

        lstChat.add(new ChatModel("Sial, lu tau dari mana?,wkwk", false));

        lstChat.add(new ChatModel("Gue tau lah, orang gue juga suka ngeliatin, wkwkwk", true));

        lstChat.add(new ChatModel("Jadi selama ini, gue sama lu pecinta pantat ibu-ibu umur 30an gitu?, najis!", false));

        lstChat.add(new ChatModel("Yaelah namanya juga bocah XD", true));


    }

    public void dialog9() {

        AlertDialog.Builder aldia= new AlertDialog.Builder(LevelTwo.this,R.style.MyDialogTheme);
        aldia.setTitle("Jawaban:");
        final EditText input = new EditText(LevelTwo.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        input.setTextColor(Color.RED);
        aldia.setView(input);
        aldia.setPositiveButton("KIRIM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                String YouEditTextValue = input.getText().toString();

                if (YouEditTextValue.equalsIgnoreCase("Damian"))
                {
                    final DatabaseHelper dbHelper = new DatabaseHelper(LevelTwo.this);
                    dbHelper.addUser(new User("l2"));
                    Toasty.success(LevelTwo.this, "Misi Berhasil!, GZ.", Toast.LENGTH_SHORT, true).show();
                    Intent intent = new Intent(LevelTwo.this,QuestActivity.class);
                    startActivity(intent);
                    LevelTwo.this.finish();
                } else {

                    life--;
                    Toasty.error(LevelTwo.this,"Kesempatan Anda : "+life+"x Lagi!", Toast.LENGTH_SHORT,true).show();
                }


                if (life==0) {

                    ListView lstView = (ListView)findViewById(R.id.listView);
                    CustomAdapterImg adapter = new CustomAdapterImg(lstChat,LevelTwo.this);
                    lstView.setAdapter(adapter);
                    lstView.setDivider(null);
                    lstView.setDividerHeight(0);
                    final Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    final Dialog dialog= new Dialog(LevelTwo.this,android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                    final MediaPlayer pc = MediaPlayer.create(LevelTwo.this, R.raw.phonecell);
                    final MediaPlayer wm = MediaPlayer.create(LevelTwo.this, R.raw.woman_scream);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            pc.start();
                            // Get instance of Vibrator from current Context
                            long[] pattern = {1100, 1100, 1100, 1100, 1100, 1100, 1100, 1100, 1100, 500};
                            // Vibrate for 400 milliseconds
                            v.vibrate(pattern,-1);
                            dialog.setContentView(R.layout.telponberbohong);
                            dialog.setCancelable(false);
                            dialog.show();

                        }
                    }, 4600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            v.cancel();
                            wm.start();

                        }
                    }, 14600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            dialog.dismiss();

                        }
                    }, 18900); // Millisecond 1000 = 1 sec


                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            final FancyAlertDialog.Builder fancy= new FancyAlertDialog.Builder(LevelTwo.this);

                            fancy.setTitle("From : DeepSpeak Corporation");
                            fancy.setBackgroundColor(Color.parseColor("#ffffff")) ; //Don't pass R.color.colorvalue
                            fancy.setMessage("Client Anda Telah Dibunuh, Misi Anda Gagal!");
                            fancy.setNegativeBtnText("OKE");
                            fancy.setPositiveBtnBackground(Color.parseColor("#E51F28"));  //Don't pass R.color.colorvalue
                            fancy.setPositiveBtnText("KELUAR");
                            fancy.setNegativeBtnBackground(Color.parseColor("#4c4b4d"));  //Don't pass R.color.colorvalue
                            fancy.setAnimation(Animation.SIDE);
                            fancy.isCancellable(false);
                            fancy.setIcon(R.mipmap.ic_launcher_foreground, Icon.Visible);
                            fancy.OnPositiveClicked(new FancyAlertDialogListener() {
                                @Override
                                public void OnClick() {

                                    Intent intent = new Intent(LevelTwo.this,QuestActivity.class);
                                    startActivity(intent);
                                    LevelTwo.this.finish();

                                }
                            })
                                    .OnNegativeClicked(new FancyAlertDialogListener() {
                                        @Override
                                        public void OnClick() {

                                        }
                                    })
                                    .build();




                        }
                    }, 19900); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(LevelTwo.this,QuestActivity.class);
                            startActivity(intent);
                            LevelTwo.this.finish();
                        }
                    }, 28900); // Millisecond 1000 = 1 sec


                }
            }
        });

        AlertDialog aldiaer = aldia.create();
        aldiaer.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


}

