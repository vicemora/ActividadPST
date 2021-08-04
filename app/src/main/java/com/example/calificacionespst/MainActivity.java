package com.example.calificacionespst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Manejador para el evento onClick para el botón de ingresar como profesor
     * @param v
     */
    public void profesor(View v){

        Intent i = new Intent(this, MainActivity2.class ); // Permite enlazar con el activity para profesores
        startActivity(i); //inicia el activity
    }

    /**
     * Manejador para el evento onclick del botón para ingresar como estudiante
     * @param v
     */
    public void estudiante(View v){
        Intent i = new Intent(this, MainActivity3.class ); // Permite enlazar con el activity para profesores
        startActivity(i); //inicia el activity
    }


}