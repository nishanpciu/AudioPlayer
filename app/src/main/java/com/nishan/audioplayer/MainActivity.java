package com.nishan.audioplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_play,btn_pause,btn_stop;

    MediaPlayer player;
    Boolean isPlaying=false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_play=findViewById(R.id.btn_play);
        btn_pause=findViewById(R.id.btn_pause);
        btn_stop=findViewById(R.id.btn_stop);
        player=MediaPlayer.create(MainActivity.this,R.raw.audio);
        btn_play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(isPlaying==false){
                    player.start();
                    isPlaying=true;
                }
            }
        });
        btn_pause.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(isPlaying==true){
                    player.pause();
                    isPlaying=false;
                }
            }
        });
        btn_stop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(isPlaying==true){
                    player.stop();
                    isPlaying=false;
                }
                MainActivity.this.finish();
            }
        });


    }

    protected void onPause() {
        super.onPause();
player.pause();
isPlaying=false;
super.onPause();
    }
}
