package edu.ems.infrastructure.adapter.postgres.employee;

import edu.ems.domain.gateway.EmployeeGateway;
import edu.ems.domain.model.Employee;
import edu.ems.domain.model.vob.Email;
import edu.ems.infrastructure.adapter.postgres.entity.EmployeeEntity;
import edu.ems.infrastructure.adapter.postgres.mapper.EmployeeEntityMapper;
import edu.ems.infrastructure.adapter.postgres.repository.EmployeeJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmployeePostgresAdapter implements EmployeeGateway {

    private final EmployeeJpaRepository employeeJpaRepository;


    /**
     * Persiste un nuevo empleado en la base de datos PostgreSQL.
     *
     * @param employee El modelo de dominio del empleado a guardar.
     * @return El modelo de dominio del empleado guardado con sus datos persistidos.
     */
    @Override
    @Transactional
    public Employee save(Employee employee) {
        EmployeeEntity entity = EmployeeEntityMapper.toEntity(employee);
        EmployeeEntity savedEntity = employeeJpaRepository.save(entity);
        log.debug("Empleado persistido con ID: {}", savedEntity.getId());
        return EmployeeEntityMapper.toDomain(savedEntity);
    }

    /**
     * Actualiza un empleado existente en la base de datos PostgreSQL.
     *
     * @param employeeId El identificador único del empleado que se va a actualizar.
     * @param employee   El modelo de dominio con la nueva información del empleado.
     * @return El modelo de dominio del empleado actualizado.
     */
    @Override
    @Transactional
    public Employee update(Long employeeId, Employee employee) {
        EmployeeEntity entity = EmployeeEntityMapper.toEntity(employee);
        EmployeeEntity updatedEntity = employeeJpaRepository.save(entity);
        log.debug("Empleado actualizado en BD con ID: {}", employeeId);
        return EmployeeEntityMapper.toDomain(updatedEntity);
    }

    /**
     * Recupera todos los empleados registrados en el sistema.
     *
     * @return Una lista con los modelos de dominio de todos los empleados encontrados.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAllEmployees() {
        List<Employee> employees = employeeJpaRepository.findAll()
                .stream()
                .map(EmployeeEntityMapper::toDomain)
                .toList();

        log.debug("Se encontraron {} empleados en el sistema.", employees.size());

        return employees;
    }

    /**
     * Busca un empleado en la base de datos utilizando su identificador único.
     *
     * @param employeeId El identificador único del empleado a buscar.
     * @return Un Optional que contiene el modelo de dominio del empleado si existe, o vacío si no se encuentra.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Employee> findEmployeeById(Long employeeId) {
        return employeeJpaRepository.findById(employeeId)
                .map(EmployeeEntityMapper::toDomain);
    }

    /**
     * Busca un empleado en la base de datos utilizando su dirección de correo electrónico.
     *
     * @param email El objeto de valor que representa el correo electrónico del empleado.
     * @return Un Optional que contiene el modelo de dominio del empleado si existe, o vacío si no se encuentra.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Employee> findEmployeeByEmail(Email email) {
        return employeeJpaRepository.findByEmail(email.getValue())
                .map(EmployeeEntityMapper::toDomain);
    }

    /**
     * Elimina de forma permanente un empleado de la base de datos mediante su identificador.
     *
     * @param employeeId El identificador único del empleado que se desea eliminar.
     */
    @Override
    @Transactional
    public void deleteEmployeeById(Long employeeId) {
        employeeJpaRepository.deleteById(employeeId);
        log.info("Empleado eliminado con id: {}", employeeId);
    }
}
