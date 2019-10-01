package com.industry.backendcitas.repository;

import com.industry.backendcitas.models.Doctores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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
}
