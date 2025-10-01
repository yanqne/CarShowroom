package com.owner.carshowroom.Controller;

import com.owner.carshowroom.DTO.BrandDTO;
import com.owner.carshowroom.Entity.Brand;
import com.owner.carshowroom.Service.BrandService;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/brand")
@CrossOrigin(origins = "http://localhost:3000")
public class BrandController {
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public List<BrandDTO> getAllBrands() {
        return brandService.findallBrandDTO();
    }
    @PostMapping
    public Brand save(@RequestBody Brand brand) {
        return brandService.SaveBrand(brand);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@RequestParam Long id) {
        brandService.deleteBrand(id);
    }
    @GetMapping("/{id}")
    public Optional<BrandDTO> findById(@PathVariable Long id) {
        return brandService.findBrandDTOById(id);
    }
}
