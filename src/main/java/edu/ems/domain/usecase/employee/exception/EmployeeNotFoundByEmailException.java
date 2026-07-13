package edu.ems.domain.usecase.employee.exception;

import edu.ems.domain.usecase.DomainException;

public class EmployeeNotFoundByEmailException extends DomainException {
    public EmployeeNotFoundByEmailException(String email) {
        super("No employee was found with the email address: " + email);
    }
}
