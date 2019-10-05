package com.industry.backendcitas.services;

import com.industry.backendcitas.models.TipoCitas;
import com.industry.backendcitas.repository.TipoCitasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoCitasService {
    private final TipoCitasRepository tipoCitasRepository;

    public TipoCitasService(TipoCitasRepository tipoCitasRepository) {
        this.tipoCitasRepository = tipoCitasRepository;
    }

    public List<TipoCitas> readTipoCitas(){
        return this.tipoCitasRepository.findAll();
    }

    public TipoCitas createTipoCita(TipoCitas tipoCitas){
        return this.tipoCitasRepository.save(tipoCitas);
    }

    public TipoCitas updateTipoCita(TipoCitas tipoCitas){
        return this.tipoCitasRepository.save(tipoCitas);
    }

    public void deleteTipoCita(int id){
        this.tipoCitasRepository.deleteById(id);
    }
}
