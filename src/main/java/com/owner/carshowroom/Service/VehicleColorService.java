package com.owner.carshowroom.Service;

import com.owner.carshowroom.DAO.VehicleColorRepository;
import com.owner.carshowroom.DTO.VehicleColorDTO;
import com.owner.carshowroom.Entity.VehicleColor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleColorService {
    private final VehicleColorRepository vehicleColorRepository;
    public VehicleColorService(VehicleColorRepository vehicleColorRepository) {
        this.vehicleColorRepository = vehicleColorRepository;
    }
    public List<VehicleColorDTO> findAllVehicleColors() {
        return vehicleColorRepository.findAllVehicleColors();
    }
    public VehicleColor addVehicleColor(VehicleColor vehicleColor) {
        return vehicleColorRepository.save(vehicleColor);
    }
    public void deleteVehicleColor(VehicleColor vehicleColor) {
        vehicleColorRepository.delete(vehicleColor);
    }
}
