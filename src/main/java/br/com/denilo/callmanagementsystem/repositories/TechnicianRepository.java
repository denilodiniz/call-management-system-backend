package br.com.denilo.callmanagementsystem.repositories;

import br.com.denilo.callmanagementsystem.entities.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Long> {
}
