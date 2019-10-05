package com.industry.backendcitas.VO;

import com.industry.backendcitas.models.Doctores;
import com.industry.backendcitas.models.Persona;

import java.time.LocalDate;
import java.time.LocalTime;

public class CitaVO {
    private int id;
    private LocalDate fecha_cita;
    private String tipo_cita;
    private LocalTime hora_cita;
    private Doctores id_doctor;
    private Persona id_personaVO;

    public CitaVO() {
    }

    public CitaVO(LocalDate fecha_cita, String tipo_cita, LocalTime hora_cita, Doctores id_doctor, Persona id_personaVO) {
        this.fecha_cita = fecha_cita;
        this.tipo_cita = tipo_cita;
        this.hora_cita = hora_cita;
        this.id_doctor = id_doctor;
        this.id_personaVO = id_personaVO;
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

    public Persona getId_personaVO() {
        return id_personaVO;
    }

    public void setId_personaVO(Persona id_personaVO) {
        this.id_personaVO = id_personaVO;
    }

    @Override
    public String toString() {
        return "CitaVO{" +
                "id=" + id +
                ", fecha_cita=" + fecha_cita +
                ", tipo_cita='" + tipo_cita + '\'' +
                ", hora_cita=" + hora_cita +
                ", id_doctor=" + id_doctor +
                ", id_persona=" + id_personaVO +
                '}';
    }
}