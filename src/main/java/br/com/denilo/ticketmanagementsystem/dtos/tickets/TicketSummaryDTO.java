package br.com.denilo.ticketmanagementsystem.dtos.tickets;

import br.com.denilo.ticketmanagementsystem.entities.enums.Priority;
import br.com.denilo.ticketmanagementsystem.entities.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class TicketSummaryDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String title;
    @JsonFormat(pattern = "'On' dd/MM/yyyy, 'at' HH:mm:ss.")
    private LocalDateTime creationDate;
    private Priority priority;
    private Status status;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

}
