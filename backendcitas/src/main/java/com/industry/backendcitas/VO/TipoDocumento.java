package com.industry.backendcitas.VO;

import com.industry.backendcitas.models.Persona;

import java.util.HashSet;
import java.util.Set;

public class TipoDocumento {
    private int id;
    private String tipo;
    private Set<Persona> personaVO = new HashSet<>();

    public TipoDocumento(String tipo) {
        this.tipo = tipo;
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

    @Override
    public String toString() {
        return "TipoDocumento{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                '}';
    }


}
