package com.proyectofarmacia.producto.domain.entity;

import java.time.LocalDate;

public class Producto {
    private String id;
    private String nombre;
    private int registroInvima;
    private String viaDeAdministracion;
    private String  pricipioActivo;
    private int idUnidadDeMedida;
    private int  idLaboratorio;
    private int  idProveedor;
    private int idPresentacion;
    private LocalDate fechaCaducidad;
    private int  stock;
    private int stockMin;
    private int stockMax;
    private double valor_venta;
   
   
   
    public Producto(String id, String nombre, int registroInvima, String viaDeAdministracion, String pricipioActivo,
            int idUnidadDeMedida, int idLaboratorio, int idProveedor, int idPresentacion, LocalDate fechaCaducidad,
            int stock, int stockMin, int stockMax, double valor_venta) {
        this.id = id;
        this.nombre = nombre;
        this.registroInvima = registroInvima;
        this.viaDeAdministracion = viaDeAdministracion;
        this.pricipioActivo = pricipioActivo;
        this.idUnidadDeMedida = idUnidadDeMedida;
        this.idLaboratorio = idLaboratorio;
        this.idProveedor = idProveedor;
        this.idPresentacion = idPresentacion;
        this.fechaCaducidad = fechaCaducidad;
        this.stock = stock;
        this.stockMin = stockMin;
        this.stockMax = stockMax;
        this.valor_venta = valor_venta;
    }


    public Producto() {
    }



    // getter and setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getRegistroInvima() {
        return registroInvima;
    }
    public void setRegistroInvima(int registroInvima) {
        this.registroInvima = registroInvima;
    }
    public String getViaDeAdministracion() {
        return viaDeAdministracion;
    }
    public void setViaDeAdministracion(String viaDeAdministracion) {
        this.viaDeAdministracion = viaDeAdministracion;
    }
    public String getPricipioActivo() {
        return pricipioActivo;
    }
    public void setPricipioActivo(String pricipioActivo) {
        this.pricipioActivo = pricipioActivo;
    }
    public int getIdUnidadDeMedida() {
        return idUnidadDeMedida;
    }
    public void setIdUnidadDeMedida(int idUnidadDeMedida) {
        this.idUnidadDeMedida = idUnidadDeMedida;
    }
    public int getIdLaboratorio() {
        return idLaboratorio;
    }
    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }
    public int getIdProveedor() {
        return idProveedor;
    }
    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
    public int getIdPresentacion() {
        return idPresentacion;
    }
    public void setIdPresentacion(int idPresentacion) {
        this.idPresentacion = idPresentacion;
    }
    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }
    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public int getStockMin() {
        return stockMin;
    }
    public void setStockMin(int stockMin) {
        this.stockMin = stockMin;
    }
    public int getStockMax() {
        return stockMax;
    }
    public void setStockMax(int stockMax) {
        this.stockMax = stockMax;
    }
    public double getValor_venta() {
        return valor_venta;
    }
    public void setValor_venta(double valor_venta) {
        this.valor_venta = valor_venta;
    }

    
    @Override
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + ", registroInvima=" + registroInvima
                + ", viaDeAdministracion=" + viaDeAdministracion + ", pricipioActivo=" + pricipioActivo
                + ", idUnidadDeMedida=" + idUnidadDeMedida + ", idLaboratorio=" + idLaboratorio + ", idProveedor="
                + idProveedor + ", idPresentacion=" + idPresentacion + ", fechaCaducidad=" + fechaCaducidad + ", stock="
                + stock + ", stockMin=" + stockMin + ", stockMax=" + stockMax + ", valor_venta=" + valor_venta + "]";
    }


    
    
}
