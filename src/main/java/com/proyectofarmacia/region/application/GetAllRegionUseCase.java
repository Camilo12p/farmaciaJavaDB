package com.proyectofarmacia.region.application;

import java.util.List;

import com.proyectofarmacia.region.domain.entity.Region;
import com.proyectofarmacia.region.domain.service.RegionService;

public class GetAllRegionUseCase {
    private RegionService regionService;

    public GetAllRegionUseCase(RegionService regionService) {
        this.regionService = regionService;
    }

    public List<Region> execute(){
        return regionService.getAllRegion();
    }
    
}
