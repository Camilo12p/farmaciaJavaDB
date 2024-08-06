package com.proyectofarmacia.cliente.domain.entity.service;

import java.util.List;

import com.proyectofarmacia.cliente.domain.entity.dto.ClienteDTO;

public interface ClienteDTOService {
    public List<ClienteDTO> findAllClientesDTO ();
}
