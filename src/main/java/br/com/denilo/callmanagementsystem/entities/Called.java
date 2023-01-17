package br.com.denilo.callmanagementsystem.entities;

import br.com.denilo.callmanagementsystem.entities.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Called implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate creationDate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate closedDate;

    private String title;
    private String observations;
    private Status status;

    @ManyToOne
    private Client client;
    @ManyToOne
    private Technician technician;

    public Called() {
        this.creationDate = LocalDate.now();
        this.status = Status.OPEN;
    }

    public void setClosedDate(LocalDate closedDate) {
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

    public void setClient(Client client) {
        this.client = client;
    }

    public void setTechnician(Technician technician) {
        this.technician = technician;
    }

    public long getId() {
        return id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getClosedDate() {
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
        Called called = (Called) o;
        return id == called.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
