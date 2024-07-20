package com.proyectofarmacia.barrio.application;

import com.proyectofarmacia.barrio.domain.entity.Barrio;
import com.proyectofarmacia.barrio.domain.service.BarrioService;

public class CreateBarrioUseCase {
    private BarrioService barrioService;

    public CreateBarrioUseCase(BarrioService barrioService) {
        this.barrioService = barrioService;
    }
    
    public void execute(Barrio barrio){
        barrioService.crearBarrio(barrio);
    }
    
}
