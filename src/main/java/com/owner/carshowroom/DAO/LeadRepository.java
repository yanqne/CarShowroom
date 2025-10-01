package com.owner.carshowroom.DAO;

import com.owner.carshowroom.DTO.LeadDTO;
import com.owner.carshowroom.Entity.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LeadRepository extends JpaRepository<Lead, Long> {
    @Query("SELECT NEW com.owner.carshowroom.DTO.LeadDTO(l.id, l.fullName, l.phone, l.email, l.message, l.source, l.status, l.createdAt," +
            "v.id, v.name, v.variant, v.year, v.drivetrain, v.transmission, v.engine, v.powerHp, v.torqueNm, v.fuelConsumption, v.seats, v.dimensions, v.trunkL, v.status, v.thumbnailUrl, v.priceVnd, m.name, b.name)" +
            " FROM Lead l JOIN l.vehicle v JOIN v.model m JOIN m.brand b")
    List<LeadDTO> findAllLeads();
}
