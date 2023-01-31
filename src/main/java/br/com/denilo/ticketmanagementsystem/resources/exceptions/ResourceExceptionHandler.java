package br.com.denilo.ticketmanagementsystem.resources.exceptions;

import br.com.denilo.ticketmanagementsystem.services.exceptions.ResourceNotFoundException;
import br.com.denilo.ticketmanagementsystem.services.exceptions.UserAlreadyExistsException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource not found.";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(
                status.value(),
                error,
                e.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<StandardError> userAlreadyExistsException(UserAlreadyExistsException e, HttpServletRequest request) {
        String error = "User already exists.";
        HttpStatus status = HttpStatus.CONFLICT;
        StandardError standardError = new StandardError(
                status.value(),
                error,
                e.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<StandardError> validationErrors(ConstraintViolationException e, HttpServletRequest request) {
        String error = "Required field.";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ValidationError validationError = new ValidationError(
                status.value(),
                error,
                "Required fields are set to null.",
                request.getRequestURI()
        );

        for (ConstraintViolation x : e.getConstraintViolations()) {
            validationError.addRequiredField(x.getPropertyPath().toString(), x.getMessageTemplate());
        }

        return ResponseEntity.status(status).body(validationError);
    }

}
