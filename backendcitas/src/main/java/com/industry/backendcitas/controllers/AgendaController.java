package com.industry.backendcitas.controllers;

import com.industry.backendcitas.VO.AgendaVO;
import com.industry.backendcitas.models.Agenda;
import com.industry.backendcitas.services.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/center")
public class AgendaController {
    @Autowired
    private AgendaService agendaService;

    @PostMapping("/agenda")
    public ResponseEntity<Agenda> createAgenda(@RequestBody AgendaVO agendaVO){
        System.out.println("************************************************");
        System.out.println(agendaVO);
        System.out.println("************************************************");
        Agenda agendaVO1 = new Agenda();
        agendaVO1.setFecha_fin(agendaVO.getFecha_fin());
        agendaVO1.setFecha_inicio(agendaVO.getFecha_inicio());
        agendaVO1.setDuracion_cita(agendaVO.getDuracion_cita());
        agendaVO1.setId_doctor(agendaVO.getId_doctor());

        return new ResponseEntity<>(agendaService.createAgenda(agendaVO1), HttpStatus.CREATED);
    }
}
