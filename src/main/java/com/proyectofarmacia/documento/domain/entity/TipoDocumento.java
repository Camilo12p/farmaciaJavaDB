package com.proyectofarmacia.documento.domain.entity;

public class TipoDocumento {

    private int id;
    private String tipoDocumento;
    private int idCiudad;




    // constructors
  
    public TipoDocumento() {
    }
    public TipoDocumento(int id, String tipoDocumento, int idCiudad) {
        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.idCiudad = idCiudad;
    }


    // getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTipoDocumento() {
        return tipoDocumento;
    }
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    public int getIdCiudad() {
        return idCiudad;
    }
    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    
    // to String 
    @Override
    public String toString() {
        return "TipoDocumento [id=" + id + ", tipoDocumento=" + tipoDocumento + ", idCiudad=" + idCiudad + "]";
    }

    

}
