package com.proyectofarmacia.barrio.domain.service;

import java.util.List;

import com.proyectofarmacia.barrio.domain.entity.Barrio;

public interface BarrioService {
    public void crearBarrio(Barrio barrio);
    public void updateBarrio(Barrio barrio);
    public List<Barrio> findAllBarrio(); //solo para uso 
}
