package com.owner.carshowroom.DTO;

import com.owner.carshowroom.Entity.Model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ModelDTO {
    private Long id;
    private String name;
    private String slug;
    private Model.Segment segment;   // 👈 enum thay vì String
    private LocalDateTime createdAt;

    private Long brandId;
    private String brandName;
    private String brandSlug;

    public ModelDTO(Long id,
                    String name,
                    String slug,
                    Model.Segment segment,   // 👈 constructor nhận enum
                    LocalDateTime createdAt,
                    Long brandId,
                    String brandName,
                    String brandSlug) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.segment = segment;
        this.createdAt = createdAt;
        this.brandId = brandId;
        this.brandName = brandName;
        this.brandSlug = brandSlug;
    }

    public ModelDTO() {}
}


