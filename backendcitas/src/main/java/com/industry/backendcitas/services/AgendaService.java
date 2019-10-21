package com.industry.backendcitas.services;

import com.industry.backendcitas.models.Agenda;
import com.industry.backendcitas.repository.AgendaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaService {
    private final AgendaRepository agendaRepository;

    public AgendaService(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    public List<Agenda> readAgendas() {
        return this.agendaRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Agenda createAgenda(Agenda agenda) {
        return this.agendaRepository.save(agenda);
    }

    public Agenda findById(int id) {
        return this.agendaRepository.findById(id).get();
    }

    public void deleteAgenda(int idAgenda) {
        this.agendaRepository.deleteById(idAgenda);
    }
}
