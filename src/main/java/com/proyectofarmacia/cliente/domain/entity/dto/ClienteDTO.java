package com.proyectofarmacia.cliente.domain.entity.dto;

import java.time.LocalDate;

import com.proyectofarmacia.direccion.domain.entity.Direccion;
import com.proyectofarmacia.documento.domain.entity.TipoDocumento;

public class ClienteDTO {
    
        private Long id;
        private TipoDocumento tipoDocumento;
        private String nombres;
        private String apellidos;
        private int edad;
        private LocalDate fechaNacimiento;
        private LocalDate fechaRegistro;
        private String pais;
        private String region;
        private String ciudad;
        private Direccion direccion;
        
    
    
    
        // constructors 
    
        
        public ClienteDTO() {
        }

        public ClienteDTO(Long id,TipoDocumento tipoDocumento, String nombres, String apellidos, int edad, LocalDate fechaNacimiento, 
        LocalDate fechaRegistro, Direccion direccion, String ciudad, String region , String pais) {

                this.id = id;
                this.tipoDocumento = tipoDocumento;
                this.nombres = nombres;
                this.apellidos = apellidos;
                this.edad = edad;
                this.fechaNacimiento = fechaNacimiento;
                this.fechaRegistro = fechaRegistro;
                this.direccion = direccion;
                this.ciudad = ciudad;
                this.region = region;
                this.pais = pais;
        }       
    
    
    
    
    
        // getters and setters
    
   

        public Long getId() {
            return id;
        }

      
        public void setId(Long id) {
            this.id = id;
        }

        public TipoDocumento getTipoDocumento() {
            return tipoDocumento;
        }

        public void setTipoDocumento(TipoDocumento tipoDocumento) {
            this.tipoDocumento = tipoDocumento;
        }

        public String getNombres() {
            return nombres;
        }

        public void setNombres(String nombres) {
            this.nombres = nombres;
        }

        public String getApellidos() {
            return apellidos;
        }

        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
        }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }

        public LocalDate getFechaNacimiento() {
            return fechaNacimiento;
        }

        public void setFechaNacimiento(LocalDate fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
        }

        public LocalDate getFechaRegistro() {
            return fechaRegistro;
        }

        public void setFechaRegistro(LocalDate fechaRegistro) {
            this.fechaRegistro = fechaRegistro;
        }

        public String getPais() {
            return pais;
        }

        public void setPais(String pais) {
            this.pais = pais;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getCiudad() {
            return ciudad;
        }

        public void setCiudad(String ciudad) {
            this.ciudad = ciudad;
        }

        public Direccion getDireccion() {
            return direccion;
        }

        public void setDireccion(Direccion direccion) {
            this.direccion = direccion;
        }
    
       
    
    
        
        // to String 
        @Override
        public String toString() {
            return "ClienteDTO [id=" + id + ", tipoDocumento=" + tipoDocumento + ", nombres=" + nombres + ", apellidos="
                    + apellidos + ", edad=" + edad + ", fechaNacimiento=" + fechaNacimiento + ", fechaRegistro="
                    + fechaRegistro + ", pais=" + pais + ", region=" + region + ", ciudad=" + ciudad + ", barrio="
                    + direccion + "]";
        }

    
    
    }
    
