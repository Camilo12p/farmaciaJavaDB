package com.proyectofarmacia.barrio.application;

import java.util.List;

import com.proyectofarmacia.barrio.domain.entity.Barrio;
import com.proyectofarmacia.barrio.domain.service.BarrioService;

public class FIndAllBarrioUseCase {
    private BarrioService barrioService;

    public FIndAllBarrioUseCase(BarrioService barrioService) {
        this.barrioService = barrioService;
    }

    public List<Barrio> execute(){
        return barrioService.findAllBarrio();
    }

    
    
    
}
