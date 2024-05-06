package com.aua.flightreservationsystem.persistence.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "flight")
@Data
public class FlightEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "source")
    private CityEntity source;

    @ManyToOne
    @JoinColumn(name = "destination")
    private CityEntity destination;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time")
    private Date time;

    @ManyToOne
    @JoinColumn(name = "airline_id")
    private AirlineEntity airline;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @ManyToMany
    @JoinTable(
            name = "admin_updates",
            joinColumns = @JoinColumn(name = "admin_id"),
            inverseJoinColumns = @JoinColumn(name = "flight_id"))
    private List<AdminEntity> adminUpdated;

    @ManyToMany
    @JoinTable(
            name = "admin_deletes",
            joinColumns = @JoinColumn(name = "admin_id"),
            inverseJoinColumns = @JoinColumn(name = "flight_id"))
    private List<AdminEntity> adminDeleted;

    @ManyToMany
    @JoinTable(
            name = "employee_changes",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "flight_id"))
    private List<EmployeeEntity> employees;
}
