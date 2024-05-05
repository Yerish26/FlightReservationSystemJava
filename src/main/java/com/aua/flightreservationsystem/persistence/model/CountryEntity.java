package com.aua.flightreservationsystem.persistence.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "country")
@Data
public class CountryEntity extends BaseEntity {
    @Column(name = "name")
    String name;
}
