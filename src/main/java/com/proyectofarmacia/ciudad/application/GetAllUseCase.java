package com.proyectofarmacia.ciudad.application;

import java.util.List;

import com.proyectofarmacia.ciudad.domain.entity.Ciudad;
import com.proyectofarmacia.ciudad.domain.service.CiudadService;


public class GetAllUseCase {
    private CiudadService  ciudadService;

    public GetAllUseCase(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    public List<Ciudad> execute(){
        return ciudadService.getAllCiudad();
    }
    

}
