package com.proyectofarmacia.region.domain.entity;

public class Region {
    private int id;
    private String nombreRegion;
    private int idPais;


    // constructors


    public Region() {
    }
    
    public Region(int id, String nombreRegion, int idPais) {
        this.id = id;
        this.nombreRegion = nombreRegion;
        this.idPais = idPais;
    }


    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreRegion() {
        return nombreRegion;
    }

    public void setNombreRegion(String nombreRegion) {
        this.nombreRegion = nombreRegion;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }


    // toString 
    @Override
    public String toString() {
        return "Region [id=" + id + ", nombreRegion=" + nombreRegion + ", idPais=" + idPais + "]";
    }
    

    
    

}
