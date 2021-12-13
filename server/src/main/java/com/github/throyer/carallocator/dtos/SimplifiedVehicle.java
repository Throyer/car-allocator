package com.github.throyer.carallocator.dtos;

import java.util.Objects;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SimplifiedVehicle {

    private Long id;
    private Integer totalKilometers;
    private Integer numberOfPorts;
    private String color;
    private String year;
    private int seats;
    
    private SimplifiedRelation group;
    private SimplifiedRelation bodyType;
    private SimplifiedRelation model;
    
    private String photo;

    public SimplifiedVehicle(
        long id,
        int totalKilometers,
        int numberOfPorts,
        String color,
        String year,
        int seats,
        String group,
        long groupId,
        String type,
        long typeId,
        String model,
        long modelId,
        String manufacturer,
        long manufacturerId,
        String photo
    ) {
        this.id = id;
        this.totalKilometers = totalKilometers;
        this.numberOfPorts = numberOfPorts;
        this.color = color;
        this.year = year;
        this.seats = seats;
        this.group = new SimplifiedRelation(groupId, group);
        this.bodyType = new SimplifiedRelation(typeId, type);
        this.model = new SimplifiedModel(modelId, model, new SimplifiedRelation(manufacturerId, manufacturer));
        this.photo = photo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SimplifiedVehicle other = (SimplifiedVehicle) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    @Data
    @NoArgsConstructor
    private class SimplifiedRelation {    
        private Long id;
        private String name;
        
        public SimplifiedRelation(Long id, String name) {
            this.id = id;
            this.name = name;
        }
    }
    
    @Data
    @NoArgsConstructor
    private class SimplifiedModel extends SimplifiedRelation {
        private SimplifiedRelation manufacturer;

        public SimplifiedModel(Long id, String name, SimplifiedRelation manufacturer) {
            super(id, name);
            this.manufacturer = manufacturer;
        }
        
    }
}
