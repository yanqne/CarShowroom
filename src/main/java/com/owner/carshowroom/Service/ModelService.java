package com.owner.carshowroom.Service;

import com.owner.carshowroom.DAO.ModelRepository;
import com.owner.carshowroom.DAO.VehicleRepository;
import com.owner.carshowroom.DTO.ModelDTO;
import com.owner.carshowroom.Entity.Model;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelService {
    private final ModelRepository modelRepository;

    public ModelService(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }
    public List<ModelDTO> findAllDTO() {
        return modelRepository.findAllDTO();
    }
    public Model saveModel(Model model){
        return modelRepository.save(model);
    }
    public void deleteModel(Long id){
        modelRepository.deleteById(id);
    }
    public Model updateModel(Model model){
        return modelRepository.save(model);
    }
}
