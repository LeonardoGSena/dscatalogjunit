package com.devsuperior.dscatalog.resources.exceptions;

import java.io.Serializable;

public class FieldError implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fieldError;
    private String message;

    public FieldError() {
    }

    public FieldError(String fieldError, String message) {
        this.fieldError = fieldError;
        this.message = message;
    }

    public String getFieldError() {
        return fieldError;
    }

    public void setFieldError(String fieldError) {
        this.fieldError = fieldError;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
