package br.com.denilo.ticketmanagementsystem.dtos.technicians;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serial;
import java.io.Serializable;

public class TechnicianUpdateDTO implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;

    private Long id;

    @NotNull(message = "The NAME field is required.")
    @Size(min = 2, max = 100, message = "The NAME must be between 2 and 100 characters.")
    private String name;

    @NotNull(message = "The E-MAIL field is required.")
    @Email(message = "Invalid e-mail.")
    private String email;

    @NotNull(message = "The CPF field is required.")
    @CPF(message = "Invalid CPF.")
    private String cpf;

    @NotNull(message = "The PASSWORD field is required.")
    private String password;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPassword() {
        return password;
    }

}
