package com.industry.backendcitas.controllers.services;

import com.industry.backendcitas.controllers.repository.CitaRepository;
import com.industry.backendcitas.models.Cita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CitaServiceImpl implements CitaService{
    @Autowired
    private CitaRepository citaRepository;

    @Override
    @Transactional
    public Cita saveCita(Cita cita) {
        return citaRepository.save(cita);
    }
}
