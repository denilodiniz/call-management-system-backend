package br.com.denilo.ticketmanagementsystem.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class ClientDetailsDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private String cpf;
    private String email;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate creationDate;


}