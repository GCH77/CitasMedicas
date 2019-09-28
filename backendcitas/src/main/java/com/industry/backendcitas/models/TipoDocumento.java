package com.industry.backendcitas.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TipoDocumento")
public class TipoDocumento extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "tipo")
    private String tipo;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "id_tipo_documento"
    )
    private Set<Persona> personas = new HashSet<>();

    public TipoDocumento(String tipo) { this.tipo = tipo; }

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

    @Override
    public String toString() {
        return "TipoDocumento{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                '}';
    }


}
