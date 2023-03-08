package br.com.denilo.ticketmanagementsystem.services.converter;

import br.com.denilo.ticketmanagementsystem.dtos.technicians.TechnicianDetailsDTO;
import br.com.denilo.ticketmanagementsystem.dtos.technicians.TechnicianSummaryDTO;
import br.com.denilo.ticketmanagementsystem.dtos.technicians.TechnicianUpdateDTO;
import br.com.denilo.ticketmanagementsystem.dtos.tickets.TicketSummaryDTO;
import br.com.denilo.ticketmanagementsystem.entities.Technician;

import java.util.List;

public class TechnicianConverter {

    public static TechnicianSummaryDTO technicianSummaryDTO(Technician technician) {
        TechnicianSummaryDTO technicianSummaryDTO = new TechnicianSummaryDTO();
        technicianSummaryDTO.setName(technician.getName());
        technicianSummaryDTO.setCpf(technician.getCpf());
        technicianSummaryDTO.setEmail(technician.getEmail());
        technicianSummaryDTO.setCreationDate(technician.getCreationDate());
        return technicianSummaryDTO;
    }

    public static TechnicianUpdateDTO technicianUpdateDTO(Technician technician) {
        TechnicianUpdateDTO technicianUpdateDTO = new TechnicianUpdateDTO();
        technicianUpdateDTO.setId(technician.getId());
        technicianUpdateDTO.setName(technician.getName());
        technicianUpdateDTO.setCpf(technician.getCpf());
        technicianUpdateDTO.setEmail(technician.getEmail());
        technicianUpdateDTO.setPassword(technician.getPassword());
        return technicianUpdateDTO;
    }

    public static TechnicianDetailsDTO technicianDetailsDTO(Technician technician) {
        TechnicianDetailsDTO technicianDetailsDTO = new TechnicianDetailsDTO();
        technicianDetailsDTO.setName(technician.getName());
        technicianDetailsDTO.setCpf(technician.getCpf());
        technicianDetailsDTO.setEmail(technician.getEmail());
        technicianDetailsDTO.setCreationDate(technician.getCreationDate());

        List<TicketSummaryDTO> ticketSummaryDTOList =
                technician.getTicketList()
                        .stream()
                        .map(TicketConverter::ticketSummaryDTO)
                        .toList();
        technicianDetailsDTO.setTicketSummaryDTOList(ticketSummaryDTOList);

        return technicianDetailsDTO;
    }

    public static Technician convertToTechnician(TechnicianUpdateDTO technicianDTO) {
        return new Technician(
                technicianDTO.getName(),
                technicianDTO.getCpf(),
                technicianDTO.getEmail(),
                technicianDTO.getPassword()
        );
    }

    public static Technician convertToTechnicianWithId(TechnicianUpdateDTO technicianDTO) {
        return new Technician(
                technicianDTO.getId(),
                technicianDTO.getName(),
                technicianDTO.getCpf(),
                technicianDTO.getEmail(),
                technicianDTO.getPassword()
        );
    }

}
