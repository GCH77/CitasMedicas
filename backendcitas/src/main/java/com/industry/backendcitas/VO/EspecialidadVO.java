package com.industry.backendcitas.VO;

import java.util.HashSet;
import java.util.Set;

public class EspecialidadVO {
    private int id;
    private String nombre;
    private String descripcion;
    private Set<DoctoresVO> doctores = new HashSet<>();

    public EspecialidadVO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "EspecialidadVO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
