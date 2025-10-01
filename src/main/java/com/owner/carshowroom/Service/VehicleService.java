package com.owner.carshowroom.Service;

import com.owner.carshowroom.DAO.*;
import com.owner.carshowroom.DTO.VehicleDTO;
import com.owner.carshowroom.Entity.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;
    private final VehicleColorRepository vehicleColorRepository;

    public VehicleService(VehicleRepository vehicleRepository, VehicleColorRepository vehicleColorRepository) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleColorRepository = vehicleColorRepository;
    }
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }
    public void  deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
    public List<VehicleDTO> getAllvehiclesWithColor() {
        List<VehicleDTO> vehicles = vehicleRepository.findAllVehicleDTOs();

        for (VehicleDTO vehicle : vehicles) {
            List<Color> colors = vehicleColorRepository.findColorsByVehicleId(vehicle.getId());
            vehicle.setColors(colors);
        }
        return vehicles;
    }
    public Optional<VehicleDTO> getVehicleById(Long id) {
        Optional<VehicleDTO> dto = vehicleRepository.findVehicleDTOById(id);
        if(dto.isPresent()) {
            List<Color> colors = vehicleColorRepository.findColorsByVehicleId(id);
            dto.get().setColors(colors);
        }
        return dto;
    }

}
