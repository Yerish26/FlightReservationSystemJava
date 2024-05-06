package com.aua.flightreservationsystem.persistence.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "country")
@Data
public class CountryEntity extends BaseEntity {
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "country")
    private List<CityEntity> cities;

    @OneToMany(mappedBy = "country")
    private List<PassportInfoEntity> passportInfoEntities;
}
