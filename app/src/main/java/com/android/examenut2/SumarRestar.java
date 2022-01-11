package com.android.examenut2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SumarRestar extends AppCompatActivity {

    TextView resultado;
    int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sumar_restar);

        resultado=findViewById(R.id.txtresultado);
        contador=0;
    }

    public void realizarOperacion(View view) {
        switch (view.getId()){
            case R.id.buttonMas1:
                contador = contador + 1;
                break;
            case R.id.buttonMas2:
                contador = contador + 2;
                break;
            case R.id.buttonMenos1:
                contador=contador-1;
                break;
            case R.id.buttonMenos2:
                contador=contador-2;
                break;
            case R.id.button0:
                contador=0;
                break;
        }
        resultado.setText(Integer.toString(contador));
    }
}