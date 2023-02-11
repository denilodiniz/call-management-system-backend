package br.com.denilo.ticketmanagementsystem.entities;

import br.com.denilo.ticketmanagementsystem.entities.enums.Priority;
import br.com.denilo.ticketmanagementsystem.entities.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "tickets")
@Table(name = "tickets")
public class Ticket implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "closed_date", nullable = true)
    private LocalDateTime closedDate;

    @NotNull(message = "The TITLE field is required.")
    @Column(name = "title", nullable = false)
    private String title;

    @NotNull(message = "The OBSERVATIONS field is required.")
    @Column(name = "observations", nullable = false)
    private String observations;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority", nullable = false)
    private Priority priority;


    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    @JsonIgnore
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_technician", nullable = false)
    @JsonIgnore
    private Technician technician;

    public Ticket() {
        this.status = Status.OPEN;
    }

    public Ticket(String title, String observations, Priority priority, Client client, Technician technician) {
        this.title = title;
        this.observations = observations;
        this.priority = priority;
        this.client = client;
        this.technician = technician;
        this.status = Status.OPEN;
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

    public void setClient(Client client) {
        this.client = client;
    }

    public void setTechnician(Technician technician) {
        this.technician = technician;
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

    public Client getClient() {
        return client;
    }

    public Technician getTechnician() {
        return technician;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
