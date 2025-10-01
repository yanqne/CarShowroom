package com.owner.carshowroom.DAO;

import com.owner.carshowroom.DTO.VehicleColorDTO;
import com.owner.carshowroom.Entity.Color;
import com.owner.carshowroom.Entity.VehicleColor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleColorRepository extends CrudRepository<VehicleColor, Long> {
    @Query("""
    SELECT new com.owner.carshowroom.DTO.VehicleColorDTO(
        vc.vehicle.id,
        vc.color.id,
        vc.vehicle.name,
        vc.color.name,
        vc.isDefault
    )
    FROM VehicleColor vc
    """)
    List<VehicleColorDTO> findAllVehicleColors();

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
