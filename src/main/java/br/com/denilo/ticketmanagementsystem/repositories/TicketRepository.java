package br.com.denilo.ticketmanagementsystem.repositories;

import br.com.denilo.ticketmanagementsystem.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
