package br.com.denilo.ticketmanagementsystem.repositories;

import br.com.denilo.ticketmanagementsystem.dtos.clients.ClientDetailsDTO;
import br.com.denilo.ticketmanagementsystem.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
