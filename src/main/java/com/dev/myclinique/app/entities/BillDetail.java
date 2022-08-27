package com.dev.myclinique.app.entities;

import com.dev.myclinique.base.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Table(name = "bill_detail")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BillDetail extends BaseEntity {
    @ManyToOne
    private Bill bill;
    @ManyToOne
    private Product product;
    private Integer quantity;
    private Integer discount;
    private Double total;
}
