package com.proyectofarmacia.cliente.domain.entity.service;

import java.util.List;
import java.util.Optional;


import com.proyectofarmacia.cliente.domain.entity.Cliente;

public interface ClienteService {
    public void crearCliente(Cliente cliente);
    public void updateCliente(Cliente cliente);
    public Optional<Cliente> findClienteById(String id);
    public List<Cliente> findAllCliente();
}
