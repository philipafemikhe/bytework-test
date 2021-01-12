package com.servbyte.app.repositories;

import com.servbyte.app.entities.Transporter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransporterRepository extends JpaRepository<Transporter, Long> {
}
