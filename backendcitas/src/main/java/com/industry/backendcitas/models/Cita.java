package com.industry.backendcitas.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "cita")
public class Cita extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cita_generator")
    @SequenceGenerator(name = "cita_generator", sequenceName = "cita_seq")
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    private LocalDate fecha_cita;
    private String tipo_cita;
    private LocalTime hora_cita;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_doctor", nullable = false)
    private Doctores id_doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona id_persona;

    public Cita() {
    }

    public Cita(LocalDate fecha_cita, String tipo_cita, LocalTime hora_cita, Doctores id_doctor, Persona id_persona) {
        this.fecha_cita = fecha_cita;
        this.tipo_cita = tipo_cita;
        this.hora_cita = hora_cita;
        this.id_doctor = id_doctor;
        this.id_persona = id_persona;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(LocalDate fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public String getTipo_cita() {
        return tipo_cita;
    }

    public void setTipo_cita(String tipo_cita) {
        this.tipo_cita = tipo_cita;
    }

    public LocalTime getHora_cita() {
        return hora_cita;
    }

    public void setHora_cita(LocalTime hora_cita) {
        this.hora_cita = hora_cita;
    }

    public Doctores getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(Doctores id_doctor) {
        this.id_doctor = id_doctor;
    }

    public Persona getId_persona() {
        return id_persona;
    }

    public void setId_persona(Persona id_persona) {
        this.id_persona = id_persona;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "id=" + id +
                ", fecha_cita=" + fecha_cita +
                ", tipo_cita='" + tipo_cita + '\'' +
                ", hora_cita=" + hora_cita +
                ", id_doctor=" + id_doctor +
                ", id_persona=" + id_persona +
                '}';
    }
}
