package com.industry.backendcitas.controllers;

import com.industry.backendcitas.VO.AgendaVO;
import com.industry.backendcitas.models.Agenda;
import com.industry.backendcitas.models.Doctores;
import com.industry.backendcitas.services.AgendaService;
import com.industry.backendcitas.services.DoctoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/center")
public class AgendaController {
    @Autowired
    private AgendaService agendaService;

    @Autowired
    private DoctoresService doctoresService;

    @GetMapping("/agendas")
    public Page<Agenda> getAgendasDoctor(Pageable pageable){
        return agendaService.readAgendas(pageable);
    }

    @PostMapping("/agenda")
    public ResponseEntity<Agenda> createAgenda(@RequestBody AgendaVO agendaVO){
        Agenda agendaVO1 = new Agenda();
        agendaVO1.setFecha_fin(agendaVO.getFecha_fin());
        agendaVO1.setFecha_inicio(agendaVO.getFecha_inicio());
        agendaVO1.setDuracion_cita(agendaVO.getDuracion_cita());
        agendaVO1.setId_doctor(agendaVO.getId_doctor());

        return new ResponseEntity<>(agendaService.createAgenda(agendaVO1), HttpStatus.CREATED);
    }

    @PutMapping("/agenda/{idAgenda}")
    public ResponseEntity<Agenda> updateAgenda(@RequestBody AgendaVO agendaVO, @PathVariable String idAgenda) {
        Agenda agenda = agendaService.findById(Integer.parseInt(idAgenda));
        if (!agenda.equals(null)) {
            agenda.setDuracion_cita(agendaVO.getDuracion_cita());
            agenda.setFecha_inicio(agendaVO.getFecha_inicio());
            agenda.setFecha_fin(agendaVO.getFecha_fin());
            agenda.setId_doctor(agendaVO.getId_doctor());
        }
        return new ResponseEntity<>(agendaService.createAgenda(agenda), HttpStatus.CREATED);
    }

    @DeleteMapping("/agenda/{id}")
    public ResponseEntity deleteAgenda(@PathVariable String id) {
        agendaService.deleteAgenda(Integer.parseInt(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/agenda/{idDoctor}")
    public Agenda findByIdDoctor(@PathVariable String idDoctor){
        Doctores doctor = doctoresService.findById(Integer.parseInt(idDoctor));
        return agendaService.findByIdDoctor(doctor);
    }
}
