package com.github.throyer.carallocator.repositories;

import com.github.throyer.carallocator.dtos.SimplifiedVehicle;
import com.github.throyer.carallocator.models.vehicle.Queries;
import com.github.throyer.carallocator.models.vehicle.Vehicle;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    /**
     * @param limit
     * @param offset
     * @see {@link Vehicle}
     * @return list of simplified vehicles
     */
    @Query(nativeQuery = true)
    public List<SimplifiedVehicle> findAllSimplified(int limit, int offset);

    /**
     * @see {@link Vehicle}
     * @return count of simplified vehicles
     */
    @Query(value = Queries.COUNT_SIMPLIFIED_VEHICLES, nativeQuery = true)
    public Long countAllSimplified();
}
