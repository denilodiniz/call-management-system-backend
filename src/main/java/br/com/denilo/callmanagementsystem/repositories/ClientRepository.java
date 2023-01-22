package br.com.denilo.callmanagementsystem.repositories;

import br.com.denilo.callmanagementsystem.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
