package com.owner.carshowroom.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleColorDTO {
    private Long vehicleId;
    private Long colorId;

    private String vehicleName;
    private String colorName;

    private Boolean isDefault;
}
