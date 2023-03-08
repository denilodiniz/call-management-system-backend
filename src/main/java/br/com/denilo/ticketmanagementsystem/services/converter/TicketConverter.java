package br.com.denilo.ticketmanagementsystem.services.converter;

import br.com.denilo.ticketmanagementsystem.dtos.tickets.TicketCreateDTO;
import br.com.denilo.ticketmanagementsystem.dtos.tickets.TicketDetailsDTO;
import br.com.denilo.ticketmanagementsystem.dtos.tickets.TicketSummaryDTO;
import br.com.denilo.ticketmanagementsystem.dtos.tickets.TicketUpdateDTO;
import br.com.denilo.ticketmanagementsystem.entities.Client;
import br.com.denilo.ticketmanagementsystem.entities.Technician;
import br.com.denilo.ticketmanagementsystem.entities.Ticket;


public class TicketConverter {

    public static TicketSummaryDTO ticketSummaryDTO(Ticket ticket) {
        TicketSummaryDTO ticketSummaryDTO = new TicketSummaryDTO();
        ticketSummaryDTO.setCreationDate(ticket.getCreationDate());
        ticketSummaryDTO.setTitle(ticket.getTitle());
        ticketSummaryDTO.setPriority(ticket.getPriority());
        ticketSummaryDTO.setStatus(ticket.getStatus());
        return ticketSummaryDTO;
    }

    public static TicketDetailsDTO ticketDetailsDTO(Ticket ticket) {
        return new TicketDetailsDTO(
                ticket.getId(),
                ticket.getCreationDate(),
                ticket.getClosedDate(),
                ticket.getTitle(),
                ticket.getObservations(),
                ticket.getStatus(),
                ticket.getPriority(),
                ticket.getClient().getId(),
                ticket.getTechnician().getId(),
                ticket.getClient().getName(),
                ticket.getTechnician().getName()
        );
    }

    public static Ticket convertToTicked(TicketUpdateDTO ticketDTO, Client client, Technician technician) {
        return new Ticket(
                ticketDTO.getTitle(),
                ticketDTO.getObservations(),
                ticketDTO.getPriority(),
                client,
                technician
        );
    }

}
