package com.dev.myclinique.app.entities;

import com.dev.myclinique.base.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Table(name = "category")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Category extends BaseEntity {
    private String name;
    @Lob
    private String description;
}
