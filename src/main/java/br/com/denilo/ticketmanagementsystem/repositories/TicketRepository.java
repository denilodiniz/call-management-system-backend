package br.com.denilo.ticketmanagementsystem.repositories;

import br.com.denilo.ticketmanagementsystem.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query(value = "SELECT * FROM `tickets` WHERE id_client = :id", nativeQuery = true)
    List<Ticket> findAllTicketsWithClientId(Long id);

}
