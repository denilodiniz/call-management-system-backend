package br.com.denilo.ticketmanagementsystem.dtos.clients;

import br.com.denilo.ticketmanagementsystem.dtos.tickets.TicketSummaryDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ClientDetailsDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private String cpf;
    private String email;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate creationDate;

    private List<TicketSummaryDTO> ticketSummaryDTOList = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setTicketSummaryDTOList(List<TicketSummaryDTO> ticketSummaryDTOList) {
        this.ticketSummaryDTOList = ticketSummaryDTOList;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public List<TicketSummaryDTO> getTicketSummaryDTOList() {
        return ticketSummaryDTOList;
    }

}