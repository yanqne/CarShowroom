package com.owner.carshowroom.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "vehicles",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_vehicles_slug", columnNames = "slug")
        },
        indexes = {
                @Index(name = "idx_vehicles_model", columnList = "model_id"),
                @Index(name = "idx_vehicles_price", columnList = "price_vnd")
        }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Liên kết tới bảng models (OneToMany hoặc ManyToOne)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "model_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_vehicles_model")
    )
    private Model model;

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Column(name = "variant", length = 160)
    private String variant;

    @Column(name = "year")
    private Integer year;

    @Column(name = "drivetrain", length = 60)
    private String drivetrain;

    @Column(name = "transmission", length = 60)
    private String transmission;

    @Column(name = "engine", length = 120)
    private String engine;

    @Column(name = "power_hp")
    private Integer powerHp;

    @Column(name = "torque_nm")
    private Integer torqueNm;

    @Column(name = "fuel_consumption", length = 40)
    private String fuelConsumption;

    @Column(name = "seats")
    private Integer seats;

    @Column(name = "dimensions", length = 120)
    private String dimensions;

    @Column(name = "trunk_l")
    private Integer trunkL;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "ENUM('New','InStock','Coming','Discontinued') default 'New'")
    private VehicleStatus status = VehicleStatus.New;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "thumbnail_url", length = 600)
    private String thumbnailUrl;

    @Column(name = "price_vnd")
    private Long priceVnd;

    @Column(name = "slug", nullable = false, length = 200)
    private String slug;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Enum tương ứng với trường status
    public enum VehicleStatus {
        New,
        InStock,
        Coming,
        Discontinued
    }
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
