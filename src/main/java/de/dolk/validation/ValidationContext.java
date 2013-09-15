package de.dolk.validation;

import java.util.List;

/**
 * A context that can be passed to validators. Validators should add their validation results an use the hints, either using them or adding new hints.
 * 
 * @author adolk
 * 
 */
public interface ValidationContext {

    /**
     * Add a new validation result
     * 
     * @param result
     *            a validation result
     */
    void addResult(ValidationResult<?> result);

    /**
     * Get the list of all validation results stored on this context
     * 
     * @return the validation results
     */
    List<ValidationResult<?>> getResults();

    /**
     * Set a hint on the context. Hints can be used to pass pre-calculated objects or already fetched entities to other validators or to pass validation
     * parameters to validators (that should be documented with the parametizable validator)
     * 
     * @param key
     * @param hint
     */
    void setHint(String key, Object hint);

    Object getHint(String key);

    void destroy();

}
