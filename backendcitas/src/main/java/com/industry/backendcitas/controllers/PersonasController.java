package com.industry.backendcitas.controllers;

import com.industry.backendcitas.models.Persona;
import com.industry.backendcitas.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
