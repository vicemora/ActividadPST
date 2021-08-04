package com.example.calificacionespst;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    //Creacion de objeto con la base de datos
    AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"PST",
            null, 1);
    // variables para los parametros pasados por el usuario
    String matricula;
    String nombre;
    String calificacion;

    //se declaran los objetos EditText que se utilizaran
    private EditText et1,et2,et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et1=(EditText)findViewById(R.id.et1p);
        et2=(EditText)findViewById(R.id.et2p);
        et3=(EditText)findViewById(R.id.et3p);
    }

    //Manejador para el boton Ingresar
    public void ingresar(View v) {

        SQLiteDatabase bd = admin.getWritableDatabase(); //Obteniendo base de datos modo escritura
        //Obteniendo la información pasada por el profesor
        matricula = et1.getText().toString();
        nombre = et2.getText().toString();
        calificacion = et3.getText().toString();
        bd.execSQL("insert into calificaciones (matricula,nombre,calificacion) values ("+matricula+",'"+nombre+"',"+calificacion+")");
        bd.close();

        et1.setText("");
        et2.setText("");
        et3.setText("");
        Toast.makeText(this, "Los datos del estudiante han sido cargados al sistema",
                                                                            Toast.LENGTH_SHORT).show();
    }







    public void volver(View view) {
        finish();
    }

}