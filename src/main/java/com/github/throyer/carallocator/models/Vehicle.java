package com.github.throyer.carallocator.models;

import java.math.BigDecimal;
import java.util.List;
import static javax.persistence.CascadeType.DETACH;
import javax.persistence.Entity;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private Integer totalKilometers;

    private String licensePlate;

    private Integer numberOfPorts;

    private String color;

    private String year;

    private Integer seats;

    private BigDecimal pricePerDay;

    @ManyToOne(fetch = LAZY)
    private Group group;

    @ManyToOne(fetch = LAZY)
    private Model model;

    @ManyToMany(cascade = DETACH, fetch = LAZY)
    @JoinTable(name = "vehicle_optional",
        joinColumns = {
            @JoinColumn(name = "vehicle_id")},
        inverseJoinColumns = {
            @JoinColumn(name = "optional_id")})
    private List<VehicleOptional> optionals;
    
    @OneToMany(fetch = LAZY)
    private List<VehiclePhoto> photos;
}
