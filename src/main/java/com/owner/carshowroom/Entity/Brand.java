package com.owner.carshowroom.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(
        name = "brands",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_brands_slug", columnNames = "slug")
        }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 120)
    private String name;

    @Column(name = "slug", nullable = false, length = 140)
    private String slug;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // Quan hệ 1-n: một Brand có nhiều Model
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Model> models;
}

