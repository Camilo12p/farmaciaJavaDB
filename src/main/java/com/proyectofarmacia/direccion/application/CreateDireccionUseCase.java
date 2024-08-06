package com.proyectofarmacia.direccion.application;

import com.proyectofarmacia.direccion.domain.entity.Direccion;
import com.proyectofarmacia.direccion.domain.service.DireccionService;

public class CreateDireccionUseCase {
    private DireccionService direccionService;

    public CreateDireccionUseCase(DireccionService direccionService) {
        this.direccionService = direccionService;
    }
    
    public void execute(Direccion direccion){
        direccionService.crearDireccion(direccion);
    }
    
}
