package com.industry.backendcitas.VO;

import com.industry.backendcitas.models.Cita;
import com.industry.backendcitas.models.Doctores;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class PersonaVO {
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private LocalDate fecha_nacimiento;
    private TipoDocumento id_tipo_documento;
    private String numero_documento;
    private Set<Doctores> doctores = new HashSet<>();
    private Set<Cita> cita = new HashSet<>();

    public PersonaVO() {
    }

    public PersonaVO(String nombre, String apellido, String email, String telefono, LocalDate fecha_nacimiento, TipoDocumento id_tipo_documento, String numero_documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
        this.id_tipo_documento = id_tipo_documento;
        this.numero_documento = numero_documento;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public TipoDocumento getId_tipo_documento() {
        return id_tipo_documento;
    }

    public void setId_tipo_documento(TipoDocumento id_tipo_documento) {
        this.id_tipo_documento = id_tipo_documento;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    @Override
    public String toString() {
        return "PersonaVO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", telefono=" + telefono +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", id_tipo_documento=" + id_tipo_documento +
                ", numero_documento=" + numero_documento +
                '}';
    }
}
