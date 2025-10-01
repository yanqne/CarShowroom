package com.owner.carshowroom.Controller;

import com.owner.carshowroom.DTO.TestdriveDTO;
import com.owner.carshowroom.Entity.TestDrive;
import com.owner.carshowroom.Service.TestDriveService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/testdrive")
public class TestDriveController {
    private final TestDriveService testDriveService;
    public TestDriveController(TestDriveService testDriveService) {
        this.testDriveService = testDriveService;
    }
    @GetMapping
    public List<TestdriveDTO> findAll() {
        return testDriveService.findAll();
    }
}
