package com.babage.b370;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class QuestActivity extends Activity {

    final Context context = this;
    Button Q2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //menghilangkan ActionBar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_quest);
        Q2 = (Button)findViewById(R.id.Q2);

        Q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                level2();
            }
        });
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
                Intent intent = new Intent(QuestActivity.this, LevelOne.class);
                startActivity(intent);
            }
        });


        dialog.show();
    }

    public void level2(){
        final DatabaseHelper dbHelper = new DatabaseHelper(this);
        User user = dbHelper.queryUser("l1");
        if (user != null) {
            //Bundle mBundle = new Bundle();
            //mBundle.putString("user", user.getValue());
            Intent intent = new Intent(QuestActivity.this, LevelTwo.class);
            //intent.putExtras(mBundle);
            startActivity(intent);
            Toast.makeText(QuestActivity.this, "Level Unlock ", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(QuestActivity.this, "Level Locked", Toast.LENGTH_SHORT).show();
        }


    }

}
