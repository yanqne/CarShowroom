package com.owner.carshowroom.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandDTO {
    private Long id;
    private String name;
    private String slug;
    private LocalDateTime createdAt;
}
