package com.proyectofarmacia.region.infrastructure.in.controller;

import java.util.List;

import com.proyectofarmacia.region.application.GetAllRegionUseCase;
import com.proyectofarmacia.region.domain.entity.Region;
import com.proyectofarmacia.region.domain.service.RegionService;
import com.proyectofarmacia.region.infrastructure.out.RegionMySQLRepository;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/region/all")
public class GetAllController {

    private RegionService regionService = new RegionMySQLRepository();
    private GetAllRegionUseCase  getAllRegionUseCase= new GetAllRegionUseCase(regionService);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Region> getAllRegion(){
        return getAllRegionUseCase.execute();
    }


}
