package com.proyectofarmacia.cliente.domain.entity;

import java.time.LocalDate;

public class Cliente {
    private Long id;
    private int tipoDocumento;
    private String nombres;
    private String apellidos;
    private int edad;
    private LocalDate fechaNacimiento;
    private LocalDate fechaRegistro;
    private int idBarrio;
    



    // constructors 
    public Cliente(Long id,int tipoDocumento, String nombres, String apellidos, int edad, LocalDate fechaNacimiento,
            int idBarrio) {

        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = LocalDate.now();
        this.idBarrio = idBarrio;
    }

    public Cliente(Long id,int tipoDocumento, String nombres, String apellidos, int edad, LocalDate fechaNacimiento,LocalDate fechaRegistro,
            int idBarrio) {

        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = fechaRegistro;
        this.idBarrio = idBarrio;
    }
    
    public Cliente() {
    }





    // getters and setters

    
    public Long getId() {
        return id;
    }
    public int getTipoDocumento() {
        return tipoDocumento;
    }


    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }


    public void setId(Long id) {
        this.id = id;
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

    public int getIdBarrio() {
        return idBarrio;
    }
    public void setIdBarrio(int idBarrio) {
        this.idBarrio = idBarrio;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", tipoDocumento=" + tipoDocumento + ", nombres=" + nombres + ", apellidos="
                + apellidos + ", edad=" + edad + ", fechaNacimiento=" + fechaNacimiento + ", fechaRegistro="
                + fechaRegistro + ", idBarrio=" + idBarrio + "]";
    }


    



}
