package com.industry.backendcitas.controllers.services;

import com.industry.backendcitas.controllers.repository.EspecialidadRepository;
import com.industry.backendcitas.models.Especialidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class EspecialidadServiceImpl implements EspecialidadService{
    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Override
    @Transactional
    public Especialidad saveEspecialidad(Especialidad especialidad){
        return especialidadRepository.save(especialidad);
    }
}
