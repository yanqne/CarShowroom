package com.owner.carshowroom.Controller;

import com.owner.carshowroom.DTO.VehicleColorDTO;
import com.owner.carshowroom.Entity.VehicleColor;
import com.owner.carshowroom.Service.VehicleColorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle/color")
public class VehicleColorController {
    private final VehicleColorService vehicleColorService;
    public VehicleColorController(VehicleColorService vehicleColorService) {
        this.vehicleColorService = vehicleColorService;
    }
    @GetMapping
    public List<VehicleColorDTO> findAllVehicleColors() {
        return vehicleColorService.findAllVehicleColors();
    }
    @PostMapping
    public VehicleColor createVehicleColor(@RequestBody VehicleColor vehicleColor) {
        return vehicleColorService.addVehicleColor(vehicleColor);
    }
    @DeleteMapping
    public void deleteVehicleColor(@RequestBody VehicleColor vehicleColor) {
        vehicleColorService.deleteVehicleColor(vehicleColor);
    }
}
