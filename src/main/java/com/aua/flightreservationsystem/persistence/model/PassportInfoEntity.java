package com.aua.flightreservationsystem.persistence.model;

import jakarta.persistence.*;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "passport_info")
@Data
public class PassportInfoEntity extends BaseEntity {
    @Column(name = "passport_n")
    private String passportNumber;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private CountryEntity country;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Temporal(TemporalType.DATE)
    @Column(name = "passport_expires")
    private Date passportExpires;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
}
