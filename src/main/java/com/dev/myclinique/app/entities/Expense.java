package com.dev.myclinique.app.entities;

import com.dev.myclinique.base.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Table(name = "expense")
@Entity
@Data
@Builder
@AllArgsConstructor
//@NoArgsConstructor
@ToString
public class Expense extends BaseEntity {
}
