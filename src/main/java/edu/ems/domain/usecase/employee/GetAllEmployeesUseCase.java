package edu.ems.domain.usecase.employee;

import edu.ems.domain.gateway.EmployeeGateway;
import edu.ems.domain.model.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class GetAllEmployeesUseCase {

    private final EmployeeGateway employeeGateway;


    /**
     * Recupera todos los empleados registrados en el sistema.
     *
     * @return Una lista con todos los empleados encontrados.
     */
    public List<Employee> execute() {
        log.info("Obteniendo a todos los empleados.");
        return employeeGateway.findAllEmployees();
    }

}
