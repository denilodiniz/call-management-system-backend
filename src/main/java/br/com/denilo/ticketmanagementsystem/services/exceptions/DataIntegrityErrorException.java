package br.com.denilo.ticketmanagementsystem.services.exceptions;

public class DataIntegrityErrorException extends RuntimeException {

    public DataIntegrityErrorException(String message) {
        super(message);
    }
}
