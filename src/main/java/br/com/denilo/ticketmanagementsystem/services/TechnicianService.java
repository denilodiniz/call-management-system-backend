package br.com.denilo.ticketmanagementsystem.services;

import br.com.denilo.ticketmanagementsystem.dtos.TechnicianDTO;
import br.com.denilo.ticketmanagementsystem.entities.Technician;
import br.com.denilo.ticketmanagementsystem.repositories.TechnicianRepository;
import br.com.denilo.ticketmanagementsystem.repositories.TicketRepository;
import br.com.denilo.ticketmanagementsystem.repositories.UserRepository;
import br.com.denilo.ticketmanagementsystem.services.exceptions.ResourceNotFoundException;
import br.com.denilo.ticketmanagementsystem.services.util.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicianService {

    @Autowired
    TechnicianRepository technicianRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TicketRepository ticketRepository;

    public TechnicianDTO findById(Long id) {
        return toTechnicianDTO(technicianRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Technician with ID " + id + " does not exist.")));
    }

    public List<TechnicianDTO> findAll() {
        return technicianRepository.findAll()
                .stream()
                .map(x -> toTechnicianDTO(x))
                .toList();
    }

    public TechnicianDTO create(TechnicianDTO technicianDTO) {
        UserValidation.userValidationForUserExist(technicianDTO.getCpf(), technicianDTO.getEmail());
        return toTechnicianDTO(technicianRepository.save(convertToUser(technicianDTO)));
    }

    public TechnicianDTO update(Long id, TechnicianDTO technicianDTO) {
        technicianDTO.setId(id);
        UserValidation.userValidationForUserUpdate(technicianDTO.getId(), technicianDTO.getCpf(), technicianDTO.getEmail());
        Technician technicianData = convertToUserWithId(technicianDTO);
        Technician technicianUpdate = technicianRepository.findById(technicianDTO.getId()).get();
        Technician updatedTechnician = updateData(technicianData, technicianUpdate);
        technicianRepository.save(updatedTechnician);
        return toTechnicianDTO(updatedTechnician);
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

    private Technician convertToUserWithId(TechnicianDTO technicianDTO) {
        return new Technician(
                technicianDTO.getId(),
                technicianDTO.getName(),
                technicianDTO.getCpf(),
                technicianDTO.getEmail(),
                technicianDTO.getPassword()
        );
    }

    private Technician updateData(Technician technicianData, Technician technicianUdpate) {
        technicianUdpate.setName(technicianData.getName());
        technicianUdpate.setCpf(technicianData.getCpf());
        technicianUdpate.setEmail(technicianData.getEmail());
        technicianUdpate.setPassword(technicianData.getPassword());
        return technicianUdpate;
    }

}
