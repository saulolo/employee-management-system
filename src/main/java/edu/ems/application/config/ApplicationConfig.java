package edu.ems.application.config;

import edu.ems.domain.gateway.EmployeeGateway;
import edu.ems.domain.usecase.employee.CreateEmployeeUseCase;
import edu.ems.domain.usecase.employee.DeleteEmployeeUseCase;
import edu.ems.domain.usecase.employee.GetAllEmployeesUseCase;
import edu.ems.domain.usecase.employee.GetEmployeeByIEmailUseCase;
import edu.ems.domain.usecase.employee.GetEmployeeByIdUseCase;
import edu.ems.domain.usecase.employee.UpdateEmployeeUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    /**
     * Registra el caso de uso para la creación de empleados como un bean de Spring.
     *
     * @param employeeGateway El puerto de acceso a los datos de los empleados.
     * @return Una nueva instancia de CreateEmployeeUseCase.
     */
    @Bean
    public CreateEmployeeUseCase createEmployeeUseCase(EmployeeGateway employeeGateway) {
        return new CreateEmployeeUseCase(employeeGateway);
    }

    /**
     * Registra el caso de uso para la actualización de empleados como un bean de Spring.
     *
     * @param employeeGateway El puerto de acceso a los datos de los empleados.
     * @return Una nueva instancia de UpdateEmployeeUseCase.
     */
    @Bean
    public UpdateEmployeeUseCase updateEmployeeUseCase(EmployeeGateway employeeGateway) {
        return new UpdateEmployeeUseCase(employeeGateway);
    }

    /**
     * Registra el caso de uso para obtener todos los empleados como un bean de Spring.
     *
     * @param employeeGateway El puerto de acceso a los datos de los empleados.
     * @return Una nueva instancia de GetAllEmployeesUseCase.
     */
    @Bean
    public GetAllEmployeesUseCase getAllEmployeesUseCase(EmployeeGateway employeeGateway) {
        return new GetAllEmployeesUseCase(employeeGateway);
    }

    /**
     * Registra el caso de uso para buscar un empleado por su identificador como un bean de Spring.
     *
     * @param employeeGateway El puerto de acceso a los datos de los empleados.
     * @return Una nueva instancia de GetEmployeeByIdUseCase.
     */
    @Bean
    public GetEmployeeByIdUseCase getEmployeeByIdUseCase(EmployeeGateway employeeGateway) {
        return new GetEmployeeByIdUseCase(employeeGateway);
    }

    @Bean
    public GetEmployeeByIEmailUseCase getEmployeeByIEmailUseCase(EmployeeGateway employeeGateway) {
        return new GetEmployeeByIEmailUseCase(employeeGateway);
    }

    /**
     * Registra el caso de uso para la eliminación de empleados como un bean de Spring.
     *
     * @param employeeGateway El puerto de acceso a los datos de los empleados.
     * @return Una nueva instancia de DeleteEmployeeUseCase.
     */
    @Bean
    public DeleteEmployeeUseCase deleteEmployeeUseCase(EmployeeGateway employeeGateway) {
        return new DeleteEmployeeUseCase(employeeGateway);
    }

}
