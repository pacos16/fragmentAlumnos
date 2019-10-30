package com.pacosignes.fragmentalumnos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RvAdapterNotas extends RecyclerView.Adapter<RvAdapterNotas.NotasViewHolder> {
    private Alumno alumno;
    private ArrayList<Asignatura> asignaturas;


    @NonNull
    @Override
    public NotasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_notas,parent,false);

        return new NotasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotasViewHolder holder, int position) {

        String codigo=(String)alumno.getNotas().keySet().toArray()[position];
        holder.bind(codigo);
    }

    @Override
    public int getItemCount() {
        return alumno.getNombre().length();
    }

    public class NotasViewHolder extends RecyclerView.ViewHolder{

        private TextView tvCodAsig;
        private TextView tvNomAsig;
        private TextView tvNota;

        public NotasViewHolder(@NonNull View itemView) {
            super(itemView);

            tvCodAsig=itemView.findViewById(R.id.tvCodAsig);
            tvNomAsig=itemView.findViewById(R.id.tvNomAsig);
            tvNota=itemView.findViewById(R.id.tvNota);

        }

        public void bind(String codigo){
            String nomAsig="No hay descripcion";
            for (Asignatura a:asignaturas
                 ) {
                if (codigo.equals(a.getCodAsig())){
                    nomAsig=a.getNomAsig();
                }
            }
            tvCodAsig.setText(codigo);
            tvNota.setText(""+alumno.getNotas().get(codigo));
            tvNomAsig.setText(nomAsig);

        }




    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
}
