package de.dolk.validation;

/**
 * Validators are used to validate java objects against rules. They implement one rule and report whether the test object passes the validation, validation
 * fails or an error occured so that validation was impossible.
 * 
 * @author adolk
 * 
 * @param <T>
 *            The Type that can be validated by this validator
 */
public interface Validator<T> {

    /**
     * Validate an instance of T against a rule. A detailed result has to be added to the context. The context may provide some hints to the validator, like
     * parameters or additional data. A validator may add hints to the context to pass intermediate results to other validators.
     * 
     * @param context
     *            The validation context
     * @param object
     *            The instance that needs validation
     * @return The validation status
     */
    ValidationStatus validate(ValidationContext context, T object);

}
