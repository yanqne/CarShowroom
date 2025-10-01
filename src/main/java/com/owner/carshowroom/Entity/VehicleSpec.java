package com.owner.carshowroom.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "vehicle_specs",
        indexes = {
                @Index(name = "idx_vehicle_specs_vehicle", columnList = "vehicle_id, sort_order")
        }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleSpec {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Mỗi thông số thuộc 1 Vehicle
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "vehicle_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_vehicle_specs_vehicle")
    )
    private Vehicle vehicle;

    @Column(name = "spec_key", nullable = false, length = 120)
    private String key;

    @Column(name = "spec_value", nullable = false, length = 400)
    private String value;

    @Column(name = "sort_order")
    private Integer sortOrder = 0;
}
