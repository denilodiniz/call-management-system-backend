package br.com.denilo.ticketmanagementsystem.services;

import br.com.denilo.ticketmanagementsystem.dtos.technicians.TechnicianDetailsDTO;
import br.com.denilo.ticketmanagementsystem.dtos.technicians.TechnicianSummaryDTO;
import br.com.denilo.ticketmanagementsystem.dtos.technicians.TechnicianUpdateDTO;
import br.com.denilo.ticketmanagementsystem.entities.Client;
import br.com.denilo.ticketmanagementsystem.entities.Technician;
import br.com.denilo.ticketmanagementsystem.repositories.TechnicianRepository;
import br.com.denilo.ticketmanagementsystem.repositories.TicketRepository;
import br.com.denilo.ticketmanagementsystem.repositories.UserRepository;
import br.com.denilo.ticketmanagementsystem.services.converter.TechnicianConverter;
import br.com.denilo.ticketmanagementsystem.services.exceptions.DataIntegrityErrorException;
import br.com.denilo.ticketmanagementsystem.services.exceptions.ResourceNotFoundException;
import br.com.denilo.ticketmanagementsystem.services.util.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechnicianService {

    @Autowired
    TechnicianRepository technicianRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TicketRepository ticketRepository;

    public TechnicianDetailsDTO findById(Long id) {
        return TechnicianConverter.technicianDetailsDTO(technicianRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Technician with ID " + id + " does not exist.")));
    }

    public List<TechnicianSummaryDTO> findAll() {
        return technicianRepository.findAll()
                .stream()
                .map(TechnicianConverter::technicianSummaryDTO)
                .toList();
    }

    public TechnicianUpdateDTO create(TechnicianUpdateDTO technicianUpdateDTO) {
        UserValidation.userValidationForUserExist(technicianUpdateDTO.getCpf(), technicianUpdateDTO.getEmail());
        return TechnicianConverter.technicianUpdateDTO(
                technicianRepository.save(TechnicianConverter.convertToTechnician(technicianUpdateDTO))
        );
    }

    public TechnicianSummaryDTO update(Long id, TechnicianUpdateDTO technicianDTO) {
        technicianDTO.setId(id);
        UserValidation.userValidationForUserUpdate(technicianDTO.getId(), technicianDTO.getCpf(), technicianDTO.getEmail());
        Technician technicianData = TechnicianConverter.convertToTechnicianWithId(technicianDTO);
        Technician technicianUpdate = technicianRepository.findById(technicianDTO.getId()).get();
        Technician updatedTechnician = updateData(technicianData, technicianUpdate);
        technicianRepository.save(updatedTechnician);
        return TechnicianConverter.technicianSummaryDTO(updatedTechnician);
    }

    public void delete(Long id) {
        this.findById(id);
        Optional<Technician> technician = technicianRepository.findById(id);
        if (technician.get().getTicketList().size() > 0) {
            throw new DataIntegrityErrorException("Technician has tickets, it cannot be deleted.");
        }
        technicianRepository.deleteById(id);
    }

    Technician findByIdTechnicianDomain(Long id) {
        return technicianRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Technician with ID " + id + " does not exist."));
    }

    private Technician updateData(Technician technicianData, Technician technicianUpdate) {
        technicianUpdate.setName(technicianData.getName());
        technicianUpdate.setCpf(technicianData.getCpf());
        technicianUpdate.setEmail(technicianData.getEmail());
        technicianUpdate.setPassword(technicianData.getPassword());
        return technicianUpdate;
    }

}