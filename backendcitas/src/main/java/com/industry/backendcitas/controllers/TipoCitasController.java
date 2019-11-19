package com.industry.backendcitas.controllers;

import com.industry.backendcitas.models.TipoCitas;
import com.industry.backendcitas.services.TipoCitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/center")
public class TipoCitasController {
    @Autowired
    private TipoCitasService tipoCitasService;

    @GetMapping("/tipo-citas")
    public List<TipoCitas> getTiposCitas(){
        return tipoCitasService.readTipoCitas();
    }
}
