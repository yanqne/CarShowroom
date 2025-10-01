package com.owner.carshowroom.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "vehicle_images",
        indexes = {
                @Index(name = "idx_vehicle_images_vehicle", columnList = "vehicle_id, sort_order")
        }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Quan hệ n-1: mỗi ảnh thuộc về một Vehicle
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "vehicle_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_vehicle_images_vehicle")
    )
    private Vehicle vehicle;

    @Column(name = "url", nullable = false, length = 700)
    private String url;

    @Column(name = "alt", length = 200)
    private String alt;

    @Column(name = "sort_order")
    private Integer sortOrder = 0;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}

