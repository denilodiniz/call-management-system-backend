package br.com.denilo.ticketmanagementsystem.repositories;

import br.com.denilo.ticketmanagementsystem.entities.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Long> {
}
