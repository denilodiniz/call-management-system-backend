package br.com.denilo.ticketmanagementsystem.services.util;

import br.com.denilo.ticketmanagementsystem.services.exceptions.UnauthorizedUserAccessException;

public class TicketValidation {

    public static void technicianIdValidation(Long idTechnicianDomain, Long idTechnicianDTO) {
        if (idTechnicianDomain != idTechnicianDTO) {
            throw new UnauthorizedUserAccessException("Technician is not authorized to change this ticket.");
        }
    }

}
