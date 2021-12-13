package com.github.throyer.carallocator.models.vehicle;

import com.github.throyer.carallocator.dtos.SimplifiedVehicle;
import com.github.throyer.carallocator.models.BodyType;
import com.github.throyer.carallocator.models.Group;
import com.github.throyer.carallocator.models.Model;
import com.github.throyer.carallocator.models.VehicleOptional;
import com.github.throyer.carallocator.models.VehiclePhoto;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import static javax.persistence.CascadeType.DETACH;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@NamedNativeQuery(
    name = "Vehicle.findAllSimplified",
    query = Queries.SELECT_SIMPLIFIED_VEHICLES,
    resultSetMapping = "SimplifiedVehicle"
)
@SqlResultSetMapping(
    name = "SimplifiedVehicle",
    classes = @ConstructorResult(
        targetClass = SimplifiedVehicle.class,        
        columns = {
            @ColumnResult(name = "id", type = long.class),
            @ColumnResult(name = "totalKilometers", type = int.class),
            @ColumnResult(name = "numberOfPorts", type = int.class),
            @ColumnResult(name = "color", type = String.class),
            @ColumnResult(name = "year", type = String.class),
            @ColumnResult(name = "seats", type = int.class),
            @ColumnResult(name = "group", type = String.class),
            @ColumnResult(name = "groupId", type = long.class),
            @ColumnResult(name = "type", type = String.class),
            @ColumnResult(name = "typeId", type = long.class),
            @ColumnResult(name = "model", type = String.class),
            @ColumnResult(name = "modelId", type = long.class),
            @ColumnResult(name = "manufacturer", type = String.class),
            @ColumnResult(name = "manufacturerId", type = long.class),
            @ColumnResult(name = "photo", type = String.class)
        }
    )
)
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

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "body_type_id")
    private BodyType type;

    @ManyToMany(cascade = DETACH, fetch = LAZY)
    @JoinTable(name = "vehicle_optional",
        joinColumns = {
            @JoinColumn(name = "vehicle_id")},
        inverseJoinColumns = {
            @JoinColumn(name = "optional_id")})
    private Set<VehicleOptional> optionals;
    
    @OneToMany(mappedBy = "vehicle", fetch = LAZY)
    private List<VehiclePhoto> photos;
}
