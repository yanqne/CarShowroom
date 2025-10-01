package com.owner.carshowroom.Service;

import com.owner.carshowroom.DAO.TestDriveRepository;
import com.owner.carshowroom.DTO.TestdriveDTO;
import com.owner.carshowroom.Entity.TestDrive;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestDriveService {
    private final TestDriveRepository testDriveRepository;

    public TestDriveService(TestDriveRepository testDriveRepository) {
        this.testDriveRepository = testDriveRepository;
    }
    public List<TestdriveDTO> findAll() {
        return testDriveRepository.findAllDTO();
    }
}
