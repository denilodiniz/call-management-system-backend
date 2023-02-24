package br.com.denilo.ticketmanagementsystem.resources;

import br.com.denilo.ticketmanagementsystem.dtos.clients.ClientUpdateDTO;
import br.com.denilo.ticketmanagementsystem.dtos.clients.ClientDTO;
import br.com.denilo.ticketmanagementsystem.dtos.clients.ClientDetailsDTO;
import br.com.denilo.ticketmanagementsystem.dtos.clients.ClientSummaryDTO;
import br.com.denilo.ticketmanagementsystem.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientSummaryDTO>> findAll() {
        return ResponseEntity.ok().body(clientService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDetailsDTO> findById(@PathVariable Long id) {
        ClientDetailsDTO clientDetailsDTO = clientService.findById(id);
        return ResponseEntity.ok().body(clientDetailsDTO);
    }

    @PostMapping
    public ResponseEntity<ClientUpdateDTO> create(@Valid @RequestBody ClientUpdateDTO clientDTO) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(clientService.create(clientDTO).getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientSummaryDTO> update(@PathVariable Long id, @Valid @RequestBody ClientUpdateDTO clientDTO) {
        return ResponseEntity.ok().body(clientService.update(id, clientDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
