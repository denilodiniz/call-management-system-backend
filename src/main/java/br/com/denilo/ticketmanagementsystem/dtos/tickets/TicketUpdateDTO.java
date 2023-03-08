package br.com.denilo.ticketmanagementsystem.dtos.tickets;

import br.com.denilo.ticketmanagementsystem.entities.enums.Priority;
import br.com.denilo.ticketmanagementsystem.entities.enums.Status;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class TicketUpdateDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private LocalDateTime closedDate;
    private String title;
    private String observations;
    private Status status;
    private Priority priority;
    private Long idClient;
    private Long idTechnician;

    public void setId(Long id) {
        this.id = id;
    }

    public void setClosedDate(LocalDateTime closedDate) {
        this.closedDate = closedDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    public LocalDateTime getClosedDate() {
        return closedDate;
    }

    public String getTitle() {
        return title;
    }

    public String getObservations() {
        return observations;
    }

    public Status getStatus() {
        return status;
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
