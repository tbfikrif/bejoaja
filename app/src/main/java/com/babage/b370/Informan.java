package com.babage.b370;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
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
import android.widget.Toast;

import com.mzelzoghbi.zgallery.ZGallery;
import com.mzelzoghbi.zgallery.entities.ZColor;
import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;
import com.shashank.sony.fancydialoglib.FancyAlertDialogListener;
import com.shashank.sony.fancydialoglib.Icon;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class Informan extends AppCompatActivity {

    CircleImageView btnv,btng,btnc,imgv;
    ArrayList<String> imagesList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //menghilangkan ActionBar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_informan);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher_round);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        btnv = (CircleImageView) findViewById(R.id.btnV);
        btng = (CircleImageView) findViewById(R.id.btnG);
        btnc = (CircleImageView) findViewById(R.id.btnC);
        imgv = (CircleImageView) findViewById(R.id.imgv);

        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/05110349/20160731-igor-trepeshchenok-barnimages-08-768x509.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/05095154/tumblr_oawfisUmZo1u7ns0go1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/05095153/tumblr_obbkeo3lZW1ted1sho1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/05095153/tumblr_obaxpnJbKg1sfie3io1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/05095153/tumblr_obdehwWneK1slhhf0o1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/05095152/2016-08-01-roman-drits-barnimages-005-768x512.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/05095151/2016-08-01-roman-drits-barnimages-003-768x512.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/05095149/tumblr_obbjwp1bDz1ted1sho1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/05095151/tumblr_oawfhnxNjL1u7ns0go1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/05095150/tumblr_ob6xvqXLoB1tlwzgvo1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/05095148/20160731-igor-trepeshchenok-barnimages-10-768x512.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/03092421/tumblr_oawfgd2G941u7ns0go1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/03092423/tumblr_ob6xutS8N21tlwzgvo1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/03092421/tumblr_o86sgm6F7a1ted1sho1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/03092420/tumblr_ob6xudqW4U1tlwzgvo1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/03092420/2016-08-01-roman-drits-barnimages-002-768x512.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/03092418/tumblr_o97fatuGnd1ted1sho1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/03092420/tumblr_oawff12j9L1u7ns0go1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/03092420/2016-08-01-roman-drits-barnimages-001-768x512.jpg");
        imagesList.add("http://1x402i15i5vh15yage3fafmg.wpengine.netdna-cdn.com/wp-content/uploads/2016/08/tumblr_oawfdsEx2w1u7ns0go1_500-1.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/08/03092417/tumblr_o97gyqSK3k1ted1sho1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/07/03092417/20160731-igor-trepeshchenok-barnimages-07-768x512.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/07/03092605/tumblr_ob6wjiCBUh1tlwzgvo1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/07/03092604/tumblr_ob6wkn58cJ1tlwzgvo1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/07/03092416/tumblr_ob6wk7mns81tlwzgvo1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/07/03092413/tumblr_ob6vv04yIP1tlwzgvo1_500.jpg");
        imagesList.add("http://static0.passel.co/wp-content/uploads/2016/07/03092414/tumblr_ob6vk1bBPa1tlwzgvo1_500.jpg");
        imagesList.add("https://cdn0-a.production.images.static6.com/u69S-nBXVwI7gb45nRg4cQVKdtw=/smart/filters:strip_icc():quality(90)/vidio-media-production/uploads/user/avatar/295012/jalantikus-e827ab.jpg");



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
                Intent i = new Intent(getApplicationContext(),LevelOne.class);
                startActivity(i);
                Informan.this.finish();
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
        Toast.makeText(getApplicationContext(),"In Progress...",Toast.LENGTH_SHORT).show();
    }

}
