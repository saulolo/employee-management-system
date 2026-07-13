package edu.ems.domain.usecase.employee;

import edu.ems.domain.gateway.EmployeeGateway;
import edu.ems.domain.model.Employee;
import edu.ems.domain.model.vob.Email;
import edu.ems.domain.usecase.employee.exception.EmployeeNotFoundByEmailException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class GetEmployeeByIEmailUseCase {

    private final EmployeeGateway employeeGateway;


    /**
     * Busca y obtiene la información de un empleado a partir de su correo electrónico.
     *
     * @param email El objeto que contiene la dirección de correo electrónico del empleado.
     * @return El objeto empleado correspondiente si se encuentra registrado en el sistema.
     * @throws EmployeeNotFoundByEmailException Si no existe ningún empleado asociado al correo electrónico proporcionado.
     */
    public Employee execute(Email email) {
        log.info("Obteniedo el empleado con email: {}", email.getValue());
        return employeeGateway.findEmployeeByEmail(email)
                .orElseThrow(() -> new EmployeeNotFoundByEmailException(email.getValue()));
    }

}
