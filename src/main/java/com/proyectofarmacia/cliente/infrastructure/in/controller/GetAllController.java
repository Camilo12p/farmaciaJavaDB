package com.proyectofarmacia.cliente.infrastructure.in.controller;

import java.util.List;

import com.proyectofarmacia.cliente.application.FindAllUseCase;
import com.proyectofarmacia.cliente.domain.entity.Cliente;
import com.proyectofarmacia.cliente.domain.entity.service.ClienteService;
import com.proyectofarmacia.cliente.infrastructure.out.ClienteMySQLRepository;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/cliente/db/all")
public class GetAllController {
    private ClienteService clienteService = new ClienteMySQLRepository();
    private FindAllUseCase findAllUseCase = new FindAllUseCase(clienteService);


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> getAllClientes(){
        return findAllUseCase.execute();
    }

}
