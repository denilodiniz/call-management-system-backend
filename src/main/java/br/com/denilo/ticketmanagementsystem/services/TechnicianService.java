package br.com.denilo.ticketmanagementsystem.services;

import br.com.denilo.ticketmanagementsystem.dtos.TechnicianDTO;
import br.com.denilo.ticketmanagementsystem.entities.Technician;
import br.com.denilo.ticketmanagementsystem.repositories.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TechnicianService {

    @Autowired
    TechnicianRepository technicianRepository;

    public TechnicianDTO findById(Long id) {
        Optional<Technician> technician = technicianRepository.findById(id);
        if (technician.get() != null) {
            return toTechnicianDTO(technician.get());
        }
        else {
            throw new IllegalArgumentException("Technician not found.");
        }
    }

    private TechnicianDTO toTechnicianDTO(Technician technician) {
        TechnicianDTO technicianDTO = new TechnicianDTO();
        technicianDTO.setName(technician.getName());
        technicianDTO.setEmail(technician.getEmail());
        technicianDTO.setCpf(technician.getCpf());
        technicianDTO.setCreationDate(technician.getCreationDate());
        technicianDTO.setProfiles(technician.getProfiles());
        technicianDTO.setTicketList(technician.getTickets());
        return technicianDTO;
    }

}
