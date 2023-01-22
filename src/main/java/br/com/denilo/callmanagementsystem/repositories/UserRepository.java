package br.com.denilo.callmanagementsystem.repositories;

import br.com.denilo.callmanagementsystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
