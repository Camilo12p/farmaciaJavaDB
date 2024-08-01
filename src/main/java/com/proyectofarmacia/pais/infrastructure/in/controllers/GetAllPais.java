package com.proyectofarmacia.pais.infrastructure.in.controllers;


import java.util.List;


import com.proyectofarmacia.pais.aplication.GetAllPaiseUseCase;
import com.proyectofarmacia.pais.domain.entity.Pais;
import com.proyectofarmacia.pais.domain.service.PaisService;
import com.proyectofarmacia.pais.infrastructure.out.PaisMySQLRepository;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/pais/all")
public class GetAllPais {

    private PaisService paisService = new PaisMySQLRepository();
    private GetAllPaiseUseCase getAllPaiseUseCase = new GetAllPaiseUseCase(paisService);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pais> getAllPais(){
        return getAllPaiseUseCase.execute();
    }

}
