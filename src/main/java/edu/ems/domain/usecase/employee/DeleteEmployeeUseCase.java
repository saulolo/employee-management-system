package edu.ems.domain.usecase.employee;

import edu.ems.domain.gateway.EmployeeGateway;
import edu.ems.domain.usecase.employee.exception.EmployeeNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class DeleteEmployeeUseCase {

    private final EmployeeGateway employeeGateway;


    /**
     * Ejecuta el proceso de eliminación permanente de un empleado del sistema.
     *
     * @param employeeId El identificador único del empleado que se desea eliminar.
     * @throws EmployeeNotFoundException Si el empleado no existe en el sistema.
     */
    public void execute(Long employeeId) {
        validate(employeeId);
        log.info("Eliminado el empleado con ID: {}", employeeId);
        employeeGateway.deleteEmployeeById(employeeId);
    }


    /**
     * Valida la existencia del empleado en el sistema antes de proceder con su eliminación.
     *
     * @param employeeId El identificador único del empleado a verificar.
     * @throws EmployeeNotFoundException Si no existe ningún empleado con el identificador proporcionado.
     */
    private void validate(Long employeeId) {
        employeeGateway.findEmployeeById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(employeeId));
    }

}
