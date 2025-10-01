package com.owner.carshowroom.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(
        name = "vehicle_colors",
        indexes = {
                @Index(name = "idx_vehicle_colors_default", columnList = "vehicle_id, is_default")
        }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(VehicleColor.VehicleColorKey.class)
public class VehicleColor {

    @Id
    @Column(name = "vehicle_id")
    private Long vehicleId;

    @Id
    @Column(name = "color_id")
    private Long colorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "vehicle_id",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "fk_vehicle_colors_vehicle")
    )
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "color_id",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "fk_vehicle_colors_color")
    )
    private Color color;

    @Column(name = "is_default", nullable = false)
    private Boolean isDefault = false;

    // ✅ Inner static class làm composite key
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VehicleColorKey implements Serializable {
        private Long vehicleId;
        private Long colorId;
    }
}
