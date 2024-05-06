package com.aua.flightreservationsystem.persistence.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "customer")
@Data
public class CustomerEntity extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "customer")
    private List<FlightEntity> flights;
}
