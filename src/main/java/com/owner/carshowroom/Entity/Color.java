package com.owner.carshowroom.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "colors",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_colors_name", columnNames = "name")
        }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @Column(name = "hex", length = 7)
    private String hex;
}

