package br.com.denilo.ticketmanagementsystem.dtos.tickets;

import br.com.denilo.ticketmanagementsystem.entities.enums.Priority;
import br.com.denilo.ticketmanagementsystem.entities.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TicketDetailsDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private long id;
    @JsonFormat(pattern = "'On' dd/MM/yyyy, 'at' HH:mm:ss.")
    private LocalDateTime creationDate;
    @JsonFormat(pattern = "'On' dd/MM/yyyy, 'at' HH:mm:ss.")
    private LocalDateTime closedDate;
    private String title;
    private String observations;
    private Status status;
    private Priority priority;
    private Long clientId;
    private Long technicianId;
    private String clientName;
    private String technicianName;

    public TicketDetailsDTO() {
    }

    public TicketDetailsDTO(long id, LocalDateTime creationDate, LocalDateTime closedDate, String title, String observations, Status status, Priority priority, Long clientId, Long technicianId, String clientName, String technicianName) {
        this.id = id;
        this.creationDate = creationDate;
        this.closedDate = closedDate;
        this.title = title;
        this.observations = observations;
        this.status = status;
        this.priority = priority;
        this.clientId = clientId;
        this.technicianId = technicianId;
        this.clientName = clientName;
        this.technicianName = technicianName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
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

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void setTechnicianId(Long technicianId) {
        this.technicianId = technicianId;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setTechnicianName(String technicianName) {
        this.technicianName = technicianName;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
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

    public Long getClientId() {
        return clientId;
    }

    public Long getTechnicianId() {
        return technicianId;
    }

    public String getClientName() {
        return clientName;
    }

    public String getTechnicianName() {
        return technicianName;
    }
}
