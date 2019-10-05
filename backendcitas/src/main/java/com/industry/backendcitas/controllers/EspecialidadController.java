package com.industry.backendcitas.controllers;

import com.industry.backendcitas.models.Especialidad;
import com.industry.backendcitas.services.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/center")
public class EspecialidadController {
    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping("/especialidad-list")
    public List<Especialidad> getEspecialidad() { return this.especialidadService.readEspecialidades();}
}
