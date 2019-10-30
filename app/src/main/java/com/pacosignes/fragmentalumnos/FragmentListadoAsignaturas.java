package com.pacosignes.fragmentalumnos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentListadoAsignaturas extends Fragment {
    Alumno alumno;
    ArrayList<Asignatura> asignaturas;

    RecyclerView rvNotas;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notas,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        rvNotas=getView().findViewById(R.id.rvNotas);
        RvAdapterNotas adapterNotas=new RvAdapterNotas();
        adapterNotas.setAlumno(alumno);
        adapterNotas.setAsignaturas(asignaturas);
        rvNotas.setAdapter(adapterNotas);
        rvNotas.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL,false));



    }

    public void setAlumno(Alumno a) {
        this.alumno = a;
    }

    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
}
