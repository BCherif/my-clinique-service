package com.dev.myclinique.app.entities;

import com.dev.myclinique.base.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Table(name = "payment")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payment extends BaseEntity {
}
