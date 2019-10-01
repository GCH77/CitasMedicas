package com.industry.backendcitas.VO;

import com.industry.backendcitas.models.Agenda;
import com.industry.backendcitas.models.Cita;
import com.industry.backendcitas.models.Especialidad;
import com.industry.backendcitas.models.Persona;

import java.util.HashSet;
import java.util.Set;

public class DoctoresVO {
    private int id;
    private int numero_tarjeta_profesional;
    private Especialidad id_especialidad;
    private Persona id_personaVO;
    private Set<Agenda> agenda = new HashSet<>();
    private Set<Cita> cita = new HashSet<>();

    public DoctoresVO() {
    }

    public DoctoresVO(int numero_tarjeta_profesional, Especialidad id_especialidad, Persona id_personaVO) {
        this.numero_tarjeta_profesional = numero_tarjeta_profesional;
        this.id_especialidad = id_especialidad;
        this.id_personaVO = id_personaVO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero_tarjeta_profesional() {
        return numero_tarjeta_profesional;
    }

    public void setNumero_tarjeta_profesional(int numero_tarjeta_profesional) {
        this.numero_tarjeta_profesional = numero_tarjeta_profesional;
    }

    public Especialidad getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(Especialidad id_especialidad) {
        this.id_especialidad = id_especialidad;
    }

    public Persona getId_personaVO() {
        return id_personaVO;
    }

    public void setId_personaVO(Persona id_personaVO) {
        this.id_personaVO = id_personaVO;
    }

    @Override
    public String toString() {
        return "DoctoresVO{" +
                "id=" + id +
                ", numero_tarjeta_profesional=" + numero_tarjeta_profesional +
                ", id_especialidad=" + id_especialidad +
                ", id_persona=" + id_personaVO +
                '}';
    }
}
