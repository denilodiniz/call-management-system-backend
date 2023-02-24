package br.com.denilo.ticketmanagementsystem.services.converter;

import br.com.denilo.ticketmanagementsystem.dtos.clients.ClientUpdateDTO;
import br.com.denilo.ticketmanagementsystem.dtos.clients.ClientDetailsDTO;
import br.com.denilo.ticketmanagementsystem.dtos.clients.ClientSummaryDTO;
import br.com.denilo.ticketmanagementsystem.dtos.tickets.TicketSummaryDTO;
import br.com.denilo.ticketmanagementsystem.entities.Client;

import java.util.List;

public class ClientConverter {

    public static ClientSummaryDTO clientSummaryDTO(Client client) {
        ClientSummaryDTO clientSummaryDTO = new ClientSummaryDTO();
        clientSummaryDTO.setName(client.getName());
        clientSummaryDTO.setCpf(client.getCpf());
        clientSummaryDTO.setEmail(client.getEmail());
        clientSummaryDTO.setCreationDate(client.getCreationDate());
        return clientSummaryDTO;
    }

    public static ClientUpdateDTO clientCreateDTO(Client client) {
        ClientUpdateDTO clientUpdateDTO = new ClientUpdateDTO();
        clientUpdateDTO.setId(client.getId());
        clientUpdateDTO.setName(client.getName());
        clientUpdateDTO.setCpf(client.getCpf());
        clientUpdateDTO.setEmail(client.getEmail());
        clientUpdateDTO.setPassword(client.getPassword());
        return clientUpdateDTO;
    }

    public static ClientDetailsDTO clientDetailsDTO(Client client) {
        ClientDetailsDTO clientDetailsDTO = new ClientDetailsDTO();
        clientDetailsDTO.setName(client.getName());
        clientDetailsDTO.setCpf(client.getCpf());
        clientDetailsDTO.setEmail(client.getEmail());
        clientDetailsDTO.setCreationDate(client.getCreationDate());

        List<TicketSummaryDTO> ticketSummaryDTOList =
                client.getTicketList()
                        .stream()
                        .map(x -> TicketConverterDTO.ticketSummaryDTO(x))
                        .toList();
        clientDetailsDTO.setTicketSummaryDTOList(ticketSummaryDTOList);

        return clientDetailsDTO;
    }

    public static Client convertToClient(ClientUpdateDTO clientDTO) {
        return new Client(
                clientDTO.getName(),
                clientDTO.getCpf(),
                clientDTO.getEmail(),
                clientDTO.getPassword()
        );
    }

    public static Client convertToClientWithId(ClientUpdateDTO clientDTO) {
        return new Client(
                clientDTO.getId(),
                clientDTO.getName(),
                clientDTO.getCpf(),
                clientDTO.getEmail(),
                clientDTO.getPassword()
        );
    }

}
