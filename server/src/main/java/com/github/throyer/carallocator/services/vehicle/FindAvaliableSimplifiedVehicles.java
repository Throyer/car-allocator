package com.github.throyer.carallocator.services.vehicle;

import com.github.throyer.carallocator.dtos.SimplifiedVehicle;
import com.github.throyer.carallocator.pagination.Page;
import com.github.throyer.carallocator.pagination.Paginator;
import com.github.throyer.carallocator.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindAvaliableSimplifiedVehicles {

    @Autowired
    private VehicleRepository repository;
    
    public Page<SimplifiedVehicle> findAll(Paginator paginator) {
        var limit = paginator.getSize();
        var offset = (limit * (paginator.getPage() + 1)) - limit;
        
        var vehicles = repository.findAllSimplified(limit, offset);
        var count = repository.countAllSimplified();
        
        return new Page(vehicles, count, offset, limit);
    }
}
