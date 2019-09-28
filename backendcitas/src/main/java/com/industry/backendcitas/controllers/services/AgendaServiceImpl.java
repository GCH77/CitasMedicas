package com.industry.backendcitas.controllers.services;

import com.industry.backendcitas.controllers.repository.AgendaRepository;
import com.industry.backendcitas.models.Agenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AgendaServiceImpl implements AgendaService{
    @Autowired
    private AgendaRepository agendaRepository;

    @Override
    @Transactional
    public Agenda saveAgenda(Agenda agenda) {
        return agendaRepository.save(agenda);
    }
}
