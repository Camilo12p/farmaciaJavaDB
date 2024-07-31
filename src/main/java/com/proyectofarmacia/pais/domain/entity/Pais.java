package com.proyectofarmacia.pais.domain.entity;

public class Pais {

    // attributes
    private int id;
    private String nombrePais;


    // constructors
    public Pais(){}

    public Pais(int id, String nombrePais){
        this.id = id;
        this.nombrePais = nombrePais;
    }


    // getter and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    @Override
    public String toString() {
        return "Pais [id=" + this.id + ", nombrePais=" + this.nombrePais + "]";
    }


    // string 

    

    

}
