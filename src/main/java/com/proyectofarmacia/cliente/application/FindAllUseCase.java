package com.proyectofarmacia.cliente.application;

import java.util.List;

import com.proyectofarmacia.cliente.domain.entity.Cliente;
import com.proyectofarmacia.cliente.domain.service.ClienteService;

public class FindAllUseCase {
    private ClienteService clienteService;

    public FindAllUseCase (ClienteService clienteService){
        this.clienteService = clienteService;
    }

    public List<Cliente> execute(){
        return clienteService.findAllCliente();
    }

}
