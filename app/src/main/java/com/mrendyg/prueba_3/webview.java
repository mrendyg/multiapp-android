package com.mrendyg.prueba_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;


public class webview extends AppCompatActivity {

    private EditText urlEditText;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        urlEditText = findViewById(R.id.urlEditText);
        webView = findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://google.cl");

    }

    public void atras(View view){
        onBackPressed();
    }

    public void hola(View view) {
        String url = urlEditText.getText().toString();
        webView.loadUrl("https://" + url);

    }

    public void cerrar(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(webview.this);
        //Vibracion
        Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(100);
        builder.setMessage("¿Seguro quiere cerrar la app?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int witch) {
                        finish();
                        Toast.makeText(webview.this, "Cerrando...", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int witch) {
                        Toast.makeText(webview.this, "Cancelando...", Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();
                    }
                })
                .show();
    }
}
