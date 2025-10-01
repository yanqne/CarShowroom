package com.owner.carshowroom.DAO;

import com.owner.carshowroom.DTO.TestdriveDTO;
import com.owner.carshowroom.Entity.TestDrive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TestDriveRepository extends JpaRepository<TestDrive, Integer>{
@Query("SELECT new com.owner.carshowroom.DTO.TestdriveDTO(" +
        "t.id, t.preferredAt, t.status, t.note, t.createdAt, l.fullName, v.name)" +
        "FROM TestDrive t JOIN t.vehicle v join t.lead l")
List<TestdriveDTO> findAllDTO();
}
