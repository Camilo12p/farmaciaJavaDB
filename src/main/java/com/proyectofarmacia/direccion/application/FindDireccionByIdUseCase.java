package com.proyectofarmacia.direccion.application;

import java.util.Optional;

import com.proyectofarmacia.direccion.domain.entity.Direccion;
import com.proyectofarmacia.direccion.domain.service.DireccionService;

public class FindDireccionByIdUseCase {
    private DireccionService direccionService;

    public FindDireccionByIdUseCase(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

    public Optional<Direccion> execute(int id){
        return direccionService.findDireccionById(id);
    }

}
