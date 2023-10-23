package com.mrendyg.prueba_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //menu
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.item1){
            String direccion = "https://www.linkedin.com/in/andy-garcia-1825ab180/";
            Uri linkedin = Uri.parse(direccion);
            Intent url = new Intent(Intent.ACTION_VIEW,linkedin);
            startActivity(url);
            Toast.makeText(this, "Fondo 1", Toast.LENGTH_SHORT).show();
        } else if(id == R.id.item2){
            String direccion = "https://github.com/mrendyg";
            Uri GitHub = Uri.parse(direccion);
            Intent url = new Intent(Intent.ACTION_VIEW,GitHub);
            startActivity(url);
            Toast.makeText(this, "Abriendo GitHub...", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.item3){
            String direccion = "https://www.instagram.com/andy___ga/?next=%2F";
            Uri Instagram = Uri.parse(direccion);
            Intent url = new Intent(Intent.ACTION_VIEW,Instagram);
            startActivity(url);
            Toast.makeText(this, "Abriendo instagram...", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void imc(View view) {
        Intent intent = new Intent(MainActivity.this, calculadora_imc.class);
        startActivity(intent);
        //vibracion
        Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(100);
    }

    public void sueldo(View view) {
        Intent intent = new Intent(MainActivity.this, sueldo.class);
        startActivity(intent);
        //vibracion
        Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(100);
    }

    public void reproductor(View view) {
        Intent intent = new Intent(MainActivity.this, reproductor.class);
        startActivity(intent);
        //vibracion
        Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(100);
    }

    public void webview(View view) {
        Intent intent = new Intent(MainActivity.this, webview.class);
        startActivity(intent);
        //vibracion
        Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(100);
    }

    public void calculadora_spinner(View view) {
        Intent intent = new Intent(MainActivity.this, calculadora_spinner.class);
        startActivity(intent);
        //vibracion
        Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(100);
    }

    public void tienda(View view) {
        Intent intent = new Intent(MainActivity.this, tienda.class);
        startActivity(intent);
        //vibracion
        Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(100);
    }
    public void reproductor_mp3(View view) {
        Intent intent = new Intent(MainActivity.this, reproductor_mp3.class);
        startActivity(intent);
        //vibracion
        Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(100);
    }

    public void linterna(View view) {
        Intent intent = new Intent(MainActivity.this, linterna.class);
        startActivity(intent);
        //vibracion
        Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(100);
    }

    public void reproductor_video(View view) {
        Intent intent = new Intent(MainActivity.this, reproductor_video.class);
        startActivity(intent);
        //vibracion
        Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(100);
    }

}