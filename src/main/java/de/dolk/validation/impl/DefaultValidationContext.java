package de.dolk.validation.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.dolk.validation.ValidationContext;
import de.dolk.validation.ValidationResult;

public class DefaultValidationContext implements ValidationContext {

    private List<ValidationResult<?>> results;
    private Map<String, Object> hints;

    public DefaultValidationContext() {
        results = new ArrayList<ValidationResult<?>>();
        hints = new HashMap<String, Object>();
    }

    public void addResult(ValidationResult<?> result) {
        results.add(result);
    }

    public List<ValidationResult<?>> getResults() {
        return Collections.unmodifiableList(results);
    }

    public void setHint(String key, Object hint) {
        hints.put(key, hint);
    }

    public Object getHint(String key) {
        return hints.get(key);
    }

    public void destroy() {
        results.clear();
        hints.clear();
    }

}
