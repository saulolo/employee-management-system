package edu.ems.domain.gateway;

import edu.ems.domain.model.Employee;
import edu.ems.domain.model.vob.Email;

import java.util.List;
import java.util.Optional;

public interface EmployeeGateway {

    /**
     * Guarda un nuevo empleado en el sistema.
     *
     * @param employee El objeto con los datos del empleado a registrar.
     * @return El empleado guardado con su identificador generado.
     */
    Employee save(Employee employee);

    /**
     * Actualiza la información de un empleado existente.
     *
     * @param employeeId El identificador único del empleado que se desea modificar.
     * @param employee   El objeto con los nuevos datos actualizados del empleado.
     * @return El empleado con la información modificada.
     */
    Employee update(Long employeeId, Employee employee);

    /**
     * Obtiene una lista con todos los empleados registrados en el sistema.
     *
     * @return Una lista que contiene a todos los empleados encontrados.
     */
    List<Employee> findAllEmployees();

    /**
     * Busca un empleado utilizando su identificador único.
     *
     * @param employeeId El identificador único del empleado a buscar.
     * @return Un contenedor Optional que incluye al empleado si se encuentra, o vacío si no existe.
     */
    Optional<Employee> findEmployeeById(Long employeeId);

    /**
     * Busca un empleado utilizando su dirección de correo electrónico.
     *
     * @param email El objeto o cadena que representa el correo electrónico del empleado.
     * @return Un contenedor Optional que incluye al empleado si se encuentra, o vacío si no existe.
     */
    Optional<Employee> findEmployeeByEmail(Email email);

    /**
     * Elimina de forma permanente un empleado del sistema mediante su identificador.
     *
     * @param employeeId El identificador único del empleado que se desea dar de baja.
     */
    void deleteEmployeeById(Long employeeId);

}
