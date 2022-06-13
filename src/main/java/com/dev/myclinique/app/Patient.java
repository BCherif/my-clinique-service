package com.dev.myclinique.app;

import com.dev.myclinique.base.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Table(name = "patient")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Patient extends BaseEntity {
    private String firstName;
    private String lastName;
    private String gender;
    private String phone;
    private String address;
    private String father;
    private String mother;
}
