package com.github.throyer.carallocator.models;

import com.github.throyer.carallocator.models.vehicle.Vehicle;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class VehiclePhoto {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    
    private String url;
    
    private Integer order;
    
    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
}
