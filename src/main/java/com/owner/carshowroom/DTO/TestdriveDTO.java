package com.owner.carshowroom.DTO;

import com.owner.carshowroom.Entity.Lead;
import com.owner.carshowroom.Entity.TestDrive;
import com.owner.carshowroom.Entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestdriveDTO {
    private Long id;
    private LocalDateTime preferredAt;
    private TestDrive.Status status;
    private String note;
    private LocalDateTime createdAt;
    private String lead;
    private String vehicleName;
}
