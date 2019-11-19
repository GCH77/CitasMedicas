package com.industry.backendcitas.repository;

import com.industry.backendcitas.models.Agenda;
import com.industry.backendcitas.models.Doctores;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Integer> {
    @Query("select a from Agenda a where a.id_doctor = ?1")
    Agenda findAgendaById_doctor(Doctores id);
}
