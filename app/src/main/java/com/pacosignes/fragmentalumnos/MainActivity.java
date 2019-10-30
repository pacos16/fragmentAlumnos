package com.pacosignes.fragmentalumnos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IAlumnoListener {
    private ArrayList<Alumno> alumnos;
    private ArrayList<Asignatura> asignaturas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Parser parser=new Parser(this);
        parser.parse();
        alumnos=parser.getAlumnos();
        asignaturas= parser.getAsignaturas();
        FragmentListadoAlumnos fragmentAlumnos= (FragmentListadoAlumnos)getSupportFragmentManager()
                .findFragmentById(R.id.fragmentAlumnos);

        fragmentAlumnos.setAlumnos(alumnos);
        fragmentAlumnos.setListener(this);

    }

    @Override
    public void onAlumnoSeleccionado(int posicion) {

        boolean hayDetalle= false;//(getSupportFragmentManager().findFragmentById())!=null);
        if(hayDetalle){

        }else {
            Intent i=new Intent(this,NotasActivity.class);
            i.putExtra("alumno",alumnos.get(posicion));
            i.putExtra("asignaturas",asignaturas);
            startActivity(i);
        }
    }
}
