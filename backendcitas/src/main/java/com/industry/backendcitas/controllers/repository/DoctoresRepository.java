package com.industry.backendcitas.controllers.repository;

import com.industry.backendcitas.models.Doctores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctoresRepository extends JpaRepository<Doctores, Integer> {
}
