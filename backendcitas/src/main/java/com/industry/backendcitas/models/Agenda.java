package com.industry.backendcitas.models;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;


@Entity
@Table(name = "agenda")
public class Agenda extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agenda_generator")
    @SequenceGenerator(name = "agenda_generator", sequenceName = "agenda_seq")
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private Duration duracion_cita;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_doctor", nullable = false)
    private Doctores id_doctor;

    public Agenda(LocalDate fecha_inicio, LocalDate fecha_fin, Duration duracion_cita, Doctores id_doctor) {
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.duracion_cita = duracion_cita;
        this.id_doctor = id_doctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Duration getDuracion_cita() {
        return duracion_cita;
    }

    public void setDuracion_cita(Duration duracion_cita) {
        this.duracion_cita = duracion_cita;
    }

    public Doctores getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(Doctores id_doctor) {
        this.id_doctor = id_doctor;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "id=" + id +
                ", fecha_inicio=" + fecha_inicio +
                ", fecha_fin=" + fecha_fin +
                ", duracion_cita=" + duracion_cita.toMinutes() +
                ", id_doctor=" + id_doctor +
                '}';
    }
}
