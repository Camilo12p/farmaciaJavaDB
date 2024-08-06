package com.proyectofarmacia.cliente.application;

import java.util.List;

import com.proyectofarmacia.cliente.domain.entity.dto.ClienteDTO;
import com.proyectofarmacia.cliente.domain.entity.service.ClienteDTOService;


public class FindAllClienteDTOUseCase {
    private ClienteDTOService clienteDTOService;

    public FindAllClienteDTOUseCase(ClienteDTOService clienteDTOService) {
        this.clienteDTOService = clienteDTOService;
    }
    

    public List<ClienteDTO> execute(){
        return clienteDTOService.findAllClientesDTO();
    }
}
