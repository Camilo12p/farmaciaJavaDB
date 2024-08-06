package com.proyectofarmacia.direccion.application;

import java.util.List;

import com.proyectofarmacia.direccion.domain.entity.Direccion;
import com.proyectofarmacia.direccion.domain.service.DireccionService;

public class FindAllDireccionUseCase {
    private DireccionService direccionService;

    public FindAllDireccionUseCase(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

    public List<Direccion> execute(){
        return direccionService.findAllDirecciones();
    }

    
    
    
}
