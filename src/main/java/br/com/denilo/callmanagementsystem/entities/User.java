package br.com.denilo.callmanagementsystem.entities;

import br.com.denilo.callmanagementsystem.entities.enums.Profile;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String name;

    @Column(unique = true)
    protected String cpf;
    @Column(unique = true)
    protected String email;

    protected String password;

    //@JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate creationDate;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "profiles")
    protected Set<Profile> profiles = new java.util.LinkedHashSet<>();

    public User() {
        this.creationDate = LocalDate.now();
        this.profiles.add(Profile.CLIENT);
    }

    public User(String name, String cpf, String email, String password) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.creationDate = LocalDate.now();
        this.profiles.add(Profile.CLIENT);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addProfile(Profile profile) {
        this.profiles.add(Profile.toEnum(profile.getCode()));
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Set<Profile> getProfiles() {
        return profiles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(cpf, user.cpf) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf, email);
    }
}
