package com.dev.myclinique.app.entities;

import com.dev.myclinique.base.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Table(name = "staff")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Staff extends BaseEntity {
    private String fullName;
    @Lob
    private String description;
    private String mobile;
    private String email;
    private String address;
}
