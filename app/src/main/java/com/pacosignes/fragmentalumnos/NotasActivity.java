package com.pacosignes.fragmentalumnos;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);

        FragmentListadoAsignaturas fragmentListadoAsignaturas=(FragmentListadoAsignaturas) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentNotas);


    }
}
