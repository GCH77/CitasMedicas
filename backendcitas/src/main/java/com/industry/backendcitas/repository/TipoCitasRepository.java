package com.industry.backendcitas.repository;

import com.industry.backendcitas.models.TipoCitas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCitasRepository extends JpaRepository<TipoCitas, Integer> {
}
