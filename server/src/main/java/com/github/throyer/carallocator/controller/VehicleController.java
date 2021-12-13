package com.github.throyer.carallocator.controller;

import com.github.throyer.carallocator.dtos.SimplifiedVehicle;
import com.github.throyer.carallocator.pagination.Page;
import com.github.throyer.carallocator.pagination.Paginator;
import com.github.throyer.carallocator.services.vehicle.FindAvaliableSimplifiedVehicles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.ResponseEntity.ok;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/vehicles")
public class VehicleController {

    @Autowired
    private FindAvaliableSimplifiedVehicles findService;

    @GetMapping
    public ResponseEntity<Page<SimplifiedVehicle>> index(Paginator paginator) {
        var result = findService.findAll(paginator);
        return ok(result);
    }
}
