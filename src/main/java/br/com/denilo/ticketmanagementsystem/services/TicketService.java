package br.com.denilo.ticketmanagementsystem.services;

import br.com.denilo.ticketmanagementsystem.dtos.tickets.TicketCreateDTO;
import br.com.denilo.ticketmanagementsystem.dtos.tickets.TicketDetailsDTO;
import br.com.denilo.ticketmanagementsystem.dtos.tickets.TicketSummaryDTO;
import br.com.denilo.ticketmanagementsystem.dtos.tickets.TicketUpdateDTO;
import br.com.denilo.ticketmanagementsystem.entities.Client;
import br.com.denilo.ticketmanagementsystem.entities.Technician;
import br.com.denilo.ticketmanagementsystem.entities.Ticket;
import br.com.denilo.ticketmanagementsystem.entities.enums.Status;
import br.com.denilo.ticketmanagementsystem.repositories.ClientRepository;
import br.com.denilo.ticketmanagementsystem.repositories.TechnicianRepository;
import br.com.denilo.ticketmanagementsystem.repositories.TicketRepository;
import br.com.denilo.ticketmanagementsystem.services.converter.TicketConverter;
import br.com.denilo.ticketmanagementsystem.services.exceptions.ResourceNotFoundException;
import br.com.denilo.ticketmanagementsystem.services.util.TicketValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    private ClientService clientService;
    @Autowired
    private TechnicianService technicianService;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private TechnicianRepository technicianRepository;

    public TicketDetailsDTO findById(Long id) {
        return TicketConverter.ticketDetailsDTO(ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket with ID " + id + " does not exist.")));
    }

    public List<TicketSummaryDTO> findAll() {
        return ticketRepository.findAll()
                .stream()
                .map(TicketConverter::ticketSummaryDTO)
                .toList();
    }

    public TicketDetailsDTO create(TicketCreateDTO ticketCreateDTO) {

        Client client = clientService.findByIdClientDomain(ticketCreateDTO.getIdClient());
        Technician technician = technicianService.findByIdTechnicianDomain(ticketCreateDTO.getIdTechnician());

        Ticket ticket = new Ticket(
                ticketCreateDTO.getTitle(),
                ticketCreateDTO.getObservations(),
                ticketCreateDTO.getPriority(),
                client,
                technician
        );

        return TicketConverter.ticketDetailsDTO(ticketRepository.save(ticket));
    }

    public TicketDetailsDTO update(Long id, TicketUpdateDTO ticketDTO) {

        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client with ID " + id + " does not exist."));

        Client client = clientService.findByIdClientDomain(ticketDTO.getIdClient());
        Technician technician = technicianService.findByIdTechnicianDomain(ticketDTO.getIdTechnician());

        TicketValidation.technicianIdValidation(ticket.getTechnician().getId(), ticketDTO.getIdTechnician());

        if (ticketDTO.getStatus() == Status.CLOSED) {
            ticketDTO.setClosedDate(LocalDateTime.now());
        }

        Ticket ticketUpdated = updateData(ticket, ticketDTO);
        return TicketConverter.ticketDetailsDTO(ticketRepository.save(ticketUpdated));
    }

    private Ticket updateData(Ticket ticket, TicketUpdateDTO ticketDTO) {
        ticket.setClosedDate(ticketDTO.getClosedDate());
        ticket.setTitle(ticketDTO.getTitle());
        ticket.setObservations(ticketDTO.getObservations());
        ticket.setStatus(ticketDTO.getStatus());
        ticket.setPriority(ticketDTO.getPriority());
        return ticket;
    }

}
