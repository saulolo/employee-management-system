package edu.ems.domain.model.exception;

import edu.ems.domain.usecase.DomainException;

public class BusinessRulesOnFieldsException extends DomainException {
    public BusinessRulesOnFieldsException(String field, String reason) {
        super("Field [" + field + "] violation: " + reason);
    }
}
