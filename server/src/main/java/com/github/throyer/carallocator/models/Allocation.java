package com.github.throyer.carallocator.models;

import com.github.throyer.carallocator.models.vehicle.Vehicle;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Allocation {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    
    private LocalDateTime startDate;
    
    private LocalDateTime expectedEndDate;
    
    private LocalDateTime endDate;
    
    private String driversLicense;
    
    @ManyToOne(fetch = LAZY)
    private User user;
    
    @ManyToOne(fetch = LAZY)
    private Vehicle vehicle;
}
