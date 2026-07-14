package edu.ems.infrastructure.adapter.postgres.repository;

import edu.ems.infrastructure.adapter.postgres.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeJpaRepository extends JpaRepository<EmployeeEntity, Long> {

    /**
     * Busca un empleado en la base de datos utilizando su dirección de correo electrónico.
     * @param email La dirección de correo electrónico del empleado a buscar.
     * @return Un contenedor Optional que incluye al empleado si se encuentra, o vacío si no existe.
     * */
    Optional<EmployeeEntity> findByEmail(String email);

}
