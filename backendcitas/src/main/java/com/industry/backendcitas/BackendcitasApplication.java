package com.industry.backendcitas;

import com.industry.backendcitas.models.*;
import com.industry.backendcitas.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class BackendcitasApplication implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger("JCG");

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @Autowired
    private PersonaService personaService;

    @Autowired
    private EspecialidadService especialidadService;

    @Autowired
    DoctoresService doctoresService;

    @Autowired
    AgendaService agendaService;

    @Autowired
    CitaService citaService;

    public static void main(String[] args) {
        SpringApplication.run(BackendcitasApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {

        List<TipoDocumento> documentos = new ArrayList<>();
        documentos.add(new TipoDocumento("Cedula"));
        documentos.add(new TipoDocumento("Tarjeta de Identidad"));
        documentos.add(new TipoDocumento("Pasaporte"));

        for (TipoDocumento documento : documentos) {
            tipoDocumentoService.createTipoDocumento(documento);
            LOG.info("Guardando documentos en DB : {}", documento.toString());
        }

        //--
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Juan", "Cardozo", "jcardozo@email.com", "310250255", LocalDate.of(1985,3,16), documentos.get(0), "111855588-0"));
        personas.add(new Persona("Alvarito", "Uribe", "auc@email.com", "310250315", LocalDate.of(1984, 7, 16), documentos.get(0), "111855228-1"));
        personas.add(new Persona("Carlos Humberto", "Valderrama", "pibe@email.com", "310250875", LocalDate.of(1988, 10, 20), documentos.get(0), "1118545888-2"));
        personas.add(new Persona("Pablo", "Escobar", "elpatron@email.com", "310250875", LocalDate.of(1990, 5, 25), documentos.get(0), "1118545888-3"));
        personas.add(new Persona("Paciente", "Ejemplo", "email@email.com", "320250071", LocalDate.of(1960, 5, 25), documentos.get(0), "1118215808-4"));

        for (Persona persona : personas) {
            personaService.createPersona(persona);
            LOG.info("Guardando Persona en db : {}", persona.toString());
        }

        //--
        List<Especialidad> especialidades = new ArrayList<>();
        especialidades.add(new Especialidad("Dermatología", "Encargado de atender el cuidado de la piel"));
        especialidades.add(new Especialidad("Otorrinolaringología", "Encargado de ateneder el cuidado del oído, naríz y garganta"));
        especialidades.add(new Especialidad("Neurología", "Encargado de atender enfermedades del sistema nervioso"));
        especialidades.add(new Especialidad("Cardiologìa", "Encargado de atender enfermedades del corazón"));

        for (Especialidad especialidad : especialidades) {
            especialidadService.createEspecialidad(especialidad);
            LOG.info("Guardando Especialidades en DB : {}", especialidad.toString());
        }

        //--
        List<Doctores> doctores = new ArrayList<>();
        doctores.add(new Doctores(2558844, especialidades.get(0), personas.get(0)));
        doctores.add(new Doctores(6542140, especialidades.get(1), personas.get(1)));
        doctores.add(new Doctores(5546545, especialidades.get(2), personas.get(3)));
        doctores.add(new Doctores(6258844, especialidades.get(3), personas.get(2)));

        for (Doctores doctor : doctores) {
            doctoresService.createDoctor(doctor);
            LOG.info("Guardanod Doctores en DB : {}", doctor.toString());
        }

        //--
        Agenda agenda = new Agenda(LocalDate.of(2019, 9, 23), LocalDate.of(2019, 10, 23), 15, doctores.get(0));
        agendaService.createAgenda(agenda);
        Agenda agenda1 = new Agenda(LocalDate.of(2019, 9, 25), LocalDate.of(2019, 10, 23), 25, doctores.get(1));
        agendaService.createAgenda(agenda1);
        Agenda agenda2 = new Agenda(LocalDate.of(2019, 9, 30), LocalDate.of(2019, 10, 23), 30, doctores.get(2));
        agendaService.createAgenda(agenda2);
        LOG.info("guardando agenda en DB : {}", agenda.toString());
        LOG.info("guardando agenda1 en DB : {}", agenda1.toString());
        LOG.info("guardando agenda2 en DB : {}", agenda2.toString());

        //--
        Cita cita = new Cita(LocalDate.of(2019,10,1), "Cita con especialista en Dermatología", LocalTime.of(8,30), doctores.get(0), personas.get(4));
        citaService.createCita(cita);
        LOG.info("Guardando Cita en DB : {}", cita.toString());
    }

}
