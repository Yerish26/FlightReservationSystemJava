package com.aua.flightreservationsystem.persistence.repository.admin;

import com.aua.flightreservationsystem.persistence.model.AdminEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminEntity, UUID> {}
