package de.dolk.validation;

/**
 * A result of a validation.
 * 
 * @author adolk
 * 
 * @param <T>
 *            The type that has been validated
 */
public interface ValidationResult<T> {

    /**
     * Get the validation status from the result.
     * 
     * @return the validation status
     */
    ValidationStatus getStatus();

    /**
     * Get the message from the result.
     * 
     * @return The detailed validation result, maybe null if the status is OK
     */
    String getMessage();

    /**
     * Get the validator that was used to validate the object
     * 
     * @return The validator
     */
    Validator<T> getOrigin();

    /**
     * Get the validated object
     * 
     * @return
     */
    T getValidatedObject();

}
