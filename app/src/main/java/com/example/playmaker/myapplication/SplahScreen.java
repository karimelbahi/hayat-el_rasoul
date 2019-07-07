package com.example.playmaker.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplahScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splah_screen);

        TextView textView = (TextView) findViewById(R.id.textView);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);

        textView.setAnimation(animation);

        final MediaPlayer mediaPlayer = MediaPlayer.create(SplahScreen.this, R.raw.basmala);

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {

                    mediaPlayer.start();
                    sleep(4000);
                    Intent intent = new Intent(SplahScreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}
