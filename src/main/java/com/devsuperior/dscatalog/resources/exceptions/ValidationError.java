package com.devsuperior.dscatalog.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
    private static final long serialVersionUID = 1L;

    private List<FieldError> errors = new ArrayList<>();

    public List<FieldError> getErrors() {
        return errors;
    }

    public void addError(String fieldError, String message) {
        errors.add(new FieldError(fieldError, message));
    }

}
