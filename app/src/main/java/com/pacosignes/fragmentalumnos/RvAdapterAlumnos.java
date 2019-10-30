package com.pacosignes.fragmentalumnos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RvAdapterAlumnos extends RecyclerView.Adapter<RvAdapterAlumnos.AlumnosViewHolder> {
    private Context context;
    private ArrayList<Alumno> alumnos;
    private IAlumnoListener listener;


    public RvAdapterAlumnos(Fragment fragment, ArrayList<Alumno> alumnos,IAlumnoListener listener){
        this.context=fragment.getContext();
        this.alumnos=alumnos;
        this.listener=listener;
    }
    @NonNull
    @Override
    public AlumnosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_alumnos,parent,false);
        return new AlumnosViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull AlumnosViewHolder holder, int position) {
            holder.bind(alumnos.get(position));
    }

    @Override
    public int getItemCount() {
        return alumnos.size();
    }



    public class AlumnosViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tvNombre;
        TextView tvEmail;
        TextView tvEdad;
        private IAlumnoListener listener;

        public AlumnosViewHolder(@NonNull View itemView,IAlumnoListener listener ) {
            super(itemView);
            this.tvNombre = itemView.findViewById(R.id.tvNombre);
            this.tvEmail = itemView.findViewById(R.id.tvEmail);
            this.tvEdad =itemView.findViewById(R.id.tvEdad);
            this.listener=listener;

            itemView.setOnClickListener(this);
        }

        public void bind(Alumno a){
            StringBuilder sb=new StringBuilder();
            sb.append(a.getNombre()).append(" ")
                    .append(a.getApellido1()).append(" ").append(a.getApellido2());
            tvNombre.setText(sb.toString());
            tvEmail.setText(a.getEmail());
        }

        @Override
        public void onClick(View v) {
            listener.onAlumnoSeleccionado(getAdapterPosition());
        }
    }
}
