package com.pacosignes.fragmentalumnos;

import java.io.Serializable;

public class Asignatura implements Serializable {

    private String codAsig;
    private String nomAsig;
    public Asignatura(){}

    public Asignatura(String nombre,String codigo){
        nomAsig=nombre;
        codAsig=codigo;
    }

    public String getCodAsig() {
        return codAsig;
    }

    public void setCodAsig(String codAsig) {
        this.codAsig = codAsig;
    }

    public String getNomAsig() {
        return nomAsig;
    }

    public void setNomAsig(String nomAsig) {
        this.nomAsig = nomAsig;
    }

}
