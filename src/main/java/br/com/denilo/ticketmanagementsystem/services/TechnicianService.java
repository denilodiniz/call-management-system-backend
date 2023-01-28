package br.com.denilo.ticketmanagementsystem.services;

import br.com.denilo.ticketmanagementsystem.dtos.TechnicianDTO;
import br.com.denilo.ticketmanagementsystem.entities.Technician;
import br.com.denilo.ticketmanagementsystem.repositories.TechnicianRepository;
import br.com.denilo.ticketmanagementsystem.repositories.TicketRepository;
import br.com.denilo.ticketmanagementsystem.repositories.UserRepository;
import br.com.denilo.ticketmanagementsystem.services.exceptions.ResourceNotFoundException;
import br.com.denilo.ticketmanagementsystem.services.exceptions.UserAlreadyExistsException;
import br.com.denilo.ticketmanagementsystem.util.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TechnicianService {

    @Autowired
    TechnicianRepository technicianRepository;

    @Autowired
    private UserRepository userRepository;

    public TechnicianDTO findById(Long id) {
        return toTechnicianDTO(technicianRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Technician with ID " + id + " does not exist.")));
    }

    public List<TechnicianDTO> findAll() {
        return technicianRepository.findAll()
                .stream().map(x -> toTechnicianDTO(x)).toList();
    }

    public Technician create(TechnicianDTO technicianDTO) {
//        UserValidation.requiredField(
//                technicianDTO.getName(),
//                technicianDTO.getCpf(),
//                technicianDTO.getEmail(),
//                technicianDTO.getPassword()
//        );

        UserValidation.userValidation(technicianDTO.getCpf(), technicianDTO.getEmail());

        return technicianRepository.save(convertToUser(technicianDTO));
    }

    private TechnicianDTO toTechnicianDTO(Technician technician) {
        TechnicianDTO technicianDTO = new TechnicianDTO();
        technicianDTO.setName(technician.getName());
        technicianDTO.setEmail(technician.getEmail());
        technicianDTO.setCpf(technician.getCpf());
        technicianDTO.setCreationDate(technician.getCreationDate());
        return technicianDTO;
    }

    private Technician convertToUser(TechnicianDTO technicianDTO) {
        return new Technician(
                technicianDTO.getName(),
                technicianDTO.getCpf(),
                technicianDTO.getEmail(),
                technicianDTO.getPassword()
        );
    }

}
