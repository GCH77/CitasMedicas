package com.industry.backendcitas.VO;

import java.util.HashSet;
import java.util.Set;

public class DoctoresVO {
    private int id;
    private int numero_tarjeta_profesional;
    private EspecialidadVO id_especialidad;
    private PersonaVO id_personaVO;
    private Set<AgendaVO> agenda = new HashSet<>();
    private Set<CitaVO> cita = new HashSet<>();

    public DoctoresVO() {
    }

    public DoctoresVO(int numero_tarjeta_profesional, EspecialidadVO id_especialidad, PersonaVO id_personaVO) {
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

    public EspecialidadVO getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(EspecialidadVO id_especialidad) {
        this.id_especialidad = id_especialidad;
    }

    public PersonaVO getId_personaVO() {
        return id_personaVO;
    }

    public void setId_personaVO(PersonaVO id_personaVO) {
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
