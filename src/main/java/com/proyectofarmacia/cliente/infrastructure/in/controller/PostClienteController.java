package com.proyectofarmacia.cliente.infrastructure.in.controller;

import com.proyectofarmacia.cliente.application.CreateClienteUseCase;
import com.proyectofarmacia.cliente.domain.entity.Cliente;
import com.proyectofarmacia.cliente.domain.entity.dto.ClienteDTO;
import com.proyectofarmacia.cliente.domain.entity.service.ClienteService;
import com.proyectofarmacia.cliente.infrastructure.out.ClienteMySQLRepository;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("cliente/registro")
public class PostClienteController {

    ClienteService clienteService = new ClienteMySQLRepository();
    CreateClienteUseCase create = new CreateClienteUseCase(clienteService);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCliente(ClienteDTO clienteDto){
        Cliente cliente = new Cliente(clienteDto);

        create.execute(cliente);

        return Response.status(Status.ACCEPTED).build();
    }
}
