package com.android.examenut2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class InsertarBBDD extends AppCompatActivity {

    EditText edtNombre, edtNacionalidad, edtGenero, edtCreacion;
    ListView lv;
    SQLiteDatabase db;
    Helper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_bbdd);

        edtNombre=findViewById(R.id.edtNombre);
        edtNacionalidad=findViewById(R.id.edtNacionalidad);
        edtGenero=findViewById(R.id.edtGenero);
        edtCreacion=findViewById(R.id.edtYearCreacion);
        lv = findViewById(R.id.lstGrupos);

        helper= new Helper(this);
    }

    public void insertarRegistro(View view) {
        //comprobamos si se han rellenado los campos
        if ((edtNombre.getText().toString().isEmpty())||(edtNacionalidad.getText().toString().isEmpty())
                ||(edtGenero.getText().toString().isEmpty())||(edtCreacion.getText().toString().isEmpty())){
            Toast.makeText(this,"No se han rellenado todos los datos a insertar",Toast.LENGTH_SHORT).show();
            return;
        }else{
            db=helper.getWritableDatabase();
            ContentValues values= new ContentValues();
            values.put("nombre", edtNombre.getText().toString());
            values.put("nacionalidad", edtNacionalidad.getText().toString());
            values.put("genero_musical", edtGenero.getText().toString());
            values.put("year_creacion", edtCreacion.getText().toString());
            db.insert("grupos",null, values);

            Toast.makeText(this,"Registro insertado",Toast.LENGTH_SHORT).show();

            //limpiamos los cuadros de texto
            edtNombre.setText("");
            edtNacionalidad.setText("");
            edtGenero.setText("");
            edtCreacion.setText("");

            db.close();
        }

        //refrescamos la lista con todos los datos de la tabla
        mostrarDatos();
    }

    public void mostrarDatos(){
        db = helper.getReadableDatabase();
        Cursor cursor = db.query("grupos", null, null, null, null, null, null);

        //adaptamos el cursor a nuestro ListView
        String[] from = {"nombre", "nacionalidad", "genero_musical"};
        int[] to = {R.id.txtItemNombre, R.id.txtItemNacionalidad,R.id.txtItemGenero};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(this, R.layout.lista, cursor, from, to, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        lv.setAdapter(adaptador);

        db.close();

    }
}