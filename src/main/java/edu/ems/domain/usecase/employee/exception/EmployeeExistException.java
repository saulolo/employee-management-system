package edu.ems.domain.usecase.employee.exception;

import edu.ems.domain.usecase.DomainException;

public class EmployeeExistException extends DomainException {
    public EmployeeExistException(String email) {
        super("The following employee already exists: " + email);
    }
}
