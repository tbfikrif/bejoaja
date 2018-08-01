package com.babage.b370;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mzelzoghbi.zgallery.ZGallery;
import com.mzelzoghbi.zgallery.entities.ZColor;

import java.util.ArrayList;
import es.dmoral.toasty.Toasty;

/**
 * Created by Herdi_WORK on 15.09.16.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> rvData;
    MediaPlayer click, distortion,background;




    public RecyclerViewAdapter(ArrayList<String> inputData) {
        rvData = inputData;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // di tutorial ini kita hanya menggunakan data String untuk tiap item
        public TextView tvTitle;
        public TextView tvSubtitle;
        public ImageView tvIcon;

        public ViewHolder(View v) {
            super(v);
            background = MediaPlayer.create(v.getContext(), R.raw.background_quest);
            tvTitle = (TextView) v.findViewById(R.id.tv_title);
            tvSubtitle = (TextView) v.findViewById(R.id.tv_subtitle);
            tvIcon = (ImageView) v.findViewById(R.id.iconss);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // membuat view baru
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_rv_item, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter layout lainnya
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }



    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - mengambil elemen dari dataset (ArrayList) pada posisi tertentu
        // - mengeset isi view dengan elemen dari dataset tersebut


        final String name = rvData.get(position);
        holder.tvTitle.setText(rvData.get(position));
        if (position==0){
            holder.tvIcon.setImageResource(R.drawable.dead_message);
            holder.tvSubtitle.setText("Rank Easy");
        } else if (position==1){
            holder.tvIcon.setImageResource(R.drawable.who_iam);
            holder.tvSubtitle.setText("Rank Medium");
        } else if (position==2){
            holder.tvIcon.setImageResource(R.drawable.lock);
            holder.tvSubtitle.setText("Rank ?");
        } else if (position==3){
            holder.tvIcon.setImageResource(R.drawable.lock);
            holder.tvSubtitle.setText("Rank ?");
        } else if (position==4){
            holder.tvIcon.setImageResource(R.drawable.lock);
            holder.tvSubtitle.setText("Rank ?");
        }

        holder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                click = MediaPlayer.create(view.getContext(), R.raw.click2);
                distortion = MediaPlayer.create(view.getContext(), R.raw.hit_distortion);


                if (position==0){

                    click.start();
                    distortion.start();
                    Intent intent = new Intent(view.getContext(),Informan.class);
                    view.getContext().startActivity(intent);
                    ((Activity)view.getContext()).finish();

                } else if (position==1){
                    background.stop();
                    final DatabaseHelper dbHelper = new DatabaseHelper(view.getContext());
                    User user = dbHelper.queryUser("l1");
                    if (user != null) {
                        //Bundle mBundle = new Bundle();
                        //mBundle.putString("user", user.getValue());
                        Intent intent = new Intent(view.getContext(), LevelTwo.class);
                        //intent.putExtras(mBundle);
                        view.getContext().startActivity(intent);
                        ((Activity) view.getContext()).finish();
                        Toasty.success(view.getContext(), "Terbuka", Toast.LENGTH_SHORT, true).show();
                    } else {
                        Toasty.error(view.getContext(), "Level Dikunci", Toast.LENGTH_SHORT, true).show();
                    }


                }
            }
        });

    }

    @Override
    public int getItemCount() {
        // menghitung ukuran dataset / jumlah data yang ditampilkan di RecyclerView
        return rvData.size();
    }

}