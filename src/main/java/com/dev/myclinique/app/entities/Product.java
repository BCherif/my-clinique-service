package com.dev.myclinique.app.entities;

import com.dev.myclinique.base.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Table(name = "product")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product extends BaseEntity {
    @ManyToOne
    private Category category;
    private String name;
    private Integer quantity;
    private Integer price;
    private String description;
}
