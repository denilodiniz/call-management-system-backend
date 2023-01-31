package br.com.denilo.ticketmanagementsystem.entities;

import br.com.denilo.ticketmanagementsystem.entities.enums.Profile;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity(name = "users")
@Table(name = "users")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    protected Long id;

    @NotNull(message = "The NAME field is required.")
    @Column(name = "name", nullable = false)
    protected String name;

    @NotNull(message = "The CPF field is required.")
    @Size(min = 11, max = 11)
    @Column(name = "cpf", unique = true, nullable = false)
    protected String cpf;

    @NotNull(message = "The E-MAIL field is required.")
    @Email
    @Column(name = "email", unique = true, nullable = false)
    protected String email;

    @NotNull(message = "The PASSWORD field is required.")
    @Column(name = "password", nullable = false)
    protected String password;

    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    @Column(name = "creation_date", nullable = false)
    protected LocalDate creationDate;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "profiles")
    protected Set<Profile> profiles = new java.util.LinkedHashSet<>();

    public User() {
        this.profiles.add(Profile.CLIENT);
    }

    public User(String name, String cpf, String email, String password) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
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
        this.profiles.add(profile);
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
