package com.owner.carshowroom.DAO;

import com.owner.carshowroom.DTO.BrandDTO;
import com.owner.carshowroom.Entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    @Query("SELECT new com.owner.carshowroom.DTO.BrandDTO(" +
            "b.id, b.name, b.slug, b.createdAt)" +
            "FROM Brand b")
    List<BrandDTO> findAllBrandDTOs();

    @Query("SELECT new com.owner.carshowroom.DTO.BrandDTO(" +
            "b.id, b.name, b.slug, b.createdAt)" +
            "FROM Brand b where b.id = :id")
    Optional<BrandDTO> findBrandDTOById(@Param("id") Long id);

}
