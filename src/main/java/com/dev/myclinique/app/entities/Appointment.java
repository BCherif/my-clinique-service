package com.dev.myclinique.app.entities;

import com.dev.myclinique.base.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Table(name = "appointment")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Appointment extends BaseEntity {
    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Department department;
    @ManyToOne
    private Patient patient;

}
