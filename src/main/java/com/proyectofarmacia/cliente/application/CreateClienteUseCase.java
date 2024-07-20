package com.proyectofarmacia.cliente.application;

import com.proyectofarmacia.cliente.domain.entity.Cliente;
import com.proyectofarmacia.cliente.domain.service.ClienteService;

public class CreateClienteUseCase {
    private ClienteService clienteService;

    public CreateClienteUseCase ( ClienteService clienteService){
        this.clienteService = clienteService;
    }

    public void execute(Cliente cliente){
        clienteService.crearCliente(cliente);
    }
}
