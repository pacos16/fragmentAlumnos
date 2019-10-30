package com.pacosignes.fragmentalumnos;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);



        Alumno alumno=(Alumno) getIntent().getSerializableExtra("alumno");
        ArrayList<Asignatura> asignaturas=(ArrayList<Asignatura>)
                getIntent().getSerializableExtra("asignaturas");


        FragmentListadoAsignaturas fragment=
                (FragmentListadoAsignaturas) getSupportFragmentManager().findFragmentById(R.id.fragmentNotas);

        fragment.setAlumno(alumno);
        fragment.setAsignaturas(asignaturas);


    }


}
