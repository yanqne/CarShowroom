package com.owner.carshowroom.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "test_drives",
        indexes = {
                @Index(name = "idx_test_drives_vehicle", columnList = "vehicle_id, status, preferred_at")
        }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestDrive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Người đăng ký test drive
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "lead_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_test_drives_lead")
    )
    private Lead lead;

    // Xe muốn test drive
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "vehicle_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_test_drives_vehicle")
    )
    private Vehicle vehicle;

    @Column(name = "preferred_at")
    private LocalDateTime preferredAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "ENUM('Requested','Confirmed','Completed','Cancelled') default 'Requested'")
    private Status status = Status.Requested;

    @Column(name = "note", length = 300)
    private String note;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public enum Status {
        Requested, Confirmed, Completed, Cancelled
    }
}
