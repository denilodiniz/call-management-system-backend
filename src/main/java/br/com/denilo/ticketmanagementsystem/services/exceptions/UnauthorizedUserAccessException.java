package br.com.denilo.ticketmanagementsystem.services.exceptions;

import java.io.Serial;

public class UnauthorizedUserAccessException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public UnauthorizedUserAccessException(String message) {
        super(message);
    }

}
