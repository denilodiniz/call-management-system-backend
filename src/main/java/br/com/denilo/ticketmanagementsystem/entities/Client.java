package br.com.denilo.ticketmanagementsystem.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "client")
public class Client extends User {

    @Serial
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ticket> tickets = new ArrayList<>();

    public Client() {
        super();
    }

    public Client(String name, String cpf, String email, String password) {
        super(name, cpf, email, password);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }
}
