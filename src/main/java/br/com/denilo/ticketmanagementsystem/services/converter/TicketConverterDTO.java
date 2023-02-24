package br.com.denilo.ticketmanagementsystem.services.converter;

import br.com.denilo.ticketmanagementsystem.dtos.tickets.TicketSummaryDTO;
import br.com.denilo.ticketmanagementsystem.entities.Ticket;


public class TicketConverterDTO {

    public static TicketSummaryDTO ticketSummaryDTO(Ticket ticket) {
        TicketSummaryDTO ticketSummaryDTO = new TicketSummaryDTO();
        ticketSummaryDTO.setCreationDate(ticket.getCreationDate());
        ticketSummaryDTO.setTitle(ticket.getTitle());
        ticketSummaryDTO.setPriority(ticket.getPriority());
        ticketSummaryDTO.setStatus(ticket.getStatus());
        return ticketSummaryDTO;
    }

}
