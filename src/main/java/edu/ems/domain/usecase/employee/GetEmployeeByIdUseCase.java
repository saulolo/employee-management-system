package edu.ems.domain.usecase.employee;

import edu.ems.domain.gateway.EmployeeGateway;
import edu.ems.domain.model.Employee;
import edu.ems.domain.usecase.employee.exception.EmployeeNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class GetEmployeeByIdUseCase {

    private final EmployeeGateway employeeGateway;


    /**
     * Busca un empleado por su ID. Si no existe, lanza una excepción de dominio.
     *
     * @param employeeId El identificador del empleado.
     * @return El empleado encontrado.
     * @throws EmployeeNotFoundException si el empleado no existe.
     */
    public Employee execute(Long employeeId) {
        log.info("Obteniedo el empleado con id: {}", employeeId);
        return employeeGateway.findEmployeeById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(employeeId));

    }

}
