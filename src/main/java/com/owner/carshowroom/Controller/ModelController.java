package com.owner.carshowroom.Controller;

import com.owner.carshowroom.DTO.ModelDTO;
import com.owner.carshowroom.Entity.Model;
import com.owner.carshowroom.Service.ModelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/model")
@CrossOrigin(origins = "http://localhost:3000")
public class ModelController {
    private final ModelService modelService;
    public ModelController(ModelService modelService){
        this.modelService = modelService;
    }
    @GetMapping
    public List<ModelDTO> findAll(){
         return modelService.findAllDTO();
    }
    @PostMapping
    public Model save(@RequestBody Model model){
        return modelService.saveModel(model);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        modelService.deleteModel(id);
    }
}
