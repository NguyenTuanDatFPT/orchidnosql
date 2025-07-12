package com.tri.revision.orchild.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "orchids")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Orchid {
    @Id
    private String id;

    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private String imageUrl;
    private String origin;
    private String color;
    private String size;
    private boolean isNatural;
    private boolean isAvailable;
    private String createdBy;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
