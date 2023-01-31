package br.com.denilo.ticketmanagementsystem.resources.exceptions;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    @Serial
    private static final long serialVersionUID = 1L;

    private List<RequiredField> requiredFieldList = new ArrayList<>();

    public ValidationError(Integer status, String error, String message, String path) {
        super(status, error, message, path);
    }

    public List<RequiredField> getRequiredFields() {
        return requiredFieldList;
    }

    public void addRequiredField(String field, String message) {
        requiredFieldList.add(new RequiredField(field, message));
    }

}
