package com.industry.backendcitas.VO;

import com.industry.backendcitas.models.Doctores;
import java.time.LocalDate;

public class AgendaVO {
    private int id;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private int duracion_cita;
    private Doctores id_doctor;

    public AgendaVO() {
    }

    public AgendaVO(LocalDate fecha_inicio, LocalDate fecha_fin, int duracion_cita, Doctores id_doctor) {
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

    public int getDuracion_cita() {
        return duracion_cita;
    }

    public void setDuracion_cita(int duracion_cita) {
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
        return "AgendaVO{" +
                "id=" + id +
                ", fecha_inicio=" + fecha_inicio +
                ", fecha_fin=" + fecha_fin +
                ", duracion_cita=" + duracion_cita +
                ", id_doctor=" + id_doctor +
                '}';
    }
}
