package com.industry.backendcitas.services;

import com.industry.backendcitas.models.Persona;
import com.industry.backendcitas.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {
    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> readPersonas() {
        return this.personaRepository.findAll();
    }

    public Persona createPersona(Persona persona) {
        return this.personaRepository.save(persona);
    }

    public void deletePersona(int idPersona) {
        this.personaRepository.deleteById(idPersona);
    }

    public Persona findPersonaByIdentificacion(int tipo, String identificacion){
        return this.personaRepository.findPersonaByIdentificacion(tipo, identificacion);
    }

    public Persona findById(int idPersona) {
        return this.personaRepository.findById(idPersona).get();
    }
}
