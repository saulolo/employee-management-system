package edu.ems.domain.usecase.employee.exception;

import edu.ems.domain.usecase.DomainException;

public class EmployeeNotFoundException extends DomainException {
    public EmployeeNotFoundException(Long employeeId) {
        super("No employee was found with the ID: " + employeeId);
    }
}
