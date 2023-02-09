package br.com.denilo.ticketmanagementsystem.entities;

import br.com.denilo.ticketmanagementsystem.entities.enums.Profile;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "technician")
public class Technician extends User {

    @Serial
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "technician", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ticket> ticketList = new ArrayList<>();

    public Technician() {
        super();
        super.addProfile(Profile.TECHNICIAN);
    }

    public Technician(String name, String cpf, String email, String password) {
        super(name, cpf, email, password);
        super.addProfile(Profile.TECHNICIAN);
    }

    public Technician(Long id, String name, String cpf, String email, String password) {
        super(id, name, cpf, email, password);
    }

    public List<Ticket> getTickets() {
        return ticketList;
    }

    public void addTicket(Ticket ticket) {
        this.ticketList.add(ticket);
    }
}
