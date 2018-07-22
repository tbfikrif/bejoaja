package com.babage.b370;


import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
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
        //chat pembuka
        lstChat.add(new ChatModel("Main Trove Yuk?", true));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ListView lstView = (ListView)findViewById(R.id.listView);
                CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                lstView.setAdapter(adapter);
                lstView.setDivider(null);
                lstView.setDividerHeight(0);
                mp.start();
                lstChat.add(new ChatModel("Atau Main Warframe?", true));
            }
        }, 3000); // Millisecond 1000 = 1 sec



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

                    doneSubmit();
                }


            }
        });



    }


    public void dialog1() {


        ListView lstView = (ListView)findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(lstChat,this);
        lstView.setAdapter(adapter);
        lstView.setDivider(null);
        lstView.setDividerHeight(0);

        final CharSequence[] Q1 = {
                "Trovelah!", "Warframelah!", "Dota aja"
        };


        final AlertDialog.Builder alder = new AlertDialog.Builder(this);
        alder.setTitle("Jawabanmu");
        alder.setItems(Q1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (Q1[i]=="Trovelah!")
                {

                    ListView lstView = (ListView)findViewById(R.id.listView);
                    CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                    lstView.setAdapter(adapter);
                    lstView.setDivider(null);
                    lstView.setDividerHeight(0);
                    lstChat.add(new ChatModel("Trovelah!",false));
                    lstChat.add(new ChatModel("Kamu Memang Cerdas", true));

                    isi="2";
                    alur="1a";
                } else

                if (Q1[i]=="Warframelah!")
                {
                    ListView lstView = (ListView)findViewById(R.id.listView);
                    CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                    lstView.setAdapter(adapter);
                    lstView.setDivider(null);
                    lstView.setDividerHeight(0);
                    lstChat.add(new ChatModel("Warframelah!",false));
                    lstChat.add(new ChatModel("Males ah mending nonton Starwars", true));

                    isi="2";
                    alur="1b";

                } else

                if (Q1[i]=="Dota aja")
                {
                    ListView lstView = (ListView)findViewById(R.id.listView);
                    CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                    lstView.setAdapter(adapter);
                    lstView.setDivider(null);
                    lstView.setDividerHeight(0);
                    lstChat.add(new ChatModel("Dota aja",false));
                    lstChat.add(new ChatModel("Susah Ah males", true));

                    isi="2";
                    alur="1c";

                }
            }
        });
        AlertDialog builder = alder.create();
        alder.show();




    }

    public void dialog2()
    {
        ListView lstView = (ListView)findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(lstChat,this);
        lstView.setAdapter(adapter);
        lstView.setDivider(null);
        lstView.setDividerHeight(0);

        final CharSequence[] Q2 = {
                "Main The Sims?", "Tidur Ah", "Gue ada perlu ketemu hokage"
        };


        AlertDialog.Builder alder = new AlertDialog.Builder(this);
        alder.setTitle("Jawabanmu");
        alder.setItems(Q2, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (Q2[i]=="Main The Sims?")
                {

                    ListView lstView = (ListView)findViewById(R.id.listView);
                    CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                    lstView.setAdapter(adapter);
                    lstView.setDivider(null);
                    lstView.setDividerHeight(0);

                    lstChat.add(new ChatModel("Main The Sims?",false));
                    lstChat.add(new ChatModel("Cie The Sims",true));
                    isi="3";
                    alur="2a";
                } else

                if (Q2[i]=="Tidur Ah")
                {

                    ListView lstView = (ListView)findViewById(R.id.listView);
                    CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                    lstView.setAdapter(adapter);
                    lstView.setDivider(null);
                    lstView.setDividerHeight(0);

                    lstChat.add(new ChatModel("Tidur Ah",false));
                    lstChat.add(new ChatModel("Sana Mati aja luh",true));
                    isi="3";
                    alur="2b";
                } else

                if (Q2[i]=="Gue ada perlu ketemu hokage")
                {

                    ListView lstView = (ListView)findViewById(R.id.listView);
                    CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                    lstView.setAdapter(adapter);
                    lstView.setDivider(null);
                    lstView.setDividerHeight(0);

                    lstChat.add(new ChatModel("Gue ada perlu ketemu hokage",false));
                    lstChat.add(new ChatModel("ya udah nitip salam gue sama luffy",true));
                    isi="3";
                    alur="2c";

                }
            }
        });
        AlertDialog builder = alder.create();
        alder.show();

    }

    public void dialog3() {

        ListView lstView = (ListView)findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(lstChat,this);
        lstView.setAdapter(adapter);
        lstView.setDivider(null);
        lstView.setDividerHeight(0);

        if (alur=="2a") {

            final CharSequence[] Q3 = {
                    "Apaan si ga jelas", "Kamu mengingatkan aku", "Boing2"
            };


            AlertDialog.Builder alder = new AlertDialog.Builder(this);
            alder.setTitle("Jawabanmu");
            alder.setItems(Q3, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (Q3[i]=="Apaan si ga jelas")
                    {

                        ListView lstView = (ListView)findViewById(R.id.listView);
                        CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                        lstView.setAdapter(adapter);
                        lstView.setDivider(null);
                        lstView.setDividerHeight(0);

                        lstChat.add(new ChatModel("Apaan si ga jelas",false));
                        isi="4";

                    } else

                    if (Q3[i]=="Kamu mengingatkan aku")
                    {

                        ListView lstView = (ListView)findViewById(R.id.listView);
                        CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                        lstView.setAdapter(adapter);
                        lstView.setDivider(null);
                        lstView.setDividerHeight(0);

                        lstChat.add(new ChatModel("Kamu mengingatkan aku",false));
                        isi="4";

                    } else

                    if (Q3[i]=="Boing2")
                    {

                        ListView lstView = (ListView)findViewById(R.id.listView);
                        CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                        lstView.setAdapter(adapter);
                        lstView.setDivider(null);
                        lstView.setDividerHeight(0);

                        lstChat.add(new ChatModel("_-",false));
                        isi="4";

                    }
                }
            });
            AlertDialog builder = alder.create();
            alder.show();

        } else if (alur=="2b"){

            final CharSequence[] Q3 = {
                    "Calm", "Lu Aja yang mati", "zzz"
            };


            AlertDialog.Builder alder = new AlertDialog.Builder(this);
            alder.setTitle("Jawabanmu");
            alder.setItems(Q3, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (Q3[i]=="Calm")
                    {

                        ListView lstView = (ListView)findViewById(R.id.listView);
                        CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                        lstView.setAdapter(adapter);
                        lstView.setDivider(null);
                        lstView.setDividerHeight(0);

                        lstChat.add(new ChatModel("Calm",false));
                        isi="4";

                    } else

                    if (Q3[i]=="Lu Aja yang mati")
                    {

                        ListView lstView = (ListView)findViewById(R.id.listView);
                        CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                        lstView.setAdapter(adapter);
                        lstView.setDivider(null);
                        lstView.setDividerHeight(0);

                        lstChat.add(new ChatModel("Lu Aja yang mati",false));
                        isi="4";

                    } else

                    if (Q3[i]=="zzz")
                    {

                        ListView lstView = (ListView)findViewById(R.id.listView);
                        CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                        lstView.setAdapter(adapter);
                        lstView.setDivider(null);
                        lstView.setDividerHeight(0);

                        lstChat.add(new ChatModel("zzz",false));
                        isi="4";

                    }
                }
            });
            AlertDialog builder = alder.create();
            alder.show();

        } else if (alur=="2c"){

            final CharSequence[] Q3 = {
                    "Gak nyambung bego", "luffy one piece woy", "mabuk lu?"
            };


            AlertDialog.Builder alder = new AlertDialog.Builder(this);
            alder.setTitle("Jawabanmu");
            alder.setItems(Q3, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (Q3[i]=="Gak nyambung bego")
                    {

                        ListView lstView = (ListView)findViewById(R.id.listView);
                        CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                        lstView.setAdapter(adapter);
                        lstView.setDivider(null);
                        lstView.setDividerHeight(0);

                        lstChat.add(new ChatModel("Gak nyambung bego",false));

                        isi="4";

                    } else

                    if (Q3[i]=="luffy one piece woy")
                    {

                        ListView lstView = (ListView)findViewById(R.id.listView);
                        CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                        lstView.setAdapter(adapter);
                        lstView.setDivider(null);
                        lstView.setDividerHeight(0);

                        lstChat.add(new ChatModel("luffy one piece woy",false));
                        lstChat.add(new ChatModel("Gue kirim Ke A lord juga nih",false));
                        isi="4";

                    } else

                    if (Q3[i]=="mabuk lu?")
                    {

                        ListView lstView = (ListView)findViewById(R.id.listView);
                        CustomAdapter adapter = new CustomAdapter(lstChat,LevelOne.this);
                        lstView.setAdapter(adapter);
                        lstView.setDivider(null);
                        lstView.setDividerHeight(0);

                        lstChat.add(new ChatModel("mabuk lu?",false));
                        lstChat.add(new ChatModel("gue bilangin si bapak nih ya",false));

                        isi="4";

                    }
                }
            });
            AlertDialog builder = alder.create();
            alder.show();
        }




    }

    public void doneSubmit(){

        final DatabaseHelper dbHelper = new DatabaseHelper(this);
        dbHelper.addUser(new User("l1"));
        Toast.makeText(LevelOne.this, "Level Done", Toast.LENGTH_SHORT).show();
    }

}

