package br.com.denilo.ticketmanagementsystem.repositories;

import br.com.denilo.ticketmanagementsystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
