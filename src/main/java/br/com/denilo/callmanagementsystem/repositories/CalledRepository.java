package br.com.denilo.callmanagementsystem.repositories;

import br.com.denilo.callmanagementsystem.entities.Called;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalledRepository extends JpaRepository<Called, Long> {
}
