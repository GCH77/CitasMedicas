package com.industry.backendcitas.repository;

import com.industry.backendcitas.models.Doctores;
import com.industry.backendcitas.models.Agenda;
import com.industry.backendcitas.models.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DoctoresRepository extends JpaRepository<Doctores, Integer> {
    /*
    * Method to search by identification number and get all data.
    * */
    @Query("Select d from Doctores d" +
            " inner join Persona p on d.id_persona = p.id " +
            " inner join TipoDocumento t on p.id_tipo_documento = t.id" +
            " where p.id_tipo_documento.id = ?1 and p.numero_documento = ?2")
    Doctores findByIdentificacion(int tipo, String identificacion);

    @Query("select d from Doctores  d inner join Agenda ag on d.id = ag.id_doctor where d.id in " +
            "(select a.id_doctor from Agenda a inner join Doctores dc on a.id_doctor = dc.id where ?2 between a.fecha_inicio and a.fecha_fin)" +
            "and d.id_especialidad = ?1")
    List<Doctores> findByEspecialidadDisponibilidad(Especialidad tipo, LocalDate fecha);
}
