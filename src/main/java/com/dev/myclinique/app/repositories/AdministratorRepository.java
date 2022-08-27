package com.dev.myclinique.app.repositories;

import com.dev.myclinique.app.entities.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

}
