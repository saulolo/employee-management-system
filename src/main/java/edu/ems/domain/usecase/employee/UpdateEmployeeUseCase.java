package edu.ems.domain.usecase.employee;

import edu.ems.domain.gateway.EmployeeGateway;
import edu.ems.domain.model.Employee;
import edu.ems.domain.usecase.employee.exception.EmployeeNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
public class UpdateEmployeeUseCase {

    private final EmployeeGateway employeeGateway;

    /**
     * Ejecuta el proceso de actualización de los datos de un empleado existente.
     *
     * @param employeeId El identificador único del empleado que se desea modificar.
     * @param employee   El objeto con la nueva información del empleado.
     * @return El empleado actualizado con sus datos persistidos y fecha de auditoría renovada.
     */
    public Employee execute(Long employeeId, Employee employee) {
        Employee existingEmployee = validate(employeeId);

        Employee newEmployee = employee.toBuilder()
                .id(employeeId)
                .createdAt(existingEmployee.getCreatedAt())
                .updatedAt(LocalDateTime.now())
                .build();

        Employee updatedEmployee = employeeGateway.update(employeeId, newEmployee);
        log.info("Empleado actualizado con id: {}", updatedEmployee.getId());

        return updatedEmployee;

    }

    /**
     * Valida la existencia del empleado en el sistema antes de permitir su modificación.
     *
     * @param employeeId El identificador único del empleado a buscar.
     * @return El objeto empleado original si se encuentra registrado en el sistema.
     * @throws EmployeeNotFoundException Si no existe ningún empleado con el identificador proporcionado.
     */
    private Employee validate(Long employeeId) {
        return employeeGateway.findEmployeeById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(employeeId));
    }

}
