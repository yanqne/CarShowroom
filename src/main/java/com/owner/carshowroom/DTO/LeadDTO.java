package com.owner.carshowroom.DTO;

import com.owner.carshowroom.Entity.Color;
import com.owner.carshowroom.Entity.Lead;
import com.owner.carshowroom.Entity.TestDrive;
import com.owner.carshowroom.Entity.Vehicle;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Data
public class LeadDTO {
    private Long id;
    private String fullName;
    private String phone;
    private String email;
    private String message;
    private Lead.Source source;
    private Lead.Status Status;
    private LocalDateTime createdAt;

//    private List<TestDrive> testDrives;

    private VehicleDTO vehicles;

    public LeadDTO(Long id, String fullName, String phone, String email, String message,
                   Lead.Source source, Lead.Status status, LocalDateTime createdAt,
                   Long vehicleId, String name, String variant, Integer year,
                   String drivetrain, String transmission, String engine,
                   Integer powerHp, Integer torqueNm, String fuelConsumption,
                   Integer seats, String dimensions, Integer trunkL,
                   Vehicle.VehicleStatus vehicleStatus, String thumbnailUrl,
                   Long priceVnd, String modelName, String brandName) {

        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.message = message;
        this.source = source;
        this.Status = status;
        this.createdAt = createdAt;

        this.vehicles = new VehicleDTO(
                vehicleId, name, variant, year, drivetrain, transmission, engine,
                powerHp, torqueNm, fuelConsumption, seats, dimensions, trunkL,
                vehicleStatus, thumbnailUrl, priceVnd, modelName, brandName
        );
    }



}
