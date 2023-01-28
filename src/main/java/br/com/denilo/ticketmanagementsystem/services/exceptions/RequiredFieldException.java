package br.com.denilo.ticketmanagementsystem.services.exceptions;

public class RequiredFieldException extends RuntimeException {

    public RequiredFieldException(String message) {
        super(message);
    }
}
