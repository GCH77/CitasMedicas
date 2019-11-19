package com.industry.backendcitas.services;

import com.industry.backendcitas.models.Especialidad;
import com.industry.backendcitas.repository.EspecialidadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadService {
    private final EspecialidadRepository especialidadRepository;

    public EspecialidadService(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    public List<Especialidad> readEspecialidades() {
        return this.especialidadRepository.findAll();
    }

    public Especialidad createEspecialidad(Especialidad especialidad) {
        return this.especialidadRepository.save(especialidad);
    }

    public Especialidad updateEspecialidad(Especialidad especialidad) {
        return this.especialidadRepository.save(especialidad);
    }

    public void deleteEspecilidad(int idEspecialidad) {
        this.especialidadRepository.deleteById(idEspecialidad);
    }

    public Especialidad findById(int id){
        return this.especialidadRepository.findById(id).get();
    }
}
