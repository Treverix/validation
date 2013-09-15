package de.dolk.validation.impl;

import de.dolk.validation.ValidationContext;
import de.dolk.validation.ValidationStatus;
import de.dolk.validation.Validator;

/**
 * A No-Op Validator that simply validates everything to the status that it has been constructed with.
 * 
 * @author adolk
 */
public class NoOpValidator implements Validator<Object> {

    public static final String STATUS_HINT = NoOpValidator.class.getName() + "/status";

    public ValidationStatus validate(ValidationContext context, Object object) {

        ValidationStatus status;
        try {
            status = (ValidationStatus) context.getHint(STATUS_HINT);
            if (status == null) {
                status = ValidationStatus.OK;
            }
        } catch (ClassCastException e) {
            status = ValidationStatus.ERROR;
        }

        context.addResult(new DefaultValidationResult<Object>(this, object, status, status.toString()));
        return status;
    }

}
