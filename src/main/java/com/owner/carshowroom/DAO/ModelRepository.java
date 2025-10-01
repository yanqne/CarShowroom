package com.owner.carshowroom.DAO;

import com.owner.carshowroom.DTO.ModelDTO;
import com.owner.carshowroom.DTO.VehicleDTO;
import com.owner.carshowroom.Entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Long> {

    // Lấy tất cả Model dạng DTO (không lấy Vehicle để tránh join phức tạp)
    @Query("SELECT new com.owner.carshowroom.DTO.ModelDTO(" +
            "m.id, m.name, m.slug, m.segment, m.createdAt, " +
            "b.id, b.name, b.slug) " +
            "FROM Model m JOIN m.brand b")
    List<ModelDTO> findAllDTO();
}
