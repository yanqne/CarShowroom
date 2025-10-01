package com.owner.carshowroom.DTO;

import com.owner.carshowroom.Entity.Color;
import com.owner.carshowroom.Entity.Vehicle;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class VehicleDTO {
    private Long id;
    private String name;
    private String variant;
    private Integer year;
    private String drivetrain;
    private String transmission;
    private String engine;
    private Integer powerHp;
    private Integer torqueNm;
    private String fuelConsumption;
    private Integer seats;
    private String dimensions;
    private Integer trunkL;
    private Vehicle.VehicleStatus status;  // 👈 Enum
    private String thumbnailUrl;
    private Long priceVnd;

    private String modelName;
    private String brandName;
    private List<Color> colors = new ArrayList<>();

    // ✅ Constructor cho JPQL query
    public VehicleDTO(Long id,
                      String name,
                      String variant,
                      Integer year,
                      String drivetrain,
                      String transmission,
                      String engine,
                      Integer powerHp,
                      Integer torqueNm,
                      String fuelConsumption,
                      Integer seats,
                      String dimensions,
                      Integer trunkL,
                      Vehicle.VehicleStatus status,
                      String thumbnailUrl,
                      Long priceVnd,
                      String modelName,
                      String brandName) {
        this.id = id;
        this.name = name;
        this.variant = variant;
        this.year = year;
        this.drivetrain = drivetrain;
        this.transmission = transmission;
        this.engine = engine;
        this.powerHp = powerHp;
        this.torqueNm = torqueNm;
        this.fuelConsumption = fuelConsumption;
        this.seats = seats;
        this.dimensions = dimensions;
        this.trunkL = trunkL;
        this.status = status;
        this.thumbnailUrl = thumbnailUrl;
        this.priceVnd = priceVnd;
        this.modelName = modelName;
        this.brandName = brandName;
    }

    public VehicleDTO() {}
}