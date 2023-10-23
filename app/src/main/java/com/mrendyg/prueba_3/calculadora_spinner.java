package com.mrendyg.prueba_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.*;
import android.view.*;
import android.widget.*;


public class calculadora_spinner extends AppCompatActivity {
    private EditText et1, et2;
    private TextView tv1;
    private Spinner sp1;
    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora_spinner);
        this.window = getWindow();
        et1 = findViewById(R.id.num1);
        et2 = findViewById(R.id.num2);
        tv1 = findViewById(R.id.resultado_calculadora_spinner);
        sp1 = findViewById(R.id.spinner);
        String[] opciones = {"Sumar", "Restar", "Multiplicar", "Dividir", "Mod", "Cambiar","Default"};
       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_calculadora, opciones);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item_calculadora, R.id.textViewCalculadoraItem, opciones);



        sp1.setAdapter(adapter);
    }

    public void atras(View view){
        onBackPressed();
    }

    public void calculadora_spinner(View view) {
        String red = "#FF0000";
        String defaultc = "#FFFFFF";
        String val1 = et1.getText().toString();
        String val2 = et2.getText().toString();
        String seleccion = sp1.getSelectedItem().toString();
        Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(100);
        if (seleccion.equals("Cambiar")) {
            window.setBackgroundDrawable(new ColorDrawable(Color.parseColor(red)));
            tv1.setText("Color cambio exitosamente");
        } else if (seleccion.equals("Default")) {
            window.setBackgroundDrawable(new ColorDrawable(Color.parseColor(defaultc)));
            tv1.setText("Color cambio exitosamente");
        }
        if (val1.isEmpty() || val2.isEmpty()) {
            tv1.setText("Ingrese los valores");
        } else {
            int valor1 = Integer.parseInt(val1);
            int valor2 = Integer.parseInt(val2);

            if (seleccion.equals("Sumar")) {
                int suma = valor1 + valor2;
                String resultado = String.valueOf(suma);
                tv1.setText("La suma es:\n" + resultado);
            } else if (seleccion.equals("Restar")) {
                int resta = valor1 - valor2;
                String resultado = String.valueOf(resta);
                tv1.setText("La resta es:\n" + resultado);
            } else if (seleccion.equals("Multiplicar")) {
                int multi = valor1 * valor2;
                String resultado = String.valueOf(multi);
                tv1.setText("La multimplicacion es:\n" + resultado);
            } else if (seleccion.equals("Dividir")) {
                if (valor1 != 0 || valor2 != 0) {
                    int division = valor1 / valor2;
                    String resultado = String.valueOf(division);
                    tv1.setText("La division es:\n" + resultado);
                } else {
                    Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_SHORT).show();
                }
            } else if (seleccion.equals("Mod")) {
                if (valor2 != 0 || valor2 != 0) {
                    int sobra = valor1 % valor2;
                    String resultado = String.valueOf(sobra);
                    tv1.setText("El MOD es:\n" + resultado);
                } else {
                    Toast.makeText(this, "No se puede sacar MOD de cero", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
