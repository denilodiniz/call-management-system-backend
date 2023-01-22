package br.com.denilo.callmanagementsystem.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client extends User {

    @Serial
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "client")
    private List<Called> calleds = new ArrayList<>();

    public Client() {
        super();
    }

    public Client(String name, String cpf, String email, String password) {
        super(name, cpf, email, password);
    }

    public List<Called> getCalleds() {
        return calleds;
    }

    public void addCalled(Called called) {
        this.calleds.add(called);
    }
}
