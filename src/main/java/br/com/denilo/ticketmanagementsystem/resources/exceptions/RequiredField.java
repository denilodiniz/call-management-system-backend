package br.com.denilo.ticketmanagementsystem.resources.exceptions;

import java.io.Serial;
import java.io.Serializable;

public class RequiredField implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String fieldName;
    private String message;

    public RequiredField() {
    }

    public RequiredField(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }

}
