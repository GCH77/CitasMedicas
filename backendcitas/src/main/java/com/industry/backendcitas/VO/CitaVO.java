package com.industry.backendcitas.VO;

import com.industry.backendcitas.models.Doctores;
import com.industry.backendcitas.models.Persona;
import com.industry.backendcitas.models.TipoCitas;

import java.time.LocalDate;
import java.time.LocalTime;

public class CitaVO {
    private int id;
    private LocalDate fecha_cita;
    private TipoCitas id_tipo_cita;
    private String hora_cita;
    private Doctores id_doctor;
    private Persona id_persona;

    public CitaVO() {
    }

    public CitaVO(LocalDate fecha_cita, TipoCitas tipo_cita, String hora_cita, Doctores id_doctor, Persona id_persona) {
        this.fecha_cita = fecha_cita;
        this.id_tipo_cita = tipo_cita;
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

    public TipoCitas getTipo_cita() {
        return id_tipo_cita;
    }

    public void setTipo_cita(TipoCitas tipo_cita) {
        this.id_tipo_cita = tipo_cita;
    }

    public String getHora_cita() {
        return hora_cita;
    }

    public void setHora_cita(String hora_cita) {
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
        return "CitaVO{" +
                "id=" + id +
                ", fecha_cita=" + fecha_cita +
                ", tipo_cita='" + id_tipo_cita + '\'' +
                ", hora_cita=" + hora_cita +
                ", id_doctor=" + id_doctor +
                ", id_persona=" + id_persona +
                '}';
    }
}
