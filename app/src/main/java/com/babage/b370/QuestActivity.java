package com.babage.b370;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;

public class QuestActivity extends Activity {

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //menghilangkan ActionBar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_quest);
    }

    public void berbohongOnClick(View v){
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.informasiberbohong);
        dialog.setTitle("Title....");

        //AlertDialog.Builder builder = new AlertDialog.Builder(QuestActivity.this);
        //View view = getLayoutInflater().inflate(R.layout.informasiberbohong, null);
        Button okButton = dialog.findViewById(R.id.btnOk);
        //final AlertDialog dialog = builder.create();

        okButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
