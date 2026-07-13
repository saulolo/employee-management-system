package edu.ems.domain.usecase.employee;

import edu.ems.domain.gateway.EmployeeGateway;
import edu.ems.domain.model.Employee;
import edu.ems.domain.usecase.employee.exception.EmployeeExistException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
public class CreateEmployeeUseCase {

    private final EmployeeGateway employeeGateway;


    /**
     * Ejecuta el proceso de creación, validación y persistencia de un nuevo empleado.
     *
     * @param employee El objeto inicial con los datos del empleado a registrar.
     * @return El empleado guardado con sus fechas de auditoría y su identificador generado.
     */
    public Employee execute(Employee employee) {
        validate(employee);

        Employee newEmployee = employee.toBuilder()
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        Employee savedEmployee = employeeGateway.save(newEmployee);
        log.info("Empleado creado con id: {} y email: {}", newEmployee.getId(), newEmployee.getEmail().getValue());

        return savedEmployee;
    }

    /**
     * Valida si los datos del empleado son aptos para su registro, verificando la unicidad del correo electrónico.
     *
     * @param employee El objeto empleado cuyos datos se van a validar.
     * @throws EmployeeExistException Si ya existe un empleado registrado con la misma dirección de correo.
     */
    private void validate(Employee employee) {
        if (employeeGateway.findEmployeeByEmail(employee.getEmail()).isPresent()) {
            throw new EmployeeExistException(employee.getEmail().getValue());
        }
    }

}
