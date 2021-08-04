package com.example.calificacionespst;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    //Creacion de objeto con la base de datos
    AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"PST",
            null, 1);
    // variables para los parametros pasados por el usuario
    String matricula;
    String nombre;
    String calificacion;

    //se declaran los objetos EditText que se utilizaran
    private EditText et1,et2;
    private TextView cal1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        et1=(EditText)findViewById(R.id.et1e);
        et2=(EditText)findViewById(R.id.et2e);
        cal1=(TextView)findViewById(R.id.cal1);
    }

    public void consultaM(View v) {

        SQLiteDatabase bd = admin.getReadableDatabase();// se obtiene la base de datos en modo lectura
        matricula = et1.getText().toString(); //obteniendo matricula
        // obteniendo el nombre y calificacion del estudiante con la matricula pasada como parametro
        Cursor fila = bd.rawQuery(
                "select nombre,calificacion from calificaciones where matricula=" + matricula, null);
        if (fila.moveToFirst()) {
            et2.setText(fila.getString(0));
            cal1.setText(fila.getString(1));
        } else
            Toast.makeText(this, "No existe un estudiante con dicha matricula",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }

    public void consultaN(View v) {

        SQLiteDatabase bd = admin.getReadableDatabase();  // se obtiene la base de datos en modo lectura
        String nombre = et2.getText().toString(); // obteniendo nombre
        // obteniendo matricula y calificacion del estudiante con la matricula pasada como parametro
        Cursor fila = bd.rawQuery(
                "select matricula,calificacion from calificaciones where nombre like '" + nombre +"'", null);
        if (fila.moveToFirst()) {
            et1.setText(fila.getString(0));
            cal1.setText(fila.getString(1));
        } else
            Toast.makeText(this, "No existe un estudiante con dicho nombre",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }


    public void volver(View view) {
        finish();
    }

}