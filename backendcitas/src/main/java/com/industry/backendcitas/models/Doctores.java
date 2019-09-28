package com.industry.backendcitas.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "doctores")
public class Doctores extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctores_generator")
    @SequenceGenerator(name = "doctores_generator", sequenceName = "doctores_seq")
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    private int numero_tarjeta_profesional;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_especialidad", nullable = false)
    private Especialidad id_especialidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona id_persona;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "id_doctor"
    )
    private Set<Agenda> agenda = new HashSet<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "id_doctor"
    )
    private Set<Cita> cita = new HashSet<>();

    public Doctores(int numero_tarjeta_profesional, Especialidad id_especialidad, Persona id_persona) {
        this.numero_tarjeta_profesional = numero_tarjeta_profesional;
        this.id_especialidad = id_especialidad;
        this.id_persona = id_persona;
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

    public Persona getId_persona() {
        return id_persona;
    }

    public void setId_persona(Persona id_persona) {
        this.id_persona = id_persona;
    }

    @Override
    public String toString() {
        return "Doctores{" +
                "id=" + id +
                ", numero_tarjeta_profesional=" + numero_tarjeta_profesional +
                ", id_especialidad=" + id_especialidad +
                ", id_persona=" + id_persona +
                '}';
    }
}
