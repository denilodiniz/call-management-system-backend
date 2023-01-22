package br.com.denilo.callmanagementsystem.repositories;

import br.com.denilo.callmanagementsystem.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
