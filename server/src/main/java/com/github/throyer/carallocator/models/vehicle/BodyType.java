package com.github.throyer.carallocator.models.vehicle;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class BodyType {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    
    private String name;
}
