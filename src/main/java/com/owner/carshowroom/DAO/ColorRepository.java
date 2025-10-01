package com.owner.carshowroom.DAO;

import com.owner.carshowroom.Entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ColorRepository extends JpaRepository<Color, Long> {
    @Query("""
    SELECT new com.owner.carshowroom.Entity.Color(
        c.id,
        c.name,
        c.hex
    )
    FROM VehicleColor vc
    JOIN vc.color c
    WHERE vc.vehicle.id = :vehicleId
    """)
    List<Color> findColorsByVehicleId(Long vehicleId);
}
