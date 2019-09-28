package com.industry.backendcitas.controllers.services;

import com.industry.backendcitas.controllers.repository.DoctoresRepository;
import com.industry.backendcitas.models.Doctores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DoctoresServiceImpl implements DoctoresService{
    @Autowired
    private DoctoresRepository doctoresRepository;

    @Override
    @Transactional
    public Doctores saveDoctores(Doctores doctores) {
        return doctoresRepository.save(doctores);
    }
}
