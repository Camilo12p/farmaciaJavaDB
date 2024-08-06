package com.proyectofarmacia.ciudad.infrastructure.out;

import java.util.List;

import com.proyectofarmacia.ciudad.application.GetAllUseCase;
import com.proyectofarmacia.ciudad.domain.entity.Ciudad;
import com.proyectofarmacia.ciudad.domain.service.CiudadService;
import com.proyectofarmacia.ciudad.infrastructure.in.CiudadMySQLRespository;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("ciudad/all")
public class GetAllController {
   private CiudadService ciudadService = new CiudadMySQLRespository();
   private GetAllUseCase getAllUseCase = new GetAllUseCase(ciudadService);
   
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public List<Ciudad> getAllCiudad(){
    return getAllUseCase.execute();
   }
}
