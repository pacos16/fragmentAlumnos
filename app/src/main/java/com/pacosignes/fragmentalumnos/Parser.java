package com.pacosignes.fragmentalumnos;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Parser {


    public ArrayList<Alumno> alumnos;
    public ArrayList<Asignatura> asignaturas;

    private Context context;
    public Parser(Context c){

        this.context=c;
        alumnos=new ArrayList<>();
        asignaturas=new ArrayList<>();
    }

    public void parse(){
        String json=null;
        try {
            InputStream inputStream = context.getResources().openRawResource(R.raw.asignaturas);

            int size = inputStream.available();
            byte[] buffer=new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json=new String(buffer,"UTF-8");
            JSONTokener tokener=new JSONTokener(json);
            JSONArray array=new JSONArray(tokener);

            for(int i=0;i<array.length();i++){

                JSONObject object= array.getJSONObject(i);
                String nombre=object.getString("nomAsig");
                String codigo=object.getString("codAsig");
                asignaturas.add(new Asignatura(nombre,codigo));

            }

            inputStream=context.getResources().openRawResource(R.raw.alumnos_notas);

            size=inputStream.available();
            buffer=new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            json=new String(buffer,"UTF-8");
            tokener= new JSONTokener(json);
            array= new JSONArray(tokener);

            for (int i=0;i<array.length();i++){
                JSONObject object= array.getJSONObject(i);
                int nia;
                String nombre;
                String apellido1;
                String apellido2;
                String fechaDeNacimiento;
                String email;
                HashMap<String,Double> notas=new HashMap<>();

                nia=object.getInt("nia");
                nombre=object.getString("nombre");
                apellido1=object.getString("apellido1");
                apellido2=object.getString("apellido2");
                fechaDeNacimiento=object.getString("fechaNacimiento");
                email= object.getString("email");
                JSONArray arrayNotas= object.getJSONArray("notas");

                for (int j=0;j<arrayNotas.length();j++){
                    JSONObject object1=arrayNotas.getJSONObject(j);
                    notas.put(object1.getString("codAsig"),Double.parseDouble(object1.getString("calificacion")));

                }

                alumnos.add(new Alumno(nia,nombre,apellido1,apellido2,fechaDeNacimiento,email,notas));


            }

        }catch (IOException ioe){

        }catch (JSONException jsone){

        }


    }

}
