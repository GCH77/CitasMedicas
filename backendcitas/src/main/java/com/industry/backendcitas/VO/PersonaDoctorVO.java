package com.industry.backendcitas.VO;

import com.industry.backendcitas.models.Doctores;
import com.industry.backendcitas.models.Persona;

public class PersonaDoctorVO {
    private Persona persona;
    private Doctores doctor;

    public PersonaDoctorVO() {
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Doctores getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctores doctor) {
        this.doctor = doctor;
    }
}
