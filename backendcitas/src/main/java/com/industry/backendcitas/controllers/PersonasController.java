package com.industry.backendcitas.controllers;

import com.industry.backendcitas.VO.PersonaVO;
import com.industry.backendcitas.models.Persona;
import com.industry.backendcitas.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/center")
public class PersonasController {
    @Autowired
    private PersonaService personaService;

    @GetMapping("/personas")
    public List<Persona> getAllPersonas(){
        return personaService.readPersonas();
    }

    @GetMapping("/persona/{tipo}/{identificacion}")
    public Persona findPersonaByIdentification(@PathVariable String tipo, @PathVariable String identificacion){
        return personaService.findPersonaByIdentificacion(Integer.parseInt(tipo), identificacion);
    }

    @PostMapping("/persona")
    public ResponseEntity<Persona> createPersona(@RequestBody PersonaVO personaVO){
        Persona persona = new Persona();
        persona.setNombre(personaVO.getNombre());
        persona.setApellido(personaVO.getApellido());
        persona.setEmail(personaVO.getEmail());
        persona.setTelefono(personaVO.getTelefono());
        persona.setFecha_nacimiento(personaVO.getFecha_nacimiento());
        persona.setId_tipo_documento(personaVO.getId_tipo_documento());
        persona.setNumero_documento(personaVO.getNumero_documento());

        return new ResponseEntity<>(personaService.createPersona(persona), HttpStatus.CREATED);
    }
}
