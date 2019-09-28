package com.industry.backendcitas.services;

import com.industry.backendcitas.models.Cita;
import com.industry.backendcitas.repository.CitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService {
    private final CitaRepository citaRepository;

    public CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public List<Cita> readCitas() {
        return this.citaRepository.findAll();
    }

    public Cita createCita(Cita cita) {
        return this.citaRepository.save(cita);
    }

    public Cita updateCita(Cita cita) {
        return this.citaRepository.save(cita);
    }

    public void deleteCita(int idCita) {
        this.citaRepository.deleteById(idCita);
    }
}
