package com.pacosignes.fragmentalumnos;

import java.io.Serializable;
import java.util.HashMap;

public class Alumno implements Serializable {
    private int nia;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String fechaNacimiento;
    private String email;
    private HashMap<String,Double> notas;


    public Alumno(int nia, String nombre, String apellido1, String apellido2, String fechaNacimiento, String email, HashMap<String, Double> notas) {
        this.nia = nia;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.notas = notas;
    }

    public Alumno(){
    }


    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNia() {
        return nia;
    }

    public void setNia(int nia) {
        this.nia = nia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public HashMap<String, Double> getNotas() {
        return notas;
    }

    public void setNotas(HashMap<String, Double> notas) {
        this.notas = notas;
    }
}
