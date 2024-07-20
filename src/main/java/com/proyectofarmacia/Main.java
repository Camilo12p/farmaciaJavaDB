package com.proyectofarmacia;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.xml.crypto.Data;

import com.proyectofarmacia.barrio.application.CreateBarrioUseCase;
import com.proyectofarmacia.barrio.application.FIndAllBarrioUseCase;
import com.proyectofarmacia.barrio.domain.entity.Barrio;
import com.proyectofarmacia.barrio.domain.service.BarrioService;
import com.proyectofarmacia.barrio.infrastructure.BarrioRepository;
import com.proyectofarmacia.cliente.domain.entity.Cliente;
import com.proyectofarmacia.cliente.domain.service.ClienteService;
import com.proyectofarmacia.cliente.infrastructure.out.ClienteRepository;

public class Main {
    public static void main(String[] args) {
        // ClienteService clienteService = new ClienteRepository();
        // BarrioService barrioService = new BarrioRepository();
        
        // CreateBarrioUseCase useCaseBarrio = new CreateBarrioUseCase(barrioService);
        // FIndAllBarrioUseCase fIndAllBarrioUseCase = new FIndAllBarrioUseCase(barrioService);

        // Barrio barrio = new Barrio("27a", "22", "Casa de dos pisos", "real de minas", 1);

        // useCaseBarrio.execute(barrio);
        
        // List<Barrio> barrios = fIndAllBarrioUseCase.execute(); 
        // if(barrios.size() == 0){
        //     System.out.println("no tiene nada de datos");
        // }
        // barrios.forEach(System.out::println);

        // Cliente cliente = new Cliente(Long.valueOf(100057221),1,"WIlmer Camilo","Patiño Martinez",22,LocalDate.of(2002, 05, 20),4);

        // // clienteService.crearCliente(cliente);

        // List<Cliente> clientes = clienteService.findAllCliente();
        // clientes.forEach(System.out::println);


    }
}