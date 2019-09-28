package com.industry.backendcitas.controllers.services;

import com.industry.backendcitas.controllers.repository.PersonaRepository;
import com.industry.backendcitas.models.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    private PersonaRepository personaRepository;

    @Override
    @Transactional
    public Persona savePersona(Persona persona) {
        return personaRepository.save(persona);
    }
}
