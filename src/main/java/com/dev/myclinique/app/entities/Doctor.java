package com.dev.myclinique.app.entities;

import com.dev.myclinique.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

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
    private String designation;
    private String gender;
    private String email;
    private String phone;
    private String address;
    private String bloodGroup;
    private String image;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;
    @ManyToOne
    private Speciality speciality;
    @ManyToOne
    private Department department;
}
