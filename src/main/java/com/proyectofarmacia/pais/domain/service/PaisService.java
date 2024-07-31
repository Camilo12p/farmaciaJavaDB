package com.proyectofarmacia.pais.domain.service;

import java.util.List;
import java.util.Optional;

import com.proyectofarmacia.pais.domain.entity.Pais;

public interface PaisService {
    public Optional<Pais> getPaisById();
    public List<Pais> getAllPais();

}
