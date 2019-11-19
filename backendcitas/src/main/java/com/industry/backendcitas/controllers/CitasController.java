package com.industry.backendcitas.controllers;

import com.industry.backendcitas.VO.CitaVO;
import com.industry.backendcitas.models.Cita;
import com.industry.backendcitas.models.Doctores;
import com.industry.backendcitas.models.Persona;
import com.industry.backendcitas.models.TipoCitas;
import com.industry.backendcitas.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/center")
public class CitasController {
    @Autowired
    private CitaService citaService;

    @Autowired
    private DoctoresService doctoresService;

    @Autowired
    private TipoCitasService tipoCitasService;

    @Autowired
    private PersonaService personaService;

    @PostMapping("/cita")
    public ResponseEntity<Cita> saveCita(@RequestBody CitaVO citaVO){
        System.out.println("_______---------------_____________");
        System.out.println(citaVO);
        Doctores doctores = doctoresService.findById(citaVO.getId_doctor().getId());

        TipoCitas tipoCitas = tipoCitasService.findById(citaVO.getTipo_cita().getId());

        Persona persona = new Persona();
        persona.setNombre(citaVO.getId_persona().getNombre());
        persona.setApellido(citaVO.getId_persona().getApellido());
        persona.setEmail(citaVO.getId_persona().getEmail());
        persona.setTelefono(citaVO.getId_persona().getTelefono());
        persona.setFecha_nacimiento(citaVO.getId_persona().getFecha_nacimiento());
        persona.setId_tipo_documento(citaVO.getId_persona().getId_tipo_documento());
        persona.setNumero_documento(citaVO.getId_persona().getNumero_documento());
        Persona personaCreated = personaService.createPersona(persona);

        Cita cita = new Cita();
        cita.setFecha_cita(citaVO.getFecha_cita());
        cita.setHora_cita(citaVO.getHora_cita());
        cita.setTipo_cita(tipoCitas);
        cita.setId_doctor(doctores);
        cita.setId_persona(persona);
        return new ResponseEntity<>(citaService.createCita(cita), HttpStatus.CREATED);
    }
}
