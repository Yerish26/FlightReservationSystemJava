package com.aua.flightreservationsystem.persistence.model;

import jakarta.persistence.*;
import java.time.Instant;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
public class BaseEntity extends IdEntity {
    @CreationTimestamp
    @Column(name = "created_on")
    private Instant createdOn;

    @UpdateTimestamp
    @Column(name = "updated_on")
    private Instant lastUpdatedOn;
}
