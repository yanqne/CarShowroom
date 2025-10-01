package com.owner.carshowroom.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(
        name = "models",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_models_slug", columnNames = "slug")
        },
        indexes = {
                @Index(name = "idx_models_brand", columnList = "brand_id")
        }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Liên kết tới bảng brands (ManyToOne)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "brand_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_models_brand")
    )
    private Brand brand;

    @Column(name = "name", nullable = false, length = 160)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "segment",
            columnDefinition = "ENUM('Sedan','SUV','Hatchback','Crossover','Pickup','Coupe','MPV','Other') default 'Other'"
    )
    private Segment segment = Segment.Other;

    @Column(name = "slug", nullable = false, length = 180)
    private String slug;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // Quan hệ 1-n: một Model có thể có nhiều Vehicle
    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vehicle> vehicles;

    // Enum mapping cho segment
    public enum Segment {
        Sedan,
        SUV,
        Hatchback,
        Crossover,
        Pickup,
        Coupe,
        MPV,
        Other
    }
}

