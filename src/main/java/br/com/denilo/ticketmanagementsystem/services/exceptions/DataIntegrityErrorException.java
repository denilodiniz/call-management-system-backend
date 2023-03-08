package br.com.denilo.ticketmanagementsystem.services.exceptions;

import java.io.Serial;

public class DataIntegrityErrorException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public DataIntegrityErrorException(String message) {
        super(message);
    }

}
