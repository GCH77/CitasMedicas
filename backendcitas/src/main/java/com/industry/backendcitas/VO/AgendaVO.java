package com.industry.backendcitas.VO;

import java.time.Duration;
import java.time.LocalDate;

public class AgendaVO {
    private int id;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private Duration duracion_cita;
    private DoctoresVO id_doctor;

    public AgendaVO() {
    }

    public AgendaVO(LocalDate fecha_inicio, LocalDate fecha_fin, Duration duracion_cita, DoctoresVO id_doctor) {
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

    public DoctoresVO getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(DoctoresVO id_doctor) {
        this.id_doctor = id_doctor;
    }

    @Override
    public String toString() {
        return "AgendaVO{" +
                "id=" + id +
                ", fecha_inicio=" + fecha_inicio +
                ", fecha_fin=" + fecha_fin +
                ", duracion_cita=" + duracion_cita.toMinutes() +
                ", id_doctor=" + id_doctor +
                '}';
    }
}
