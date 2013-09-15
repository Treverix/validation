package de.dolk.validation.impl;

import de.dolk.validation.ValidationResult;
import de.dolk.validation.ValidationStatus;
import de.dolk.validation.Validator;

public class DefaultValidationResult<T> implements ValidationResult<T> {

    private ValidationStatus status;
    private String message;
    private Validator<T> origin;
    private T validatedObject;

    public DefaultValidationResult(Validator<T> origin, T validatedObject, ValidationStatus status, String message) {
        this.status = status;
        this.message = message;
        this.origin = origin;
        this.validatedObject = validatedObject;
    }

    public ValidationStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Validator<T> getOrigin() {
        return origin;
    }

    public T getValidatedObject() {
        return validatedObject;
    }

}
