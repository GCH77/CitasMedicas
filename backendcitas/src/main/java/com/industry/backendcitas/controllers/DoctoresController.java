package com.industry.backendcitas.controllers;

import com.industry.backendcitas.models.Doctores;
import com.industry.backendcitas.services.DoctoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
