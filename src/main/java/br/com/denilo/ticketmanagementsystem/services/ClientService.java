package br.com.denilo.ticketmanagementsystem.services;

import br.com.denilo.ticketmanagementsystem.dtos.clients.ClientUpdateDTO;
import br.com.denilo.ticketmanagementsystem.dtos.clients.ClientDetailsDTO;
import br.com.denilo.ticketmanagementsystem.dtos.clients.ClientSummaryDTO;
import br.com.denilo.ticketmanagementsystem.entities.Client;
import br.com.denilo.ticketmanagementsystem.repositories.ClientRepository;
import br.com.denilo.ticketmanagementsystem.repositories.TicketRepository;
import br.com.denilo.ticketmanagementsystem.services.converter.ClientConverter;
import br.com.denilo.ticketmanagementsystem.services.exceptions.DataIntegrityErrorException;
import br.com.denilo.ticketmanagementsystem.services.exceptions.ResourceNotFoundException;
import br.com.denilo.ticketmanagementsystem.services.util.UserValidation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public ClientDetailsDTO findById(Long id) {
        return ClientConverter.clientDetailsDTO(clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client with ID " + id + " does not exist.")));
    }

    public List<ClientSummaryDTO> findAll() {
        return clientRepository.findAll()
                .stream()
                .map(ClientConverter::clientSummaryDTO)
                .toList();
    }

    public ClientUpdateDTO create(@Valid ClientUpdateDTO clientUpdateDTO) {
        UserValidation.userValidationForUserExist(clientUpdateDTO.getCpf(), clientUpdateDTO.getEmail());
        return ClientConverter.clientCreateDTO(
                clientRepository.save(
                        ClientConverter.convertToClient(clientUpdateDTO)
                )
        );
    }

    public ClientSummaryDTO update(Long id, ClientUpdateDTO clientDTO) {
        clientDTO.setId(id);
        UserValidation.userValidationForUserUpdate(clientDTO.getId(), clientDTO.getCpf(), clientDTO.getEmail());
        Client clientData = ClientConverter.convertToClientWithId(clientDTO);
        Client clientUpdate = clientRepository.findById(clientDTO.getId()).get();
        Client updatedClient = updateData(clientData, clientUpdate);
        clientRepository.save(updatedClient);
        return ClientConverter.clientSummaryDTO(updatedClient);
    }

    public void delete(Long id) {
        this.findById(id);
        Optional<Client> client = clientRepository.findById(id);
        if (client.get().getTicketList().size() > 0) {
            throw new DataIntegrityErrorException("Client has tickets, it cannot be deleted.");
        }
        clientRepository.deleteById(id);
    }

    private Client updateData(Client clientData, Client clientUpdate) {
        clientUpdate.setName(clientData.getName());
        clientUpdate.setCpf(clientData.getCpf());
        clientUpdate.setEmail(clientData.getEmail());
        clientUpdate.setPassword(clientData.getPassword());
        return clientUpdate;
    }

}
