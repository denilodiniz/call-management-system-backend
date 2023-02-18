package br.com.denilo.ticketmanagementsystem.services.converter;

import br.com.denilo.ticketmanagementsystem.dtos.ClientSummaryDTO;
import br.com.denilo.ticketmanagementsystem.entities.Client;

public class ClientConverterDTO {

    public static ClientSummaryDTO clientSummaryDTO (Client client) {
        ClientSummaryDTO clientSummaryDTO = new ClientSummaryDTO();
        clientSummaryDTO.setName(client.getName());
        clientSummaryDTO.setCpf(client.getCpf());
        clientSummaryDTO.setEmail(client.getEmail());
        clientSummaryDTO.setCreationDate(client.getCreationDate());
        return clientSummaryDTO;
    }

}
