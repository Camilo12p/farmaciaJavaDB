package com.proyectofarmacia.direccion.domain.entity;

public class Direccion {
    private int id;
 
    private String callePrincipal;
    private String interseccion;
    private String detalle;
    private String nombre;
    private int idCiudad;
    
    
    
    // constructores
    public Direccion(){

    }
    
    public Direccion(String callePrincipal, String interseccion, String detalle, String nombre, int idCiudad) {
        this.callePrincipal = callePrincipal;
        this.interseccion = interseccion;
        this.detalle = detalle;
        this.nombre = nombre;
        this.idCiudad = idCiudad;
    }



    // getters and setters 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCallePrincipal() {
        return callePrincipal;
    }
    public void setCallePrincipal(String callePrincipal) {
        this.callePrincipal = callePrincipal;
    }
    public String getInterseccion() {
        return interseccion;
    }
    public void setInterseccion(String interseccion) {
        this.interseccion = interseccion;
    }
    public String getDetalle() {
        return detalle;
    }
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getIdCiudad() {
        return idCiudad;
    }
    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    @Override
    public String toString() {
        return "Barrio [id=" + id + ", callePrincipal=" + callePrincipal + ", interseccion=" + interseccion
                + ", detalle=" + detalle + ", nombre=" + nombre + ", idCiudad=" + idCiudad + "]";
    }


    
}
