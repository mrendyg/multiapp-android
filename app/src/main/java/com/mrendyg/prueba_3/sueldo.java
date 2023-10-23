package com.mrendyg.prueba_3;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class sueldo extends AppCompatActivity {

    EditText horaslav, horassab, horasdomfer;
    TextView total;
    ImageView bueno, medio, malo;
    Button play_pause;
    MediaPlayer vectormp[] = new MediaPlayer[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sueldo);

        horaslav = findViewById(R.id.horaslav);
        horassab = findViewById(R.id.horassab);
        horasdomfer = findViewById(R.id.horasdomfer);
        total = findViewById(R.id.total);
        play_pause = (Button) findViewById(R.id.parar);

        vectormp[0] = MediaPlayer.create(this, R.raw.videoculiao);
        vectormp[1] = MediaPlayer.create(this, R.raw.rana);
        vectormp[2] = MediaPlayer.create(this, R.raw.vieja);

    }

    public void atras(View view) {
        onBackPressed();
        parar(view);
    }

    public void calcularTotal(View view) {
        String horaslAv = horaslav.getText().toString();
        String horasSab = horassab.getText().toString();
        String horasDomfer = horasdomfer.getText().toString();


        bueno = (ImageView) findViewById(R.id.excelente);
        medio = (ImageView) findViewById(R.id.medio);
        malo = (ImageView) findViewById(R.id.malo);

        play_pause.setVisibility(view.VISIBLE);

        int lav = 2472;
        int sab = 2778;
        int dom = 5055;

        int thoraslav = 0;
        int thorassab = 0;
        int thorasdomfer = 0;

        if (!horaslAv.isEmpty()) {
            int totalhoraslav = Integer.parseInt(horaslAv);
            thoraslav = lav * totalhoraslav;
        }

        if (!horasSab.isEmpty()) {
            int totalhorassab = Integer.parseInt(horasSab);
            thorassab = sab * totalhorassab;
        }

        if (!horasDomfer.isEmpty()) {
            int totalhorasdomfer = Integer.parseInt(horasDomfer);
            thorasdomfer = dom * totalhorasdomfer;
        }

        int totaleshoras = thoraslav + thorassab + thorasdomfer;
        double descuento = 0.13;
        double descuentot = totaleshoras * descuento;
        double totalmasdescuento = totaleshoras - descuentot;
        int TOTALMASDESCUENTO = (int) totalmasdescuento;
        if (TOTALMASDESCUENTO == 0) {
            total.setText("Total:\n$" + TOTALMASDESCUENTO + "\n");
        } else {
            total.setText("Total:\n$" + totaleshoras + "\n\ncon descuento:\n$" + TOTALMASDESCUENTO);
        }
        double totalesimg = totalmasdescuento;

        //vibracion
        Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(100);

        //limitar audios a 1
        for (MediaPlayer mp : vectormp) {
            if (mp.isPlaying()) {
                mp.pause();
            }
        }


        if (totalesimg >= 100000) {
            bueno.setVisibility(view.VISIBLE);
            medio.setVisibility(view.INVISIBLE);
            malo.setVisibility(view.INVISIBLE);
            vectormp[0].start();
        } else if (totalesimg >= 75000) {
            bueno.setVisibility(view.INVISIBLE);
            medio.setVisibility(view.VISIBLE);
            malo.setVisibility(view.INVISIBLE);
            vectormp[1].start();
        } else if (totalesimg <= 75000) {
            bueno.setVisibility(view.INVISIBLE);
            medio.setVisibility(view.INVISIBLE);
            malo.setVisibility(view.VISIBLE);
            vectormp[2].start();
        }
    }

    public void parar(View view) {
        if (vectormp[0].isPlaying()) {
            vectormp[0].pause();
            play_pause.setVisibility(view.INVISIBLE);
        }
        if (vectormp[1].isPlaying()) {
            vectormp[1].pause();
            play_pause.setVisibility(view.INVISIBLE);
        }
        if (vectormp[2].isPlaying()) {
            vectormp[2].pause();
            play_pause.setVisibility(view.INVISIBLE);
        }
    }
}
