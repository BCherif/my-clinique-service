package com.dev.myclinique.app.entities;

import com.dev.myclinique.base.entity.BaseEntity;
import com.dev.myclinique.utils.Enumeration;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Table(name = "bill")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Bill extends BaseEntity {
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Doctor doctor;
    @Enumerated(EnumType.STRING)
    private Enumeration.BILL_STATE state;
    @Column(name = "bill_date", columnDefinition = "DATETIME")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime billDate;
    private Double tax;
    private Double discount;
    private Double total;
}
