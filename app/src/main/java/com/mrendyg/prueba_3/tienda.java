package com.mrendyg.prueba_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class tienda extends AppCompatActivity {

    private EditText et1, et2, et3, et4;
    private TextView tv1, tv2, tv3, tv4, tv5;
    private CheckBox bx1, bx2, bx3, bx4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tienda);

        // Valores de kilos ingresados
        et1 = findViewById(R.id.papaskg);
        et2 = findViewById(R.id.frutillaskg);
        et3 = findViewById(R.id.tomateskg);
        et4 = findViewById(R.id.duraznoskg);
        //Checkbox de los productos
        bx1 = findViewById(R.id.papas);
        bx2 = findViewById(R.id.frutillas);
        bx3 = findViewById(R.id.tomates);
        bx4 = findViewById(R.id.duraznos);
        //Vista de los totales
        tv1 = findViewById(R.id.total_tienda);
        tv2 = findViewById(R.id.totalpapas);
        tv3 = findViewById(R.id.totalfruti);
        tv4 = findViewById(R.id.totaltoma);
        tv5 = findViewById(R.id.totaldura);
    }

    public void atras(View view){
        onBackPressed();
    }

    public void totales_tienda(View view) {
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();
        String valor3 = et3.getText().toString();
        String valor4 = et4.getText().toString();

        Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(100);

        //VALOR PRODUCTOS
        int papaskg = 1500;
        int frutillaskg = 1100;
        int tomateskg = 1000;
        int duraznoskg = 1600;

        //TOTAL DEFAULT
        int Papastotal = 0;
        int Frutillastotal = 0;
        int Tomatestotal = 0;
        int Duraznostotal = 0;

        if (bx1.isChecked() && !valor1.isEmpty()) {
            int val1 = Integer.parseInt(valor1);
            Papastotal = papaskg * val1;
            tv2.setText("Total papas: \n" + "$" + Papastotal);
        } else {
            tv2.setText("Total papas: \n" + "$0");
        }

        if (bx2.isChecked() && !valor2.isEmpty()) {
            int val2 = Integer.parseInt(valor2);
            Frutillastotal = frutillaskg * val2;
            tv3.setText("Total frutillas: \n" + "$" + Frutillastotal);
        } else {
            tv3.setText("Total frutillas: \n" + "$0");
        }

        if (bx3.isChecked() && !valor3.isEmpty()) {
            int val3 = Integer.parseInt(valor3);
            Tomatestotal = tomateskg * val3;
            tv4.setText("Total tomates: \n" + "$" + Tomatestotal);
        } else {
            tv4.setText("Total tomates: \n" + "$0");
        }

        if (bx4.isChecked() && !valor4.isEmpty()) {
            int val4 = Integer.parseInt(valor4);
            Duraznostotal = duraznoskg * val4;
            tv5.setText("Total duraznos: \n" + "$" + Duraznostotal);
        } else {
            tv5.setText("Total duraznos: \n" + "$0");
        }

        //MOSTRAR TOTAL DE LA COMPRA
        int totalcompra = Papastotal + Frutillastotal + Tomatestotal + Duraznostotal;
        tv1.setText("Total:\n\n" + "$" + totalcompra);
    }
}

