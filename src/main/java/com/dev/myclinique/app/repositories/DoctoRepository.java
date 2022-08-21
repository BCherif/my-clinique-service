package com.dev.myclinique.app.repositories;

import com.dev.myclinique.app.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctoRepository extends JpaRepository<Doctor, Long> {
}
