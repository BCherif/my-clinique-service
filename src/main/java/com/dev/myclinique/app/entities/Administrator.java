package com.dev.myclinique.app.entities;

import com.dev.myclinique.auth.entity.User;
import com.dev.myclinique.base.entity.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Table(name = "administrator")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Administrator extends BaseEntity {
    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Column(name = "firstname", nullable = false)
    private String firstName;
    @ManyToOne
    private User user;
}
