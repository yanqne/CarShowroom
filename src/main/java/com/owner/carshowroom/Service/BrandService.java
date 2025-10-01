package com.owner.carshowroom.Service;

import com.owner.carshowroom.DAO.BrandRepository;
import com.owner.carshowroom.DTO.BrandDTO;
import com.owner.carshowroom.Entity.Brand;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {
    private final BrandRepository brandRepository;

    public  BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }
    public Optional<BrandDTO> findBrandDTOById(Long id) {
        return brandRepository.findAllBrandDTOs().stream()
                .filter(b -> b.getId().equals(id)).findFirst();
    }
    public List<BrandDTO> findallBrandDTO() {
        return brandRepository.findAllBrandDTOs();
    }
    public Brand SaveBrand(Brand brand) {
        return brandRepository.save(brand);
    }
    public Brand updateBrand(Brand brand) {
        return brandRepository.save(brand);
    }
    public void deleteBrand(Long id) {
        brandRepository.deleteById(id);
    }
    public Brand findBrandById(Long id) {
        return brandRepository.findById(id).get();
    }
}
