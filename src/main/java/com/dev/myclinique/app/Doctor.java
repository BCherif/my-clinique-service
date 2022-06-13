package com.dev.myclinique.app;

import com.dev.myclinique.base.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Table(name = "doctor")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Doctor extends BaseEntity {
    private String firstName;
    private String lastName;
    private String gender;
    private String phone;
    @ManyToOne
    private Speciality speciality;
    @ManyToOne
    private Department department;
}
