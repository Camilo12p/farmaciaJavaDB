package com.proyectofarmacia.producto.application;

import com.proyectofarmacia.producto.domain.entity.Producto;
import com.proyectofarmacia.producto.domain.entity.service.ProductoService;

public class CreateCaseUseCase {
    private ProductoService productoService;

    public CreateCaseUseCase(ProductoService productoService) {
        this.productoService = productoService;
    }

    public void execute(Producto producto){
        productoService.crearProducto(producto);
    }
    
}
