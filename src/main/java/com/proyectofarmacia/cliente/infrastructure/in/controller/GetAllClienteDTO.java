package com.proyectofarmacia.cliente.infrastructure.in.controller;

import java.util.List;

import com.proyectofarmacia.cliente.application.FindAllClienteDTOUseCase;
import com.proyectofarmacia.cliente.domain.entity.dto.ClienteDTO;
import com.proyectofarmacia.cliente.domain.entity.service.ClienteDTOService;
import com.proyectofarmacia.cliente.infrastructure.out.ClienteMySQLRepository;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("cliente/all")
public class GetAllClienteDTO {
    private ClienteDTOService clienteDTOService = new ClienteMySQLRepository();
    private FindAllClienteDTOUseCase findAllClienteDTOUseCase = new FindAllClienteDTOUseCase(clienteDTOService);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ClienteDTO> getAllClienteDTO(){
        return findAllClienteDTOUseCase.execute();
    }


}
