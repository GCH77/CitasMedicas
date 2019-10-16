package com.industry.backendcitas.controllers;

import com.industry.backendcitas.VO.PersonaVO;
import com.industry.backendcitas.models.Doctores;
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


    @PostMapping("/personas")
    public ResponseEntity<Persona> createPersona(@RequestBody PersonaVO personaVO) {
        Persona personaVO1 = new Persona();
        personaVO1.setNombre(personaVO.getNombre());
        personaVO1.setApellido(personaVO.getApellido());
        personaVO1.setEmail(personaVO.getEmail());
        personaVO1.setTelefono(personaVO.getTelefono());
        personaVO1.setFecha_nacimiento(personaVO.getFecha_nacimiento());
        personaVO1.setId_tipo_documento(personaVO.getId_tipo_documento());
        personaVO1.setNumero_documento(personaVO.getNumero_documento());

        return new ResponseEntity<>(personaService.createPersona(personaVO1), HttpStatus.CREATED);
    }

}
