package com.github.throyer.carallocator.models.vehicle;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "optional")
@NoArgsConstructor
public class VehicleOptional {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;
}
