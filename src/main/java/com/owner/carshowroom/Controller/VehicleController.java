package com.owner.carshowroom.Controller;

import com.owner.carshowroom.DTO.VehicleDTO;
import com.owner.carshowroom.Entity.Vehicle;
import com.owner.carshowroom.Service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle")
@CrossOrigin(origins = "http://localhost:3000")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }
    @GetMapping
    public List<VehicleDTO> findAll() {
        return vehicleService.getAllvehiclesWithColor();
    }
    @GetMapping("/{id}")
    public VehicleDTO getVehicleById(@PathVariable Long id) {
        return vehicleService.getVehicleById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle with id " + id + " not found"));
    }
    @PostMapping
    public Vehicle saveVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.saveVehicle(vehicle);
    }
    @DeleteMapping("/{Id}")
    public void deleteVehicleById(@PathVariable Long Id) {
        vehicleService.deleteVehicle(Id);
    }
}
