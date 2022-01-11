package com.android.examenut2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar myToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myToolbar=findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.m_act_sumar:
                actividadSumar();
            case R.id.m_act_frame:
                Intent i = new Intent(this,Frame.class);
                startActivity(i);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void actividadSumar() {
        Intent i = new Intent(this,SumarRestar.class);
        startActivity(i);
    }

    public void siguienteActividad(View view) {

        actividadSumar();
    }

    public void informacion(View view) {
        Intent i = new Intent(this,InsertarBBDD.class);
        startActivity(i);
    }
}