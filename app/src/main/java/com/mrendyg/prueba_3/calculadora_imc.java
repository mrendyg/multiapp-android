package com.mrendyg.prueba_3;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

public class calculadora_imc  extends AppCompatActivity {

        private EditText et1;
        private EditText et2;
        private TextView tv1;

        public void atras(View view) {
            onBackPressed();
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.calculadora_imc);
            et1 = (EditText) findViewById(R.id.peso);
            et2 = (EditText) findViewById(R.id.estatura);
            tv1 = (TextView) findViewById(R.id.resultado);

        }

        public void imc(View view) {
            String peso = et1.getText().toString();
            String estatura = et2.getText().toString();

            //vibracion
            Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(100);

            if (peso.isEmpty()&&estatura.isEmpty()){
                tv1.setText("Ingrese\nsu peso y estatura");
                Toast.makeText(this,"Ingrese valores",Toast.LENGTH_SHORT).show();
            } else if (peso.isEmpty() ) {
                tv1.setText("Ingrese\nSu peso");
                Toast.makeText(this,"Ingrese Su peso",Toast.LENGTH_SHORT).show();
            } else if (estatura.isEmpty()){
                tv1.setText("Ingrese\nSu Estatura");
                Toast.makeText(this,"Ingrese Su ESTATURA",Toast.LENGTH_SHORT).show();
            }else{
                double peso1 = Double.parseDouble(peso);
                double estaturas1 = Double.parseDouble(estatura);
                if (estaturas1 >= 10) {

                    double estaturas = estaturas1 / 100;
                    double estaturas2 = (estaturas * estaturas);
                    double resultado = peso1 / estaturas2;
                    int resultadoimc = (int) resultado;
                    String calculo = String.valueOf(resultadoimc);
                    tv1.setText("Tu IMC es: \n" + calculo);
                    Toast.makeText(this, "HECHO", Toast.LENGTH_SHORT).show();
                } else {
                    double estaturas = Double.parseDouble(estatura);
                    double pesos = Double.parseDouble(peso);
                    double estaturast = (estaturas * estaturas);
                    double resultado = pesos / estaturast;
                    int resultadoimc = (int) resultado;
                    String calculo = String.valueOf(resultadoimc);
                    tv1.setText(String.format("Tu IMC es: \n" + calculo));
                    Toast.makeText(this, "HECHO", Toast.LENGTH_SHORT).show();
                }
            }
        }
}


