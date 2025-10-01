package com.owner.carshowroom.DAO;

import com.owner.carshowroom.DTO.ModelDTO;
import com.owner.carshowroom.Entity.Color;
import com.owner.carshowroom.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import com.owner.carshowroom.DTO.VehicleDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    @Query("SELECT new com.owner.carshowroom.DTO.VehicleDTO(" +
            "v.id, v.name, v.variant, v.year, v.drivetrain, v.transmission, v.engine, " +
            "v.powerHp, v.torqueNm, v.fuelConsumption, v.seats, v.dimensions, v.trunkL, " +
            "v.status, v.thumbnailUrl, v.priceVnd, m.name, b.name) " +
            "FROM Vehicle v " +
            "JOIN v.model m " +
            "JOIN m.brand b " +
            "WHERE v.id = :id")
    Optional<VehicleDTO> findVehicleDTOById(@Param("id") Long id);

    @Query("SELECT new com.owner.carshowroom.DTO.VehicleDTO(" +
            "v.id, v.name, v.variant, v.year, v.drivetrain, v.transmission, v.engine, " +
            "v.powerHp, v.torqueNm, v.fuelConsumption, v.seats, v.dimensions, v.trunkL, " +
            "v.status, v.thumbnailUrl, v.priceVnd, m.name, b.name) " +
            "FROM Vehicle v " +
            "JOIN v.model m " +
            "JOIN m.brand b")
    List<VehicleDTO> findAllVehicleDTOs();

    @Query("SELECT new com.owner.carshowroom.Entity.Color(c.id, c.name, c.hex) FROM VehicleColor vc JOIN vc.color c WHERE vc.vehicle.id = :vehicleId")
    List<Color> findColorByVehicleId(Long vehicleId);
}
