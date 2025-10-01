package com.owner.carshowroom.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(
        name = "leads",
        indexes = {
                @Index(name = "idx_leads_vehicle", columnList = "vehicle_id, status, created_at")
        }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false, length = 140)
    private String fullName;

    @Column(name = "phone", nullable = false, length = 40)
    private String phone;

    @Column(name = "email", length = 160)
    private String email;

    @Column(name = "message", columnDefinition = "TEXT")
    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "vehicle_id",
            foreignKey = @ForeignKey(name = "fk_leads_vehicle")
    )
    private Vehicle vehicle;

    @Enumerated(EnumType.STRING)
    @Column(name = "source", columnDefinition = "ENUM('Website','Facebook','Zalo','Phone','Other') default 'Website'")
    private Source source = Source.Website;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "ENUM('New','Contacted','Qualified','Won','Lost') default 'New'")
    private Status status = Status.New;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "lead", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TestDrive> testDrives;

    public enum Source {
        Website, Facebook, Zalo, Phone, Other
    }

    public enum Status {
        New, Contacted, Qualified, Won, Lost
    }
}
