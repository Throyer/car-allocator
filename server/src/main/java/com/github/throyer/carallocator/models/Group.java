package com.github.throyer.carallocator.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Group {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;
}
