package br.com.denilo.callmanagementsystem.entities;

import br.com.denilo.callmanagementsystem.entities.enums.Profile;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Technician extends User {

    @Serial
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "technician")
    private List<Ticket> tickets = new ArrayList<>();

    public Technician() {
        super();
        super.addProfile(Profile.TECHNICIAN);
    }

    public Technician(String name, String cpf, String email, String password) {
        super(name, cpf, email, password);
        super.addProfile(Profile.TECHNICIAN);
    }

    public List<Ticket> getCalleds() {
        return tickets;
    }

    public void addCalled(Ticket ticket) {
        this.tickets.add(ticket);
    }
}
