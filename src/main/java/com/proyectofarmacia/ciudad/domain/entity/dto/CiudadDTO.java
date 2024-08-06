package com.proyectofarmacia.ciudad.domain.entity.dto;

public class CiudadDTO {

        private int id;
        private String nombreCiudad;
        private int idRegion;
    
        
    
    
        public CiudadDTO(int id, String nombreCiudad, int idRegion) {
            this.id = id;
            this.nombreCiudad = nombreCiudad;
            this.idRegion = idRegion;
        }
    
    
        public CiudadDTO(){
    
        }
    
        
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getNombreCiudad() {
            return nombreCiudad;
        }
        public void setNombreCiudad(String nombreCiudad) {
            this.nombreCiudad = nombreCiudad;
        }
        public int getIdRegion() {
            return idRegion;
        }
        public void setIdRegion(int idRegion) {
            this.idRegion = idRegion;
        }
    
        
    
    }
    
