package com.proyectofarmacia.pais.aplication;

import java.util.List;

import com.proyectofarmacia.pais.domain.entity.Pais;
import com.proyectofarmacia.pais.domain.service.PaisService;

public class GetAllPaiseUseCase {
    private PaisService paisService;

    public GetAllPaiseUseCase(PaisService paisService){
        this.paisService = paisService;
    }

    public List<Pais>execute(){
        return paisService.getAllPais();
    }
}
