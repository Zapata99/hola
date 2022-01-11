package com.android.examenut2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Frame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
    }

    public void volverMenu(View view) {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}