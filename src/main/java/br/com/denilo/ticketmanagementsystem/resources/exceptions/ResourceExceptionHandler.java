package br.com.denilo.ticketmanagementsystem.resources.exceptions;

import br.com.denilo.ticketmanagementsystem.services.exceptions.DataIntegrityErrorException;
import br.com.denilo.ticketmanagementsystem.services.exceptions.ResourceNotFoundException;
import br.com.denilo.ticketmanagementsystem.services.exceptions.UnauthorizedUserAccessException;
import br.com.denilo.ticketmanagementsystem.services.exceptions.UserAlreadyExistsException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(DataIntegrityErrorException.class)
    public ResponseEntity<StandardError> dataIntegrityError(DataIntegrityErrorException e, HttpServletRequest request) {
        String error = "Data integrity error.";
        HttpStatus status = HttpStatus.CONFLICT;
        StandardError standardError = new StandardError(
                status.value(),
                error,
                e.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(UnauthorizedUserAccessException.class)
    public ResponseEntity<StandardError> UnauthorizedEntityAccessException(UnauthorizedUserAccessException e, HttpServletRequest request) {
        String error = "Unauthorized user access.";
        HttpStatus status = HttpStatus.FORBIDDEN;
        StandardError standardError = new StandardError(
                status.value(),
                error,
                e.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validationErrors(MethodArgumentNotValidException e, HttpServletRequest request) {
        String error = "Validation error.";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ValidationError validationError = new ValidationError(
                status.value(),
                error,
                "Reported data validation error",
                request.getRequestURI()
        );

        for (FieldError x : e.getBindingResult().getFieldErrors()) {
            validationError.addRequiredField(x.getField().toString(), x.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(validationError);
    }

}
