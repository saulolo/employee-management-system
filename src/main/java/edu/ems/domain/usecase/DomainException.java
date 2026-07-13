package edu.ems.domain.usecase;

public class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }
}
