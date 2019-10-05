package com.industry.backendcitas.controllers;

import com.industry.backendcitas.VO.DoctoresVO;
import com.industry.backendcitas.models.Doctores;
import com.industry.backendcitas.services.DoctoresService;
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

    @GetMapping("/doctores")
    public List<Doctores> getAllDoctores(){
        return doctoresService.readDoctores();
    }

    @GetMapping("/datos/{tipo}/{identificacion}")
    public Doctores getDoctorByIdentificacion(@PathVariable String tipo, @PathVariable String identificacion){
        return doctoresService.findByIdentificacion(Integer.parseInt(tipo), identificacion);
    }

    @PostMapping("/doctores")
    public ResponseEntity<Doctores> createDoctor(@RequestBody DoctoresVO doctoresVO){
        Doctores doctoresVO1 = new Doctores();
        doctoresVO1.setNumero_tarjeta_profesional(doctoresVO.getNumero_tarjeta_profesional());
        doctoresVO1.setId_especialidad(doctoresVO.getId_especialidad());
        doctoresVO1.setId_persona(doctoresVO.getId_personaVO());

        return new ResponseEntity<>(doctoresService.createDoctor(doctoresVO1), HttpStatus.CREATED);
    }


}
