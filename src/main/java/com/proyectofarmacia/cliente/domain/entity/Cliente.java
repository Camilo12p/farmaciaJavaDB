package com.proyectofarmacia.cliente.domain.entity;

import java.time.LocalDate;

import com.proyectofarmacia.cliente.domain.entity.dto.ClienteDTO;
import com.proyectofarmacia.direccion.domain.entity.Direccion;

public class Cliente {
    private Long id;
    private int tipoDocumento;
    private String nombres;
    private String apellidos;
    private int edad;
    private LocalDate fechaNacimiento;
    private LocalDate fechaRegistro;
    private Direccion direccion;
    



    // constructors 
    // para crear un nuevo cliente
    public Cliente(ClienteDTO clienteDTO) {

        this.id = clienteDTO.getId();
        this.tipoDocumento = clienteDTO.getTipoDocumento().getId();
        this.nombres = clienteDTO.getNombres();
        this.apellidos = clienteDTO.getApellidos();
        this.edad = clienteDTO.getEdad();
        this.fechaNacimiento = clienteDTO.getFechaNacimiento();
        this.fechaRegistro = LocalDate.now();
        this.direccion = direccion;
    }


    // Para obtener los datos 
    public Cliente(Long id,int tipoDocumento, String nombres, String apellidos, int edad, LocalDate fechaNacimiento,LocalDate fechaRegistro,
            Direccion direccion) {

        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = fechaRegistro;
        this.direccion = direccion;
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

    public Direccion getDireccion() {
        return direccion;
    }
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", tipoDocumento=" + tipoDocumento + ", nombres=" + nombres + ", apellidos="
                + apellidos + ", edad=" + edad + ", fechaNacimiento=" + fechaNacimiento + ", fechaRegistro="
                + fechaRegistro + ", idBarrio=" + direccion + "]";
    }


    



}
