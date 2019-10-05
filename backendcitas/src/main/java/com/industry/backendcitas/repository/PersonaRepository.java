package com.industry.backendcitas.repository;

import com.industry.backendcitas.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    /*
    * Method to search a person by type and number identification
    * */
    @Query("select p from Persona p where p.id_tipo_documento =?1 and p.numero_documento =?2")
    Persona findPersonaByIdentificacion(int tipo, String identificacion);
}
