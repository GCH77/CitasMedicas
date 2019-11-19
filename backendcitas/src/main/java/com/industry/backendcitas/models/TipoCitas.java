package com.industry.backendcitas.models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tipo_citas")
public class TipoCitas {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_cita_generator")
    @SequenceGenerator(name = "tipo_cita_generator", sequenceName = "tipo_cita_seq")
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    private String tipo;
    private String descripcion;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "id_tipo_cita"
    )
    private Set<Cita> citas = new HashSet<>();

    public TipoCitas() {
    }

    public TipoCitas(String tipo, String descripcion) {
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "TipoCitas{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
