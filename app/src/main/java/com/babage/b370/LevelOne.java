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
                lstChat.add(new ChatModel("Selamat Datang Di Acara D ChatQuiz", true));
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
                lstChat.add(new ChatModel("Jika anda salah, anda akan terbunuh", true));
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
                lstChat.add(new ChatModel("Mengerikan Bukan?", true));
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
                lstChat.add(new ChatModel("Yang cukup anda lakukan hanya membalas", true));
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
                lstChat.add(new ChatModel("dan saya tidak menerima pertanyaan", true));
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
                lstChat.add(new ChatModel("Anda Sudah Siap?", true));
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
                "Saya Siap", "Tentu, saya menunggu pertanyaanya", "Boleh"
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
                            lstChat.add(new ChatModel("Saya Siap",false));
                            lstChat.add(new ChatModel("Bagus, anda tenang sekali", true));

                        }
                    }, 700); // Millisecond 1000 = 1 sec


                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Saya ikut senang mendengarnya", true));
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
                            lstChat.add(new ChatModel("Baiklah mari kita mulai", true));

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
                            lstChat.add(new ChatModel("Pertanyaan pertama", true));
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
                            lstChat.add(new ChatModel("Apakah Hitler benci binatang?", true));
                        }
                    }, 8000); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                           e1.setEnabled(true);
                           e1.setHint("Jawab");
                        }
                    }, 8100); // Millisecond 1000 = 1 sec




                    isi="2";
                    alur="1a";
                } else

                if (Q1[i]=="Tentu, saya menunggu pertanyaanya")
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
                            lstChat.add(new ChatModel("Tentu, saya menunggu pertanyaanya",false));
                            lstChat.add(new ChatModel("Wah Anda bersemangat sekali", true));
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
                            lstChat.add(new ChatModel("Berarti anda sudah siap mati", true));
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
                            lstChat.add(new ChatModel("Baiklah Mari kita mulai", true));

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
                            lstChat.add(new ChatModel("Pertanyaan pertama", true));
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
                            lstChat.add(new ChatModel("Apakah Hitler benci binatang?", true));
                        }
                    }, 10000); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            e1.setEnabled(true);
                            e1.setHint("Jawab");
                        }
                    }, 10100); // Millisecond 1000 = 1 sec


                    isi="2";
                    alur="1b";

                } else

                if (Q1[i]=="Boleh")
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
                            lstChat.add(new ChatModel("Boleh",false));
                            lstChat.add(new ChatModel("Anda kurang bersemangat", true));
                        }
                    }, 700); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Pasti karena anda selalu sendirian", true));
                        }
                    }, 2700); // Millisecond 1000 = 1 sec


                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Baiklah Mari kita mulai", true));

                        }
                    }, 4700); // Millisecond 1000 = 1 sec


                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Pertanyaan pertama", true));
                        }
                    }, 6700); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Apakah Hitler benci binatang?", true));
                        }
                    }, 8700); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            e1.setEnabled(true);
                            e1.setHint("Jawab");
                        }
                    }, 8800); // Millisecond 1000 = 1 sec


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
                "Benci", "Tidak Peduli", "Penyayang"
        };


        AlertDialog.Builder alder = new AlertDialog.Builder(this,R.style.MyDialogTheme);
        alder.setTitle("");
        alder.setItems(Q2, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (Q2[i]=="Benci")
                {


                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            AlertDialog.Builder aldia= new AlertDialog.Builder(LevelOne.this,R.style.MyDialogTheme);
                            aldia.setTitle("From : DeepSpeak Crop");
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
                    }, 2300); // Millisecond 1000 = 1 sec


                    isi="3";
                    alur="2a";
                } else

                if (Q2[i]=="Tidak Peduli")
                {


                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {


                            AlertDialog.Builder aldia= new AlertDialog.Builder(LevelOne.this,R.style.MyDialogTheme);
                            aldia.setTitle("From : DeepSpeak Crop");
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
                    }, 2300); // Millisecond 1000 = 1 sec


                    isi="3";
                    alur="2b";
                } else

                if (Q2[i]=="Penyayang")
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
                            lstChat.add(new ChatModel("Penyayang",false));
                            lstChat.add(new ChatModel("ding dong anda benar",true));

                        }
                    }, 4300); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Selamat , kami tidak jadi meledakan rumah anda",true));

                        }
                    }, 6300); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Baiklah pertanyaan selanjutnya",true));

                        }
                    }, 8300); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Tahun berapa benito mussolini ke swiss?",true));

                        }
                    }, 10300); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            e1.setEnabled(true);
                            e1.setHint("Jawab");
                        }
                    }, 10400); // Millisecond 1000 = 1 sec

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
                    "1900", "1902", "1920"
            };


            AlertDialog.Builder alder = new AlertDialog.Builder(this,R.style.MyDialogTheme);
            alder.setTitle("");
            alder.setItems(Q3, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (Q3[i]=="1900")
                    {

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                AlertDialog.Builder aldia= new AlertDialog.Builder(LevelOne.this,R.style.MyDialogTheme);
                                aldia.setTitle("From : DeepSpeak Crop");
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

                    } else

                    if (Q3[i]=="1902")
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
                                lstChat.add(new ChatModel("1902",false));
                                lstChat.add(new ChatModel("sepertinya anda penyuka sejarah",true));

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
                                lstChat.add(new ChatModel("Padahal anda pemalas",true));

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
                                lstChat.add(new ChatModel("tenang masih tersisa 6 pertanyaan lagi",true));

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
                                lstChat.add(new ChatModel("pertanyaan ke 3",true));

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
                                lstChat.add(new ChatModel("Berapa Jumlah Saudara Genghis khan?",true));

                            }
                        }, 10000); // Millisecond 1000 = 1 sec

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                e1.setEnabled(true);
                                e1.setHint("Jawab");
                            }
                        }, 10100); // Millisecond 1000 = 1 sec

                        isi="4";

                    } else

                    if (Q3[i]=="1920")
                    {

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {


                                AlertDialog.Builder aldia= new AlertDialog.Builder(LevelOne.this,R.style.MyDialogTheme);
                                aldia.setTitle("From : DeepSpeak Crop");
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
                "5", "8", "2"
        };


        AlertDialog.Builder alder = new AlertDialog.Builder(this,R.style.MyDialogTheme);
        alder.setTitle("");
        alder.setItems(Q3, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (Q3[i]=="2")
                {


                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {


                            AlertDialog.Builder aldia= new AlertDialog.Builder(LevelOne.this,R.style.MyDialogTheme);
                            aldia.setTitle("From : DeepSpeak Crop");
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

                if (Q3[i]=="5")
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
                            lstChat.add(new ChatModel("5",false));
                            lstChat.add(new ChatModel("Saya tidak menyangka",true));

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
                            lstChat.add(new ChatModel("Anda bisa sejauh ini",true));

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
                            lstChat.add(new ChatModel("Masih tersisa 5 pertanyaan lagi",true));

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
                            lstChat.add(new ChatModel("Jangan senang dulu",true));

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
                            lstChat.add(new ChatModel("Pertanyaan berikutnya, berapa korban yang mati akibat chat ini?",true));

                        }
                    }, 10000); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            e1.setEnabled(true);
                            e1.setHint("Jawab");
                        }
                    }, 10100); // Millisecond 1000 = 1 sec



                    isi="5";

                } else

                if (Q3[i]=="8")
                {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {


                            AlertDialog.Builder aldia= new AlertDialog.Builder(LevelOne.this,R.style.MyDialogTheme);
                            aldia.setTitle("From : DeepSpeak Crop");
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
                    }, 2300); // Millisecond 1000 = 1 sec

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
                "3", "5", "1"
        };


        AlertDialog.Builder alder = new AlertDialog.Builder(this,R.style.MyDialogTheme);
        alder.setTitle("");
        alder.setItems(Q3, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (Q3[i]=="3")
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
                            lstChat.add(new ChatModel("3",false));
                            lstChat.add(new ChatModel("Wow, nampaknya saya sudah terkenal",true));

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
                            lstChat.add(new ChatModel("tunggu saya 15 detik",true));

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
                            lstChat.add(new ChatModel("terimakasih, karena sudah menunggu",true));

                        }
                    }, 19000); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("disini memang dingin sekali",true));

                        }
                    }, 21000); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("langsung saja",true));

                        }
                    }, 23000); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ListView lstView = (ListView)findViewById(R.id.listView);
                            CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                            lstView.setAdapter(adapter);
                            lstView.setDivider(null);
                            lstView.setDividerHeight(0);
                            mp.start();
                            lstChat.add(new ChatModel("Siapa nama dibawah ini yang bukan teman anda?",true));

                        }
                    }, 25000); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            e1.setEnabled(true);
                            e1.setHint("Jawab");
                        }
                    }, 25100); // Millisecond 1000 = 1 sec



                    isi="6";

                } else

                if (Q3[i]=="5")
                {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {


                            AlertDialog.Builder aldia= new AlertDialog.Builder(LevelOne.this,R.style.MyDialogTheme);
                            aldia.setTitle("From : DeepSpeak Crop");
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
                    }, 2300); // Millisecond 1000 = 1 sec

                    isi="6";

                } else

                if (Q3[i]=="1")
                {


                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {


                            AlertDialog.Builder aldia= new AlertDialog.Builder(LevelOne.this,R.style.MyDialogTheme);
                            aldia.setTitle("From : DeepSpeak Crop");
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
                    }, 2300); // Millisecond 1000 = 1 sec


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
                "Nina", "Frisman", "Gilar"
        };


        AlertDialog.Builder alder = new AlertDialog.Builder(this,R.style.MyDialogTheme);
        alder.setTitle("");
        alder.setItems(Q3, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (Q3[i]=="Nina")
                {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {


                            AlertDialog.Builder aldia= new AlertDialog.Builder(LevelOne.this,R.style.MyDialogTheme);
                            aldia.setTitle("From : DeepSpeak Crop");
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
                    }, 2300); // Millisecond 1000 = 1 sec


                    isi="7";

                } else

                if (Q3[i]=="Frisman")
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
                            lstChat.add(new ChatModel("Frisman",false));
                            lstChat.add(new ChatModel("Selamat, anda adalah orang pertama",true));

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
                            lstChat.add(new ChatModel("yang bisa sampai dititik ini",true));
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
                            lstChat.add(new ChatModel("Baiklah pertanyaannya akan saya persulit",true));

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
                            lstChat.add(new ChatModel("Alat apa yang saya gunakan untuk meledakan rumah anda?",true));

                        }
                    }, 8000); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            e1.setEnabled(true);
                            e1.setHint("Jawab");
                        }
                    }, 8100); // Millisecond 1000 = 1 sec

                    isi="7";

                } else

                if (Q3[i]=="Gilar")
                {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {


                            AlertDialog.Builder aldia= new AlertDialog.Builder(LevelOne.this,R.style.MyDialogTheme);
                            aldia.setTitle("From : DeepSpeak Crop");
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
                    }, 2300); // Millisecond 1000 = 1 sec


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
                "C4", "GRANAT", "BOMB LPG"
        };

        AlertDialog.Builder alder = new AlertDialog.Builder(this,R.style.MyDialogTheme);
        alder.setTitle("");
        alder.setItems(Q3, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (Q3[i]=="C4")
                {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            AlertDialog.Builder aldia= new AlertDialog.Builder(LevelOne.this,R.style.MyDialogTheme);
                            aldia.setTitle("From : DeepSpeak Crop");
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
                    }, 2300); // Millisecond 1000 = 1 sec

                    isi="8";

                } else

                if (Q3[i]=="GRANAT")
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
                            lstChat.add(new ChatModel("GRANAT",false));
                            lstChat.add(new ChatModel("Wah tanpa clue anda bisa menebak dengan benar",true));

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
                            lstChat.add(new ChatModel("Padahal bomb ditangan saya, sudah siap untuk saya lemparkan",true));

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
                            lstChat.add(new ChatModel("pertanyaan selanjutnya",true));

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
                            lstChat.add(new ChatModel("Hingga saat ini berapa jumlah pertanyaan yang saya tanyakan?",true));

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
                            lstChat.add(new ChatModel("(Jangan Scroll Chat ini atau saya akan rusak histori percakapan dari awal)",true));

                        }
                    }, 10000); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            e1.setEnabled(true);
                            e1.setHint("Jawab");
                        }
                    }, 10100); // Millisecond 1000 = 1 sec

                    isi="8";

                } else

                if (Q3[i]=="BOMB LPG")
                {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            AlertDialog.Builder aldia= new AlertDialog.Builder(LevelOne.this,R.style.MyDialogTheme);
                            aldia.setTitle("From : DeepSpeak Crop");
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
                    }, 2300); // Millisecond 1000 = 1 sec

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
                "7", "6", "9"
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
                    }, 2300); // Millisecond 1000 = 1 sec


                    isi="akhir";

                } else

                if (Q3[i]=="6")
                {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {


                            AlertDialog.Builder aldia= new AlertDialog.Builder(LevelOne.this,R.style.MyDialogTheme);
                            aldia.setTitle("From : DeepSpeak Crop");
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
                    }, 2300); // Millisecond 1000 = 1 sec

                    isi="akhir";

                } else

                if (Q3[i]=="9")
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
                            lstChat.add(new ChatModel("9",false));
                            lstChat.add(new ChatModel("Sial, Saya sudah tidak sabar ingin membunuh Anda",true));

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
                            lstChat.add(new ChatModel("Pertanyaan sekarang adalah yang menentukan keselamatan anda",true));

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
                            lstChat.add(new ChatModel("Siapa nama lengkap saya?",true));

                        }
                    }, 6000); // Millisecond 1000 = 1 sec

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            e1.setEnabled(true);
                            e1.setHint("Jawab");
                        }
                    }, 6100); // Millisecond 1000 = 1 sec

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
                    Toast.makeText(getApplicationContext(),"Misi Gagal Tersangka Melarikan diri",Toast.LENGTH_SHORT).show();
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

