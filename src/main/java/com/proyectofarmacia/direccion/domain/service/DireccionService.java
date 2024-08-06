package com.proyectofarmacia.direccion.domain.service;

import java.util.List;
import java.util.Optional;

import com.proyectofarmacia.direccion.domain.entity.Direccion;

public interface DireccionService {
    public void crearDireccion(Direccion barrio);
    public void updateDireccion(Direccion barrio);
    public List<Direccion> findAllDirecciones(); //solo para uso 
    public Optional<Direccion> findDireccionById(int id);
}
