package com.industry.backendcitas.services;

import com.industry.backendcitas.models.Doctores;
import com.industry.backendcitas.models.Especialidad;
import com.industry.backendcitas.repository.DoctoresRepository;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.List;

@Service
public class DoctoresService {
    private final DoctoresRepository doctoresRepository;

    public DoctoresService(DoctoresRepository doctoresRepository) {
        this.doctoresRepository = doctoresRepository;
    }

    public List<Doctores> readDoctores() {
        return this.doctoresRepository.findAll();
    }

    public Doctores createDoctor(Doctores doctores) {
        return this.doctoresRepository.save(doctores);
    }

    public Doctores updateDoctor(Doctores doctores) {
        return this.doctoresRepository.save(doctores);
    }

    public void deleteDoctor(int idDoctor) {
        this.doctoresRepository.deleteById(idDoctor);
    }

    public Doctores findByIdentificacion(int tipo, String identificacion){
        return this.doctoresRepository.findByIdentificacion(tipo, identificacion);
    }

    public List<Doctores> getDoctoresEspecialidadDisponibilidad(Especialidad tipo, LocalDate fecha){
        return this.doctoresRepository.findByEspecialidadDisponibilidad(tipo, fecha);
    }

    public Doctores findById(int id){
        return this.doctoresRepository.findById(id).get();
    }
}
