package com.mrendyg.prueba_3;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class reproductor extends AppCompatActivity {

    Button play;
    SoundPool sp;
    int sonido_de_Reproduccion;

    public void atras(View view) {
        onBackPressed();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reproductor);

        play = (Button) findViewById(R.id.button_play);
        sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        sonido_de_Reproduccion = sp.load(this, R.raw.rana, 1);
    }

    public void AudioSoundPool(View view) {
        sp.play(sonido_de_Reproduccion, 1, 1, 1, 0, 0);
        Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(100);
    }

    public void AudioMediaPlayer(View view) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.videoculiao);
        mp.start();
        Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(100);
    }
}