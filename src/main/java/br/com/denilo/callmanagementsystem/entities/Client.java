package br.com.denilo.callmanagementsystem.entities;

import br.com.denilo.callmanagementsystem.entities.enums.Profile;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "clients")
public class Client extends User {

    @Serial
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "client")
    private List<Called> calleds = new ArrayList<>();

    public Client() {
        super();
        super.addProfile(Profile.CLIENT);
    }

    public Client(Long id, String name, String cpf, String email, String password) {
        super(id, name, cpf, email, password);
        super.addProfile(Profile.CLIENT);
    }

    public List<Called> getCalleds() {
        return calleds;
    }

    public void addCalled(Called called) {
        this.calleds.add(called);
    }
}
