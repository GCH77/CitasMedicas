package com.industry.backendcitas.controllers;

import com.industry.backendcitas.VO.DoctoresVO;
import com.industry.backendcitas.VO.PersonaDoctorVO;
import com.industry.backendcitas.models.Doctores;
import com.industry.backendcitas.models.Persona;
import com.industry.backendcitas.services.DoctoresService;
import com.industry.backendcitas.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/center")
public class DoctoresController {
    @Autowired
    private DoctoresService doctoresService;
    @Autowired
    private PersonaService personaService;

    @GetMapping("/doctores")
    public List<Doctores> getAllDoctores(){
        return doctoresService.readDoctores();
    }

    @GetMapping("/datos/{tipo}/{identificacion}")
    public Doctores getDoctorByIdentificacion(@PathVariable String tipo, @PathVariable String identificacion){
        return doctoresService.findByIdentificacion(Integer.parseInt(tipo), identificacion);
    }

    @PostMapping("/doctores")
    public ResponseEntity<Doctores> createDoctor(@RequestBody PersonaDoctorVO personaDoctorVO) {
        Persona persona = new Persona();
        persona.setNombre(personaDoctorVO.getPersona().getNombre());
        persona.setApellido(personaDoctorVO.getPersona().getApellido());
        persona.setEmail(personaDoctorVO.getPersona().getEmail());
        persona.setTelefono(personaDoctorVO.getPersona().getTelefono());
        persona.setFecha_nacimiento(personaDoctorVO.getPersona().getFecha_nacimiento());
        persona.setId_tipo_documento(personaDoctorVO.getPersona().getId_tipo_documento());
        persona.setNumero_documento(personaDoctorVO.getPersona().getNumero_documento());
        Persona personaCreated = personaService.createPersona(persona);

        Doctores doctores = new Doctores();
        doctores.setNumero_tarjeta_profesional(personaDoctorVO.getDoctor().getNumero_tarjeta_profesional());
        doctores.setId_especialidad(personaDoctorVO.getDoctor().getId_especialidad());
        doctores.setId_persona(personaCreated);

        return new ResponseEntity<>(doctoresService.createDoctor(doctores), HttpStatus.CREATED);
    }


}
