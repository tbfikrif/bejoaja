package com.babage.b370;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
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

import com.bumptech.glide.Glide;
import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;
import com.shashank.sony.fancydialoglib.FancyAlertDialogListener;
import com.shashank.sony.fancydialoglib.Icon;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

import static com.babage.b370.QuestActivity.PREFS_NAME;

public class LevelTwo extends AppCompatActivity {
    public static final String EXTRA_VIDEO_URI = "com.babage.b370.VIDEO_URI";

    List<ChatModel> lstChat = new ArrayList<>();
    EditText e1;
    String isi;
    ImageView terima;
    String alur;
    int stated=0;
    int life=3;
    int answer=8;
    boolean wasItClicked1=false;
    boolean wasItClicked2=false;
    boolean wasItClicked3=false;
    boolean wasItClicked4=false;
    boolean wasItClicked5=false;
    boolean wasItClicked6=false;
    boolean wasItClicked7=false;
    boolean wasItClicked8=false;
    SharedPreferences prefs;

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
        prefs = this.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

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
        e1.setHint("Chat Tidak Bekerja!");
        e1.setEnabled(false);
        final Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        final Dialog dialog= new Dialog(LevelTwo.this,android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        final MediaPlayer pc = MediaPlayer.create(LevelTwo.this, R.raw.phonecell);
        final MediaPlayer wm = MediaPlayer.create(LevelTwo.this, R.raw.woman_scream);



        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int selectedItem = lstView.getPositionForView(view);
                if (selectedItem==5){

                    if (wasItClicked1==false) {

                        wasItClicked1=true;
                        answer--;
                        Toasty.success(LevelTwo.this,answer+" petunjuk tersisa.", Toast.LENGTH_SHORT,true).show();

                    }else {

                        Toasty.success(LevelTwo.this,"Petunjuk Sudah Dipilih", Toast.LENGTH_SHORT,true).show();

                    }



                } else if(position==18){

                    if (wasItClicked2==false) {

                        // -- Open Image --
                        ImageViewDialog(R.drawable.lv2_gedung);
                        // ----

                        wasItClicked2=true;
                        answer--;
                        Toasty.success(LevelTwo.this,answer+" petunjuk tersisa.", Toast.LENGTH_SHORT,true).show();

                    } else {
                        // -- Open Image --
                        ImageViewDialog(R.drawable.lv2_gedung);
                        // ----

                        Toasty.success(LevelTwo.this,"Petunjuk Sudah Dipilih", Toast.LENGTH_SHORT,true).show();

                    }


                } else if(position==56){

                    if (wasItClicked3==false) {

                        wasItClicked3=true;
                        answer--;
                        Toasty.success(LevelTwo.this,answer+" petunjuk tersisa.", Toast.LENGTH_SHORT,true).show();

                    }else {

                        Toasty.success(LevelTwo.this,"Petunjuk Sudah Dipilih", Toast.LENGTH_SHORT,true).show();
                    }

                } else if(position==58){

                    if (wasItClicked4==false) {


                        // -- Open Image --
                        ImageViewDialog(R.drawable.lv2_reuni);
                        // ----

                        wasItClicked4=true;
                        answer--;
                        Toasty.success(LevelTwo.this,answer+" petunjuk tersisa.", Toast.LENGTH_SHORT,true).show();

                    } else {

                        // -- Open Image --
                        ImageViewDialog(R.drawable.lv2_reuni);
                        // ----

                        Toasty.success(LevelTwo.this,"Petunjuk Sudah Dipilih", Toast.LENGTH_SHORT,true).show();

                    }


                }else if(position==62){


                    if (wasItClicked5==false) {

                        wasItClicked5=true;
                        answer--;
                        Toasty.success(LevelTwo.this,answer+" petunjuk tersisa.", Toast.LENGTH_SHORT,true).show();

                    } else {
                        Toasty.success(LevelTwo.this,"Petunjuk Sudah Dipilih", Toast.LENGTH_SHORT,true).show();

                    }

                } else if(position==74){

                    if (wasItClicked6==false) {

                        final MediaPlayer mpChat = MediaPlayer.create(LevelTwo.this, R.raw.woman_scream);
                        mpChat.start();

                        wasItClicked6=true;
                        answer--;
                        Toasty.success(LevelTwo.this,answer+" petunjuk tersisa.", Toast.LENGTH_SHORT,true).show();

                    } else {

                        final MediaPlayer mpChat = MediaPlayer.create(LevelTwo.this, R.raw.woman_scream);
                        mpChat.start();
                        Toasty.success(LevelTwo.this,"Petunjuk Sudah Dipilih", Toast.LENGTH_SHORT,true).show();

                    }

                }else if(position==77){

                    if (wasItClicked7==false) {


                        // -- Play Video --
                        Intent intent = new Intent(LevelTwo.this, VideoPlayer.class);
                        intent.putExtra(EXTRA_VIDEO_URI, "https://www.dropbox.com/s/pkme6prg3x75ufa/lv2_video.mp4?dl=1");
                        startActivity(intent);

                        wasItClicked7=true;
                        answer--;
                        Toasty.success(LevelTwo.this,answer+" petunjuk tersisa.", Toast.LENGTH_SHORT,true).show();

                    } else {
                        // -- Play Video --
                        Intent intent = new Intent(LevelTwo.this, VideoPlayer.class);
                        intent.putExtra(EXTRA_VIDEO_URI, "https://www.dropbox.com/s/pkme6prg3x75ufa/lv2_video.mp4?dl=1");
                        startActivity(intent);
                        Toasty.success(LevelTwo.this,"Petunjuk Sudah Dipilih", Toast.LENGTH_SHORT,true).show();


                    }


                } else if(position==78){

                    if (wasItClicked8==false) {


                        stated=1;
                        // -- Open Image --
                        ImageViewDialog(R.drawable.lv2_victim);
                        // ----

                        wasItClicked8=true;
                        answer--;
                        Toasty.success(LevelTwo.this,answer+" petunjuk tersisa.", Toast.LENGTH_SHORT,true).show();

                    } else {

                        // -- Open Image --
                        ImageViewDialog(R.drawable.lv2_victim);
                        // ----

                        Toasty.success(LevelTwo.this,"Petunjuk Sudah Dipilih", Toast.LENGTH_SHORT,true).show();


                    }



                } else {

                    int oldLife = prefs.getInt("changeAnswer", 5);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putInt("changeAnswer", oldLife - 1);
                    editor.apply();

                    Toasty.error(LevelTwo.this,oldLife-1+" kesempatan tersisa!.", Toast.LENGTH_SHORT,true).show();


                    if (oldLife<0){
                    Toasty.error(LevelTwo.this,"Kesempatanmu : Sudah Habis", Toast.LENGTH_SHORT,true).show();
                    Intent i = new Intent(LevelTwo.this,QuestActivity.class);
                    startActivity(i);
                    finish();
                    }

                }

                //jika berhasil menjawab menjawab
                if (answer==0){
                    final DatabaseHelper dbHelper = new DatabaseHelper(LevelTwo.this);
                    dbHelper.addUser(new User("l2"));


                    if (stated==1) {
                        //start phone
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                pc.start();
                                // Get instance of Vibrator from current Context
                                long[] pattern = {1100, 1100, 1100, 1100, 1100, 1100, 1100, 1100, 1100, 500};
                                // Vibrate for 400 milliseconds
                                v.vibrate(pattern, -1);
                                dialog.setContentView(R.layout.telponberbohong);
                                dialog.setCancelable(false);
                                dialog.show();
                                terima = dialog.findViewById(R.id.terima);

                            }
                        }, 4600); // Millisecond 1000 = 1 sec

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                v.cancel();
                                terima.setVisibility(View.GONE);
                                wm.start();

                            }
                        }, 15600); // Millisecond 1000 = 1 sec

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                dialog.dismiss();


                            }
                        }, 19900); // Millisecond 1000 = 1 sec
                            stated=0;
                        e1.setEnabled(true);
                        e1.setText("Jawab");
                        e1.setTextColor(Color.WHITE);
                        //endphone
                    }

                    e1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Toasty.warning(LevelTwo.this,"Bikin dialog tentang pelaku dan tebak no teleponnya", Toast.LENGTH_SHORT,true).show();


                        }
                    });

                }

                //jika salah menjawab selama 3x
                if (life==0){
                    Toasty.error(LevelTwo.this,"Anda Gagal", Toast.LENGTH_SHORT,true).show();
                    Intent i = new Intent(LevelTwo.this,QuestActivity.class);
                    startActivity(i);
                    finish();

                }
            }
        });


        //start phone
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
                terima = dialog.findViewById(R.id.terima);

            }
        }, 4600); // Millisecond 1000 = 1 sec

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                v.cancel();
                terima.setVisibility(View.GONE);
                wm.start();

            }
        }, 15600); // Millisecond 1000 = 1 sec

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                dialog.dismiss();

            }
        }, 19900); // Millisecond 1000 = 1 sec

        //endphone


        lstChat.add(new ChatModel("Eh ngomong-ngomong malam minggu ke A* yuk?", false));//0

        lstChat.add(new ChatModel("A* itu apaan?, gue gak ada waktu , nanti kalau bisa gue kabarin.", true));//1

        lstChat.add(new ChatModel("Gak asik dah, ada acara lu?",false));//2

        lstChat.add(new ChatModel("padahal Reunian kali-kali",false));//3

        lstChat.add(new ChatModel("Kerjaan kantor biasa, kerjaan akhir bulan selalu numpuk",true));//4

        lstChat.add(new ChatModel("Lah, gue kira udah keluar dari perusahaan gak jelas itu", false));//5//clue

        lstChat.add(new ChatModel("Hush ngawur, biarpun perusahaannya gak jelas, gue bisa makan selama ini dari sono", true));//6

        lstChat.add(new ChatModel("Emang gak ada pikiran cari kerja lain aja gitu?", false));//7

        lstChat.add(new ChatModel("Heh lu pikir nyari kerja itu kaya ngupil ya?, kalau gampang gue udah pindah dari dulu",true));//8

        lstChat.add(new ChatModel("Lagian gue udah lama disini, kesel kerja itu wajar lah",true));//9

        lstChat.add(new ChatModel("Gue tau, tapi gue saranin mending pindah deh, cari yang lebih ngejamin, gue khawatir aja ama lu",false));//10

        lstChat.add(new ChatModel("Ya udah , gue hargain karena lu peduli ama gue, tapi bener untuk sekarang gue masih bisa bertahan", true));//11

        lstChat.add(new ChatModel("Terus gue denger-denger lu udah mau nikah ya?", true));//12

        lstChat.add(new ChatModel("Ini anak bisa aja kalau ngalihin topik", false));//13

        lstChat.add(new ChatModel("alhamdullilah doain aja semoga lancar, tapi ada beberapa kendala kecil sih", false));//14

        lstChat.add(new ChatModel("kendala apa?, gedung?, pasangan?", true));//15

        lstChat.add(new ChatModel("Gedung", false));//16

        lstChat.add(new ChatModel("Mana coba gue liat fotonya?", true));//17

        lstChat.add(new ChatModel("Nih", false));//18//foto

        lstChat.add(new ChatModel("Gila, lu jual ginjal ya?", true));//19

        lstChat.add(new ChatModel("Kurang ajar, gue nabung 2 tahun ", false));//20

        lstChat.add(new ChatModel("niat!", true));//21

        lstChat.add(new ChatModel("Ya iyalah harus niat, nikah kalau gak niat mending gak usah sekalian", false));//22

        lstChat.add(new ChatModel("Kalau bisa lu bantuin gue cari gedung lain deh, yang lebih murah XD", false));//23

        lstChat.add(new ChatModel("Iya pasti gue bantu, cuman gue beresin kerjaan dulu, tanggal berapa lu butuh emang?", true));//24

        lstChat.add(new ChatModel("10 oktober", false));//25

        lstChat.add(new ChatModel("2 minggu lagi!", true));//26

        lstChat.add(new ChatModel("gue dari sekarang sampe tanggal 4 pasti lembur terus", true));//27

        lstChat.add(new ChatModel("wah bener nih lu mau bantu?", false));//28

        lstChat.add(new ChatModel("iyalah udah kagak ketemu 2 tahun terus bawa kabar baik, masa gue kagak seneng juga", true));//29

        lstChat.add(new ChatModel("asik, gue cariin cewek deh nanti", false));//30

        lstChat.add(new ChatModel("Gue udah punya cewe, lu nyuruh gue selingkuh?", true));//31

        lstChat.add(new ChatModel("Demi tuhan, akhirnya lu punya pacar juga", false));//32

        lstChat.add(new ChatModel("Sialan, ya udah lu cari aja sendiri gedungnya kalau gitu", true));//33

        lstChat.add(new ChatModel("eh santai bro, lu kaya emak-emak aja, cepet marah", false));//34

        lstChat.add(new ChatModel("wkwk, maksud gue, gue gak nyangka aja lu bisa pacaran", false));//35

        lstChat.add(new ChatModel("padahal dari dulu kerjaan lu cuman liatin langit kadang-kadang makan lumpur", false));//36

        lstChat.add(new ChatModel("Yaiyalah orang gue masih bocah", true));//37

        lstChat.add(new ChatModel("Lu juga sama aja, hobi lu liatin pantat bu marnikan guru PPKN?", true));//38

        lstChat.add(new ChatModel("Wew, lu tau dari mana?,wkwk", false));//39

        lstChat.add(new ChatModel("Gue tau lah, orang gue juga suka ngeliatin, wkwkwk", true));//40

        lstChat.add(new ChatModel("Jadi selama ini, gue sama lu pecinta pantat ibu-ibu umur 30an gitu?, najis!", false));//41

        lstChat.add(new ChatModel("Yaelah namanya juga bocah XD", true));//42

        lstChat.add(new ChatModel("Throwback masa lalu itu emang bikin pengen bunuh diri ya?", false));//43

        lstChat.add(new ChatModel("Gak apa2 lah setiap orang punya masa lalu dan bisa berubah", true));//44

        lstChat.add(new ChatModel("Woy stop, sejak kapan kita suka ngomong serius kaya gini?", false));//45

        lstChat.add(new ChatModel("Lah elu yang mulai duluan", false));//46

        lstChat.add(new ChatModel("Ah iya juga si", true));//47

        lstChat.add(new ChatModel("BTW, gue mimpi aneh semalem", false));//48//clue

        lstChat.add(new ChatModel("Mimpi apaan?", true));//49

        lstChat.add(new ChatModel("Masa gue mimpi didorong sama orang dari tempat kerja gue?", false));//50

        lstChat.add(new ChatModel("Horor juga, tapi mimpikan?, gak usah banyak dipikirin", true));//51

        lstChat.add(new ChatModel("Masalahnya udah 3 hari mimpi aneh terus", false));//52

        lstChat.add(new ChatModel("berdoa makannya sebelum tidur", true));//53

        lstChat.add(new ChatModel("Diganggu setankan jadinya", true));//54

        lstChat.add(new ChatModel("Iyalah malah gue cuci kaki sekalian.", false));//55

        lstChat.add(new ChatModel("Oh ya lu mau ikut kagak, gue diajak ke mini party gitu tiba-tiba?", false));//56

        lstChat.add(new ChatModel("Ikut apa?", true));//57

        lstChat.add(new ChatModel("nih", false));//58//foto brosur//biat brosur print

        lstChat.add(new ChatModel("Apaan itu?", true));//59

        lstChat.add(new ChatModel("Party deket kantor gue", false));//60

        lstChat.add(new ChatModel("Lu diundang siapa?", true));//61

        lstChat.add(new ChatModel("Ada temen kantor gue, baru kenal si cuman baik ke gue", false));//62//clue

        lstChat.add(new ChatModel("awas ada maunya tuh", true));//63

        lstChat.add(new ChatModel("Cowo?, Cewe?", true));//64

        lstChat.add(new ChatModel("Cewe, kenapa emang?", false));//65

        lstChat.add(new ChatModel("Lu kagak niat selingkuhkan?", true));//66

        lstChat.add(new ChatModel("enak aja, kagak mungkinlah", false));//67

        lstChat.add(new ChatModel("Ya gue mah simple ada yang baik ke gue, yang gue bls baikin lagi", false));//68

        lstChat.add(new ChatModel("Dari dulu lu emang gak pernah berubah", true));//69

        lstChat.add(new ChatModel("Ngapain harus berubah kalau gak ada yang perlu dirubah XD", false));//70

        lstChat.add(new ChatModel("Bisa aja lu", true));//71

        lstChat.add(new ChatModel("ben thasfhgfa", false));//72

        lstChat.add(new ChatModel("Gila, kenapa lu", true));//73

        lstChat.add(new ChatModel("Hai,^^", false));//74//pesan suara

        lstChat.add(new ChatModel("Ben!, Lu kenapa Ben", true));//75

        lstChat.add(new ChatModel("Woy ben!!", true));//76

        lstChat.add(new ChatModel("Jika kamu mau selamat, jangan pernah ikut campur, atau kamu akan berarkhir sepert ini", false));//77//foto

        lstChat.add(new ChatModel("Diam dan semua akan baik-baik saja", false));//78//Video


    }


    @Override
    public void onBackPressed() {

    }

    private void ImageViewDialog(int resourceId) {
        View view = getLayoutInflater().inflate(R.layout.layout_image_view, null);
        Dialog dialog = new Dialog(this, android.R.style.Theme_DeviceDefault_NoActionBar_Fullscreen);
        dialog.setContentView(view);

        String imageUrl = getURLForResource(resourceId);

        ImageView imageView = dialog.findViewById(R.id.imageViewHolder);
        imageView.setMaxHeight(200);
        Glide.with(this)
                .load(imageUrl)
                .into(imageView);

        dialog.show();
    }

    public String getURLForResource (int resourceId) {
        return Uri.parse("android.resource://"+R.class.getPackage().getName()+"/" +resourceId).toString();
    }
}

