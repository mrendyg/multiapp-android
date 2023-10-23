package com.mrendyg.prueba_3;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class reproductor_video extends AppCompatActivity {

    VideoView mivideo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reproductor_video);

        mivideo = findViewById(R.id.video);

        String videop = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(videop);
        mivideo.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        mivideo.setMediaController(mediaController);
        mediaController.setAnchorView(mivideo);

    }

    public void siguiente(View view) {
        String videop = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(videop);
        mivideo.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        mivideo.setMediaController(mediaController);
        mediaController.setAnchorView(mivideo);
    }

    public void anterior(View view) {
        String videop = "android.resource://" + getPackageName() + "/" + R.raw.excusme;
        Uri uri = Uri.parse(videop);
        mivideo.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        mivideo.setMediaController(mediaController);
        mediaController.setAnchorView(mivideo);
        mivideo.start();
    }

    public void atras(View view) {
        onBackPressed();
    }
}
