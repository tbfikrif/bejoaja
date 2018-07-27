package com.babage.b370;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LevelOne extends AppCompatActivity {

    List<ChatModel> lstChat = new ArrayList<>();
    EditText e1;
    String isi;
    String alur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //menghilangkan ActionBar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_level_one);


        e1=(EditText) findViewById(R.id.e1);


        ListView lstView = (ListView)findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(lstChat,this);
        lstView.setAdapter(adapter);
        lstView.setDivider(null);
        lstView.setDividerHeight(0);

        //isi = stage/ alur = pilihan cerita
        isi="1";
        alur="0";

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.none);
        e1.setHint("Tunggu");
        e1.setEnabled(false);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ListView lstView = (ListView)findViewById(R.id.listView);
                CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                lstView.setAdapter(adapter);
                lstView.setDivider(null);
                lstView.setDividerHeight(0);
                mp.start();
                lstChat.add(new ChatModel("Selamat saudari Neysa, karena anda telah beruntung terpilih sebagai peserta the quiz berikutnya", true));
            }
        }, 2000); // Millisecond 1000 = 1 sec

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ListView lstView = (ListView)findViewById(R.id.listView);
                CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                lstView.setAdapter(adapter);
                lstView.setDivider(null);
                lstView.setDividerHeight(0);
                mp.start();
                lstChat.add(new ChatModel("Aturan quiz ini cukup sederhana, yaitu jika anda salah menjawab, anda akan mati.", true));
            }
        }, 4000); // Millisecond 1000 = 1 sec

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ListView lstView = (ListView)findViewById(R.id.listView);
                CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                lstView.setAdapter(adapter);
                lstView.setDivider(null);
                lstView.setDividerHeight(0);
                mp.start();
                lstChat.add(new ChatModel("Jangan terlalu dipikirkan karena bagaimanapun cepat atau lambat kematian akan menjemput kita bukan?", true));
            }
        }, 6000); // Millisecond 1000 = 1 sec

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ListView lstView = (ListView)findViewById(R.id.listView);
                CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                lstView.setAdapter(adapter);
                lstView.setDivider(null);
                lstView.setDividerHeight(0);
                mp.start();
                lstChat.add(new ChatModel("Karena sebenarnya kematian selalu tersenyum kepada kita dan yang bisa kita lakukan hanya tersenyum balik", true));
            }
        }, 8000); // Millisecond 1000 = 1 sec

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ListView lstView = (ListView)findViewById(R.id.listView);
                CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                lstView.setAdapter(adapter);
                lstView.setDivider(null);
                lstView.setDividerHeight(0);
                mp.start();
                lstChat.add(new ChatModel("Baiklah, mungkin sekarang kita bisa menuju acara utama. Yang harus anda lakukan hanya menjawab semua pertanyaan yang saya berikan", true));
            }
        }, 10000); // Millisecond 1000 = 1 sec

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ListView lstView = (ListView)findViewById(R.id.listView);
                CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                lstView.setAdapter(adapter);
                lstView.setDivider(null);
                lstView.setDividerHeight(0);
                mp.start();
                lstChat.add(new ChatModel("Jadi tidak ada yang perlu dikhawatirkan, kalau begitu anda sudah siap?", true));
            }
        }, 12000); // Millisecond 1000 = 1 sec

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                e1.setEnabled(true);
                e1.setHint("Jawab");

            }
        }, 12100); // Millisecond 1000 = 1 sec


        e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isi=="1") {

                    //masuk dialog pertama
                    dialog1();

                } else if (isi=="2") {

                    // masuk dialog kedua
                    dialog2();

                } else if (isi=="3"){

                    //masuk dialog ketiga
                    dialog3();

                } else if (isi=="4"){

                    dialog4();

                } else if (isi=="5"){

                    dialog5();

                } else if (isi=="6"){

                    dialog6();

                } else if (isi=="7"){

                    dialog7();

                } else if (isi=="8"){

                    dialog8();

                } else if (isi=="9"){

                    dialog9();
                }

            }
        });

    }


    public void dialog1() {

        final MediaPlayer mp = MediaPlayer.create(LevelOne.this, R.raw.none);
        ListView lstView = (ListView)findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(lstChat,this);
        lstView.setAdapter(adapter);
        lstView.setDivider(null);
        lstView.setDividerHeight(0);

        final CharSequence[] Q1 = {
                "Saya Siap", "Tentu", "Saya tidak mengerti"
        };


        AlertDialog.Builder alder = new AlertDialog.Builder(this,R.style.MyDialogTheme);
        alder.setTitle("");
        alder.setItems(Q1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (Q1[i]=="Saya Siap")
                {
                    e1.setEnabled(false);
                    e1.setHint("Tunggu");

                    ListView lstView = (ListView)findViewById(R.id.listView);
                    CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                    lstView.setAdapter(adapter);
                    lstView.setDivider(null);
                    lstView.setDividerHeight(0);

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Saya tidak begitu mengerti situasi ini, tapi saya siap",false));
                            lstChat.add(new ChatModel("Wow, saya tau anda orang yang sangat bersemangat, tapi saya tidak tau anda bisa seberani ini ", true));

                        }
                    }, 600); // Millisecond 1000 = 1 sec


                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Saya terharu mengetahuinya", true));
                        }
                    }, 2600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Saya punya firasat permainan ini akan menarik", true));

                        }
                    }, 4600); // Millisecond 1000 = 1 sec


                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Kalau begitu pertanyaan pertama adalah", true));
                        }
                    }, 6600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Jika dunia ini berakhir besok, siapa yang akan anda selamatkan?", true));
                        }
                    }, 8600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                           e1.setEnabled(true);
                           e1.setHint("Jawab");
                        }
                    }, 8601); // Millisecond 1000 = 1 sec



                    isi="2";
                    alur="1a";
                } else

                if (Q1[i]=="Tentu")
                {
                    ListView lstView = (ListView)findViewById(R.id.listView);
                    CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                    lstView.setAdapter(adapter);
                    lstView.setDivider(null);
                    lstView.setDividerHeight(0);

                    e1.setEnabled(false);
                    e1.setHint("Tunggu");

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Tentu, saya sudah mengetahui sejak awal bahwa saya adalah korban berikutnya",false));
                            lstChat.add(new ChatModel("Apa itu benar?, kalau begitu penilaian saya selama ini kepada anda salah", true));
                        }
                    }, 600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Saya hanya menduga bahwa anda hanya perempuan yang suka bermain dengan setiap laki-laki", true));
                        }
                    }, 2600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Baiklah mari kita mulai permainan mengasikkan ini", true));

                        }
                    }, 4600); // Millisecond 1000 = 1 sec


                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Pertanyaan KE-1", true));
                        }
                    }, 6600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Jika dunia ini berakhir besok, siapa yang akan anda selamatkan?", true));
                        }
                    }, 8600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            e1.setEnabled(true);
                            e1.setHint("Jawab");
                        }
                    }, 8600); // Millisecond 1000 = 1 sec


                    isi="2";
                    alur="1b";

                } else

                if (Q1[i]=="Saya tidak mengerti")
                {
                    ListView lstView = (ListView)findViewById(R.id.listView);
                    CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                    lstView.setAdapter(adapter);
                    lstView.setDivider(null);
                    lstView.setDividerHeight(0);

                    e1.setEnabled(false);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Tolong jelaskan ada apa ini?, kamu siapa?",false));
                            lstChat.add(new ChatModel("Tidak ada apa-apa hanya saja malaikat maut tertarik kepada anda", true));
                        }
                    }, 600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Mungkin karena anda sealu menyakiti perasaan orang lain", true));
                        }
                    }, 2600); // Millisecond 1000 = 1 sec


                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("atau karena anda adalah orang egois?. Tapi bagi saya pribadi, saya lebih setuju dengan alasan pertama.", true));

                        }
                    }, 4600); // Millisecond 1000 = 1 sec


                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Tanpa berbasa-basi lebih lama, mari langsung saja ke pertanyaan pertama", true));
                        }
                    }, 6600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Jika dunia ini berakhir besok, siapa yang akan anda selamatkan?", true));
                        }
                    }, 8600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            e1.setEnabled(true);
                            e1.setHint("Jawab");
                        }
                    }, 8601); // Millisecond 1000 = 1 sec


                    isi="2";
                    alur="1c";

                }
            }
        });
        AlertDialog builder = alder.create();
        builder.show();

    }

    public void dialog2()
    {

        final MediaPlayer mp = MediaPlayer.create(LevelOne.this, R.raw.none);
        ListView lstView = (ListView)findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(lstChat,this);
        lstView.setAdapter(adapter);
        lstView.setDivider(null);
        lstView.setDividerHeight(0);

        final CharSequence[] Q2 = {
                "Orang Terdekat Anda", "Orang Lain", "Diri Anda Sendiri"
        };


        final AlertDialog.Builder alder = new AlertDialog.Builder(this,R.style.MyDialogTheme);
        alder.setTitle("");
        alder.setItems(Q2, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (Q2[i]=="Orang Terdekat Anda")
                {


                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            AlertDialog.Builder aldia= new AlertDialog.Builder(LevelOne.this,R.style.MyDialogTheme);
                            aldia.setTitle("From : DeepSpeak Crop");
                            aldia.setIcon(R.mipmap.ic_launcher_round);
                            aldia.setMessage(Html.fromHtml("<font color='#EAE9E9'>Kami ingin memberitahukan bahwa client anda telah terbunuh</font>"));
                            aldia.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(LevelOne.this,QuestActivity.class);
                                    startActivity(intent);
                                    LevelOne.this.finish();
                                }
                            });
                            AlertDialog aldiaer = aldia.create();
                            aldiaer.show();


                        }
                    }, 500); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(LevelOne.this,QuestActivity.class);
                            startActivity(intent);
                            LevelOne.this.finish();
                        }
                    }, 2500); // Millisecond 1000 = 1 sec


                    isi="3";
                    alur="2a";
                } else

                if (Q2[i]=="Orang Lain")
                {


                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {


                            AlertDialog.Builder aldia= new AlertDialog.Builder(LevelOne.this,R.style.MyDialogTheme);
                            aldia.setTitle("From : DeepSpeak Crop");
                            aldia.setIcon(R.mipmap.ic_launcher_round);
                            aldia.setMessage(Html.fromHtml("<font color='#EAE9E9'>Kami ingin memberitahukan bahwa client anda telah terbunuh</font>"));
                            aldia.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(LevelOne.this,QuestActivity.class);
                                    startActivity(intent);
                                    LevelOne.this.finish();
                                }
                            });
                            AlertDialog aldiaer = aldia.create();
                            aldiaer.show();


                        }
                    }, 500); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(LevelOne.this,QuestActivity.class);
                            startActivity(intent);
                            LevelOne.this.finish();
                        }
                    }, 2500); // Millisecond 1000 = 1 sec


                    isi="3";
                    alur="2b";
                } else

                if (Q2[i]=="Diri Anda Sendiri")
                {

                    ListView lstView = (ListView)findViewById(R.id.listView);
                    CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                    lstView.setAdapter(adapter);
                    lstView.setDivider(null);
                    lstView.setDividerHeight(0);

                    e1.setEnabled(false);
                    e1.setHint("Tunggu");

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Saya akan lebih memilih menyelamatkan diri saya sendiri",false));
                            lstChat.add(new ChatModel("ding dong anda benar, ini baru neysa yang saya tau, seorang yang cantik dan egois",true));

                        }
                    }, 600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Padahal saya pikir anda akan berpura-pura peduli terhadap orang lain, sayang sekali",true));

                        }
                    }, 2600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("awal yang baik bagi anda, Mari menuju pertanyaan kedua ",true));

                        }
                    }, 4600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Dari sekian banyak accessories, bagian mana yang paling anda suka?",true));

                        }
                    }, 6600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            e1.setEnabled(true);
                            e1.setHint("Jawab");
                        }
                    }, 8600); // Millisecond 1000 = 1 sec

                    isi="3";
                    alur="2c";

                }
            }
        });
        AlertDialog builder = alder.create();
        builder.show();

    }

    public void dialog3() {
        final MediaPlayer mp = MediaPlayer.create(LevelOne.this, R.raw.none);
        ListView lstView = (ListView)findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(lstChat,this);
        lstView.setAdapter(adapter);
        lstView.setDivider(null);
        lstView.setDividerHeight(0);

            final CharSequence[] Q3 = {
                    "Tidak Suka", "Kalung", "Mana Saja"
            };


            AlertDialog.Builder alder = new AlertDialog.Builder(this,R.style.MyDialogTheme);
            alder.setTitle("");
            alder.setItems(Q3, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (Q3[i]=="Tidak Suka")
                    {

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                AlertDialog.Builder aldia= new AlertDialog.Builder(LevelOne.this,R.style.MyDialogTheme);
                                aldia.setTitle("From : DeepSpeak Crop");
                                aldia.setIcon(R.mipmap.ic_launcher_round);
                                aldia.setMessage(Html.fromHtml("<font color='#EAE9E9'>Kami ingin memberitahukan bahwa client anda telah terbunuh</font>"));
                                aldia.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent intent = new Intent(LevelOne.this,QuestActivity.class);
                                        startActivity(intent);
                                        LevelOne.this.finish();
                                    }
                                });
                                AlertDialog aldiaer = aldia.create();
                                aldiaer.show();


                            }
                        }, 600); // Millisecond 1000 = 1 sec

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(LevelOne.this,QuestActivity.class);
                                startActivity(intent);
                                LevelOne.this.finish();
                            }
                        }, 2600); // Millisecond 1000 = 1 sec

                        isi="4";

                    } else

                    if (Q3[i]=="Kalung")
                    {

                        ListView lstView = (ListView)findViewById(R.id.listView);
                        CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                        lstView.setAdapter(adapter);
                        lstView.setDivider(null);
                        lstView.setDividerHeight(0);


                        e1.setEnabled(false);
                        e1.setHint("Tunggu");
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                ListView lstView = (ListView)findViewById(R.id.listView);
                                CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                                lstView.setAdapter(adapter);
                                lstView.setDivider(null);
                                lstView.setDividerHeight(0);
                                mp.start();
                                lstChat.add(new ChatModel("Saya meyukai kalung, karena saya pikir accessories itu adalah yang paling dekat dengan hati",false));
                                lstChat.add(new ChatModel("Romantis sekali!, Tapi perkataan manis itu sudah saya dengar berkali-kali",true));

                            }
                        }, 600); // Millisecond 1000 = 1 sec

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                ListView lstView = (ListView)findViewById(R.id.listView);
                                CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                                lstView.setAdapter(adapter);
                                lstView.setDivider(null);
                                lstView.setDividerHeight(0);
                                mp.start();
                                lstChat.add(new ChatModel("Sehingga saya bosan dan ingin muntah",true));

                            }
                        }, 2600); // Millisecond 1000 = 1 sec

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                ListView lstView = (ListView)findViewById(R.id.listView);
                                CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                                lstView.setAdapter(adapter);
                                lstView.setDivider(null);
                                lstView.setDividerHeight(0);
                                mp.start();
                                lstChat.add(new ChatModel("hmm, maaf jika saya sedikit tidak sopan, saya hanya terbawa emosi",true));

                            }
                        }, 4600); // Millisecond 1000 = 1 sec

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                ListView lstView = (ListView)findViewById(R.id.listView);
                                CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                                lstView.setAdapter(adapter);
                                lstView.setDivider(null);
                                lstView.setDividerHeight(0);
                                mp.start();
                                lstChat.add(new ChatModel("Langsung saja kepertanyaan ke-3",true));

                            }
                        }, 6600); // Millisecond 1000 = 1 sec

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                ListView lstView = (ListView)findViewById(R.id.listView);
                                CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                                lstView.setAdapter(adapter);
                                lstView.setDivider(null);
                                lstView.setDividerHeight(0);
                                mp.start();
                                lstChat.add(new ChatModel("Apakah anda pernah bertengkar dengan teman dekat anda?",true));

                            }
                        }, 8600); // Millisecond 1000 = 1 sec

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                e1.setEnabled(true);
                                e1.setHint("Jawab");
                            }
                        }, 8601); // Millisecond 1000 = 1 sec

                        isi="4";

                    } else

                    if (Q3[i]=="Mana Saja")
                    {

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {


                                AlertDialog.Builder aldia= new AlertDialog.Builder(LevelOne.this,R.style.MyDialogTheme);
                                aldia.setTitle("From : DeepSpeak Crop");
                                aldia.setIcon(R.mipmap.ic_launcher_round);
                                aldia.setMessage(Html.fromHtml("<font color='#EAE9E9'>Kami ingin memberitahukan bahwa client anda telah terbunuh</font>"));
                                aldia.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent intent = new Intent(LevelOne.this,QuestActivity.class);
                                        startActivity(intent);
                                        LevelOne.this.finish();
                                    }
                                });
                                AlertDialog aldiaer = aldia.create();
                                aldiaer.show();


                            }
                        }, 500); // Millisecond 1000 = 1 sec

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(LevelOne.this,QuestActivity.class);
                                startActivity(intent);
                                LevelOne.this.finish();
                            }
                        }, 2500); // Millisecond 1000 = 1 sec


                        isi="4";

                    }
                }
            });
            AlertDialog builder = alder.create();
            builder.show();
        }


    public void dialog4() {
        final MediaPlayer mp = MediaPlayer.create(LevelOne.this, R.raw.none);
        ListView lstView = (ListView)findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(lstChat,this);
        lstView.setAdapter(adapter);
        lstView.setDivider(null);
        lstView.setDividerHeight(0);


        final CharSequence[] Q3 = {
                "Pernah", "Tidak Pernah", "Tidak Mungkin"
        };


        AlertDialog.Builder alder = new AlertDialog.Builder(this,R.style.MyDialogTheme);
        alder.setTitle("");
        alder.setItems(Q3, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (Q3[i]=="Tidak Pernah")
                {


                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {


                            AlertDialog.Builder aldia= new AlertDialog.Builder(LevelOne.this,R.style.MyDialogTheme);
                            aldia.setTitle("From : DeepSpeak Crop");
                            aldia.setIcon(R.mipmap.ic_launcher_round);
                            aldia.setMessage(Html.fromHtml("<font color='#EAE9E9'>Kami ingin memberitahukan bahwa client anda telah terbunuh</font>"));
                            aldia.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(LevelOne.this,QuestActivity.class);
                                    startActivity(intent);
                                    LevelOne.this.finish();
                                }
                            });
                            AlertDialog aldiaer = aldia.create();
                            aldiaer.show();

                        }
                    }, 500); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(LevelOne.this,QuestActivity.class);
                            startActivity(intent);
                            LevelOne.this.finish();
                        }
                    }, 2500); // Millisecond 1000 = 1 sec

                    isi="5";

                } else

                if (Q3[i]=="Pernah")
                {

                    ListView lstView = (ListView)findViewById(R.id.listView);
                    CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                    lstView.setAdapter(adapter);
                    lstView.setDivider(null);
                    lstView.setDividerHeight(0);

                    e1.setEnabled(false);
                    e1.setHint("Tunggu");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Semua orang pasti pernah bertengkar dengan orang lain, apalagi dengan teman dekat",false));
                            lstChat.add(new ChatModel("Aduh mungkin pertanyaan saya terlalu mudah untuk dijawab, apa mungkin teman dekat anda itu adalah yang saya bunuh sebelumnya?",true));

                        }
                    }, 600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("haha maaf, saya hanya teringat raut wajah mereka saat mereka akan mati, begitu menggairahkan",true));

                        }
                    }, 2600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Jika anda ingin tersenyum, tidak masalah, karena mungkin hari ini adalah kesempatan terakhir anda untuk tersenyum",true));

                        }
                    }, 4600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Masih banyak pertanyaan yang menunggu, relax lah sejenak",true));

                        }
                    }, 6600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Pertanyaan kali ini sedikit menarik, Mana yang kamu pilih Damian Atau Egiw?",true));

                        }
                    }, 8600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            e1.setEnabled(true);
                            e1.setHint("Jawab");
                        }
                    }, 8601); // Millisecond 1000 = 1 sec



                    isi="5";

                } else

                if (Q3[i]=="Tidak Mungkin")
                {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {


                            AlertDialog.Builder aldia= new AlertDialog.Builder(LevelOne.this,R.style.MyDialogTheme);
                            aldia.setTitle("From : DeepSpeak Crop");
                            aldia.setIcon(R.mipmap.ic_launcher_round);
                            aldia.setMessage(Html.fromHtml("<font color='#EAE9E9'>Kami ingin memberitahukan bahwa client anda telah terbunuh</font>"));
                            aldia.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(LevelOne.this,QuestActivity.class);
                                    startActivity(intent);
                                    LevelOne.this.finish();
                                }
                            });
                            AlertDialog aldiaer = aldia.create();
                            aldiaer.show();


                        }
                    }, 500); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(LevelOne.this,QuestActivity.class);
                            startActivity(intent);
                            LevelOne.this.finish();
                        }
                    }, 2500); // Millisecond 1000 = 1 sec

                    isi="5";

                }
            }
        });
        AlertDialog builder = alder.create();
        builder.show();
    }


    public void dialog5() {
        final MediaPlayer mp = MediaPlayer.create(LevelOne.this, R.raw.none);
        ListView lstView = (ListView)findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(lstChat,this);
        lstView.setAdapter(adapter);
        lstView.setDivider(null);
        lstView.setDividerHeight(0);

        final CharSequence[] Q3 = {
                "Damian", "Egiw", "Tidak Keduanya"
        };


        AlertDialog.Builder alder = new AlertDialog.Builder(this,R.style.MyDialogTheme);
        alder.setTitle("");
        alder.setItems(Q3, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (Q3[i]=="Damian")
                {

                    ListView lstView = (ListView)findViewById(R.id.listView);
                    CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                    lstView.setAdapter(adapter);
                    lstView.setDivider(null);
                    lstView.setDividerHeight(0);

                    e1.setEnabled(false);
                    e1.setHint("Tunggu");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Saya memilih damian karena dia orang yang baik",false));
                            lstChat.add(new ChatModel("Apakah itu benar?, saya sedikit terkejut, mungkin saya akan menyesali ini setelah berakhir",true));

                        }
                    }, 600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Tapi semuanya sudah terlanjur, meja sudah dibalik. Ah sebentar saya harus mengurus sesuatu, saya akan kembali dalam 15 detik",true));

                        }
                    }, 2600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("terimakasih, karena sudah menunggu, saya kira anda akan kabur, tapi itu percuma, karena saya selalu berada didekat anda",true));

                        }
                    }, 17600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("padahal waktu kita bersama itu menyenangkan ya?, tapi harus berakhir seperti ini, sudahlah.",true));

                        }
                    }, 19600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Saatnya pertanyaan berikutnya",true));

                        }
                    }, 21600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Siapa nama dibawah ini yang bukan teman anda?, saya hanya ingin memastikan, karena saya mencurigai sesuatu",true));

                        }
                    }, 23600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            e1.setEnabled(true);
                            e1.setHint("Jawab");
                        }
                    }, 23601); // Millisecond 1000 = 1 sec

                    isi="6";

                } else

                if (Q3[i]=="Egiw")
                {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {


                            AlertDialog.Builder aldia= new AlertDialog.Builder(LevelOne.this,R.style.MyDialogTheme);
                            aldia.setTitle("From : DeepSpeak Crop");
                            aldia.setIcon(R.mipmap.ic_launcher_round);
                            aldia.setMessage(Html.fromHtml("<font color='#EAE9E9'>Kami ingin memberitahukan bahwa client anda telah terbunuh</font>"));
                            aldia.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(LevelOne.this,QuestActivity.class);
                                    startActivity(intent);
                                    LevelOne.this.finish();
                                }
                            });
                            AlertDialog aldiaer = aldia.create();
                            aldiaer.show();


                        }
                    }, 500); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(LevelOne.this,QuestActivity.class);
                            startActivity(intent);
                            LevelOne.this.finish();
                        }
                    }, 2500); // Millisecond 1000 = 1 sec

                    isi="6";

                } else

                if (Q3[i]=="Tidak Keduanya")
                {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {


                            AlertDialog.Builder aldia= new AlertDialog.Builder(LevelOne.this,R.style.MyDialogTheme);
                            aldia.setTitle("From : DeepSpeak Crop");
                            aldia.setIcon(R.mipmap.ic_launcher_round);
                            aldia.setMessage(Html.fromHtml("<font color='#EAE9E9'>Kami ingin memberitahukan bahwa client anda telah terbunuh</font>"));
                            aldia.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(LevelOne.this,QuestActivity.class);
                                    startActivity(intent);
                                    LevelOne.this.finish();
                                }
                            });
                            AlertDialog aldiaer = aldia.create();
                            aldia.show();


                        }
                    }, 500); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(LevelOne.this,QuestActivity.class);
                            startActivity(intent);
                            LevelOne.this.finish();
                        }
                    }, 2500); // Millisecond 1000 = 1 sec


                    isi="6";

                }
            }
        });
        AlertDialog builder = alder.create();
        builder.show();
    }


    public void dialog6() {
        final MediaPlayer mp = MediaPlayer.create(LevelOne.this, R.raw.none);
        ListView lstView = (ListView)findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(lstChat,this);
        lstView.setAdapter(adapter);
        lstView.setDivider(null);
        lstView.setDividerHeight(0);

        final CharSequence[] Q3 = {
                "Egiw", "Demian", "Dewi"
        };


        AlertDialog.Builder alder = new AlertDialog.Builder(this,R.style.MyDialogTheme);
        alder.setTitle("");
        alder.setItems(Q3, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (Q3[i]=="Egiw")
                {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {


                            AlertDialog.Builder aldia= new AlertDialog.Builder(LevelOne.this,R.style.MyDialogTheme);
                            aldia.setTitle("From : DeepSpeak Crop");
                            aldia.setIcon(R.mipmap.ic_launcher_round);
                            aldia.setMessage(Html.fromHtml("<font color='#EAE9E9'>Kami ingin memberitahukan bahwa client anda telah terbunuh</font>"));
                            aldia.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(LevelOne.this,QuestActivity.class);
                                    startActivity(intent);
                                    LevelOne.this.finish();
                                }
                            });
                            AlertDialog aldiaer = aldia.create();
                            aldiaer.show();


                        }
                    }, 500); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(LevelOne.this,QuestActivity.class);
                            startActivity(intent);
                            LevelOne.this.finish();
                        }
                    }, 2500); // Millisecond 1000 = 1 sec


                    isi="7";

                } else

                if (Q3[i]=="Demian")
                {

                    ListView lstView = (ListView)findViewById(R.id.listView);
                    CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                    lstView.setAdapter(adapter);
                    lstView.setDivider(null);
                    lstView.setDividerHeight(0);

                    e1.setEnabled(false);
                    e1.setHint("Tunggu");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Saya tidak mengenal orang yang bernama Demian",false));
                            lstChat.add(new ChatModel("Sial, anda berhasil menjawab lagi, tapi tentu saja karena pertanyaan itu mudah",true));

                        }
                    }, 600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Saya hanya bermain dengan anda sebelum saya memberikan pertanyaan yang sesungguhnya",true));
                        }
                    }, 2600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Kali ini saya akan beralih ke pertanyaan tentang sejarah",true));

                        }
                    }, 4600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Pasti anda tau kisah Romeo dan Juliet bukan?, oleh karena itu pertanyaan saya adalah siapa yang harusnya mati dalam kisah tersebut?",true));

                        }
                    }, 6600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            e1.setEnabled(true);
                            e1.setHint("Jawab");
                        }
                    }, 6601); // Millisecond 1000 = 1 sec

                    isi="7";

                } else

                if (Q3[i]=="Dewi")
                {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {


                            AlertDialog.Builder aldia= new AlertDialog.Builder(LevelOne.this,R.style.MyDialogTheme);
                            aldia.setTitle("From : DeepSpeak Crop");
                            aldia.setIcon(R.mipmap.ic_launcher_round);
                            aldia.setMessage(Html.fromHtml("<font color='#EAE9E9'>Kami ingin memberitahukan bahwa client anda telah terbunuh</font>"));
                            aldia.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(LevelOne.this,QuestActivity.class);
                                    startActivity(intent);
                                    LevelOne.this.finish();
                                }
                            });
                            AlertDialog aldiaer = aldia.create();
                            aldiaer.show();


                        }
                    }, 500); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(LevelOne.this,QuestActivity.class);
                            startActivity(intent);
                            LevelOne.this.finish();
                        }
                    }, 2500); // Millisecond 1000 = 1 sec


                    isi="7";

                }
            }
        });
        AlertDialog builder = alder.create();
       builder.show();
    }

    public void dialog7() {
        final MediaPlayer mp = MediaPlayer.create(LevelOne.this, R.raw.none);
        ListView lstView = (ListView)findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(lstChat,this);
        lstView.setAdapter(adapter);
        lstView.setDivider(null);
        lstView.setDividerHeight(0);

        final CharSequence[] Q3 = {
                "Romeo", "Juliet", "Keluarga"
        };

        AlertDialog.Builder alder = new AlertDialog.Builder(this,R.style.MyDialogTheme);
        alder.setTitle("");
        alder.setItems(Q3, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (Q3[i]=="Romeo")
                {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            AlertDialog.Builder aldia= new AlertDialog.Builder(LevelOne.this,R.style.MyDialogTheme);
                            aldia.setTitle("From : DeepSpeak Crop");
                            aldia.setIcon(R.mipmap.ic_launcher_round);
                            aldia.setMessage(Html.fromHtml("<font color='#EAE9E9'>Kami ingin memberitahukan bahwa client anda telah terbunuh</font>"));
                            aldia.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(LevelOne.this,QuestActivity.class);
                                    startActivity(intent);
                                    LevelOne.this.finish();
                                }
                            });
                            AlertDialog aldiaer = aldia.create();
                            aldiaer.show();

                        }
                    }, 500); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(LevelOne.this,QuestActivity.class);
                            startActivity(intent);
                            LevelOne.this.finish();
                        }
                    }, 2500); // Millisecond 1000 = 1 sec

                    isi="8";

                } else

                if (Q3[i]=="Keluarga")
                {

                    ListView lstView = (ListView)findViewById(R.id.listView);
                    CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                    lstView.setAdapter(adapter);
                    lstView.setDivider(null);
                    lstView.setDividerHeight(0);

                    e1.setEnabled(false);
                    e1.setHint("Tunggu");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Keluarga, saya yakin mereka mati karena tidak bisa bersatu akibat perbedaan status",false));
                            lstChat.add(new ChatModel("Untuk wanita seperti anda, anda memiliki jawaban yang menarik",true));

                        }
                    }, 600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Tapi bagi saya, kisah mereka tidak lebih dari kisah 2 orang bodoh yang putus asa",true));

                        }
                    }, 2600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Kalau saya menjadi romeo, saya akan membunuh juliet agar tidak ada orang lain yang bisa memilikinya",true));

                        }
                    }, 4600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Baiklah, pertanyaan selanjutnya cukup mudah, berapa pertanyaan yang telah saya lontarkan dari awal hingga sekarang?",true));

                        }
                    }, 6600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("(Jangan Scroll Chat ini atau saya akan rusak histori percakapan kita dari awal)",true));

                        }
                    }, 8600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            e1.setEnabled(true);
                            e1.setHint("Jawab");
                        }
                    }, 8601); // Millisecond 1000 = 1 sec

                    isi="8";

                } else

                if (Q3[i]=="Juliet")
                {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            AlertDialog.Builder aldia= new AlertDialog.Builder(LevelOne.this,R.style.MyDialogTheme);
                            aldia.setTitle("From : DeepSpeak Crop");
                            aldia.setIcon(R.mipmap.ic_launcher_round);
                            aldia.setMessage(Html.fromHtml("<font color='#EAE9E9'>Kami ingin memberitahukan bahwa client anda telah terbunuh</font>"));
                            aldia.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(LevelOne.this,QuestActivity.class);
                                    startActivity(intent);
                                    LevelOne.this.finish();
                                }
                            });
                            AlertDialog aldiaer = aldia.create();
                            aldia.show();

                        }
                    }, 500); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(LevelOne.this,QuestActivity.class);
                            startActivity(intent);
                            LevelOne.this.finish();
                        }
                    }, 2500); // Millisecond 1000 = 1 sec

                    isi="8";

                }
            }
        });
        AlertDialog builder = alder.create();
        builder.show();
    }

    public void dialog8() {
        final MediaPlayer mp = MediaPlayer.create(LevelOne.this, R.raw.none);
        ListView lstView = (ListView)findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(lstChat,this);
        lstView.setAdapter(adapter);
        lstView.setDivider(null);
        lstView.setDividerHeight(0);

        final CharSequence[] Q3 = {
                "7", "12", "10"
        };


        AlertDialog.Builder alder = new AlertDialog.Builder(this,R.style.MyDialogTheme);
        alder.setTitle("");
        alder.setItems(Q3, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (Q3[i]=="7")
                {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            AlertDialog.Builder aldia= new AlertDialog.Builder(LevelOne.this,R.style.MyDialogTheme);
                            aldia.setTitle("From : DeepSpeak Crop");
                            aldia.setIcon(R.mipmap.ic_launcher_round);
                            aldia.setMessage(Html.fromHtml("<font color='#EAE9E9'>Kami ingin memberitahukan bahwa client anda telah terbunuh</font>"));
                            aldia.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(LevelOne.this,QuestActivity.class);
                                    startActivity(intent);
                                    LevelOne.this.finish();
                                }
                            });
                            AlertDialog aldiaer = aldia.create();
                            aldiaer.show();


                        }
                    }, 500); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(LevelOne.this,QuestActivity.class);
                            startActivity(intent);
                            LevelOne.this.finish();
                        }
                    }, 2500); // Millisecond 1000 = 1 sec

                    isi="akhir";

                } else

                if (Q3[i]=="12")
                {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {


                            AlertDialog.Builder aldia= new AlertDialog.Builder(LevelOne.this,R.style.MyDialogTheme);
                            aldia.setTitle("From : DeepSpeak Crop");
                            aldia.setIcon(R.mipmap.ic_launcher_round);
                            aldia.setMessage(Html.fromHtml("<font color='#EAE9E9'>Kami ingin memberitahukan bahwa client anda telah terbunuh</font>"));
                            aldia.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(LevelOne.this,QuestActivity.class);
                                    startActivity(intent);
                                    LevelOne.this.finish();
                                }
                            });
                            AlertDialog aldiaer = aldia.create();
                            aldiaer.show();


                        }
                    }, 500); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(LevelOne.this,QuestActivity.class);
                            startActivity(intent);
                            LevelOne.this.finish();
                        }
                    }, 2500); // Millisecond 1000 = 1 sec

                    isi="akhir";

                } else

                if (Q3[i]=="10")
                {

                    ListView lstView = (ListView)findViewById(R.id.listView);
                    CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                    lstView.setAdapter(adapter);
                    lstView.setDivider(null);
                    lstView.setDividerHeight(0);

                    e1.setEnabled(false);
                    e1.setHint("Tunggu");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Saya mengigat ada 10 pertanyaan yang sudah anda tanyakan",false));
                            lstChat.add(new ChatModel("Hebat!, seorang mahasiswi memang hebat, memikirkan hal ini mungkin lebih mudah daripada memikirkan perasaan orang lain betul?",true));

                        }
                    }, 600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Sejujurnya saya sudah bosan dengan permainan ini, jadi saya akan memberikan pertanyaan terakhir",true));

                        }
                    }, 2600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Pertanyaan ini yang menentukan keselamatan anda. Siapa sebenarnya saya?, jika anda benar saya akan menyerahkan diri saya ke polisi",true));

                        }
                    }, 4600); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            e1.setEnabled(true);
                            e1.setHint("Jawab");
                        }
                    }, 4601); // Millisecond 1000 = 1 sec

                    isi="9";
                }
            }
        });
        AlertDialog builder = alder.create();
        builder.show();
    }

    public void dialog9() {
        AlertDialog.Builder aldia= new AlertDialog.Builder(LevelOne.this,R.style.MyDialogTheme);
        aldia.setTitle("Jawaban:");
        final EditText input = new EditText(LevelOne.this);
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

                if (YouEditTextValue.equals("Damian"))
                {
                    final DatabaseHelper dbHelper = new DatabaseHelper(LevelOne.this);
                    dbHelper.addUser(new User("l1"));
                    Toast.makeText(LevelOne.this, "Level Done", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LevelOne.this,QuestActivity.class);
                    startActivity(intent);
                    LevelOne.this.finish();
                } else {
                    Toast.makeText(getApplicationContext(),"Misi Gagal,Client anda terbunuh dan tersangka melarikan diri",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LevelOne.this,QuestActivity.class);
                    startActivity(intent);
                    LevelOne.this.finish();
                }
            }
        });

        AlertDialog aldiaer = aldia.create();
        aldiaer.show();
    }

    @Override
    public void onBackPressed() {

    }


}

