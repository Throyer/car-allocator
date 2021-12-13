package com.github.throyer.carallocator.services.vehicle;

import com.github.throyer.carallocator.dtos.SimplifiedVehicle;
import com.github.throyer.carallocator.pagination.Page;
import com.github.throyer.carallocator.pagination.Paginator;
import com.github.throyer.carallocator.repositories.VehicleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindAvailableSimplifiedVehicles {

    @Autowired
    private VehicleRepository repository;
    
    public Page<SimplifiedVehicle> findAll(Paginator paginator) {
        var limit = paginator.getLimit();
        var offset = paginator.getOffset();
        
        var vehicles = repository.findAllSimplified(limit, offset);
        var count = repository.countAllSimplified();
        
        Page<SimplifiedVehicle> page = new Page<>(vehicles, count, paginator);

        return page;
    }
}
