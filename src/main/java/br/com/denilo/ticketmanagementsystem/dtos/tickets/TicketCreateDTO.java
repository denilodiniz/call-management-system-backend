package br.com.denilo.ticketmanagementsystem.dtos.tickets;

import br.com.denilo.ticketmanagementsystem.entities.Client;
import br.com.denilo.ticketmanagementsystem.entities.Technician;
import br.com.denilo.ticketmanagementsystem.entities.enums.Priority;

import java.io.Serial;
import java.io.Serializable;

public class TicketCreateDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private String observations;
    private Priority priority;
    private Long idClient;
    private Long idTechnician;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public void setIdTechnician(Long idTechnician) {
        this.idTechnician = idTechnician;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getObservations() {
        return observations;
    }

    public Priority getPriority() {
        return priority;
    }

    public Long getIdClient() {
        return idClient;
    }

    public Long getIdTechnician() {
        return idTechnician;
    }
}
