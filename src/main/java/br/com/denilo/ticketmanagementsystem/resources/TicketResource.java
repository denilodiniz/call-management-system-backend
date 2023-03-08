package br.com.denilo.ticketmanagementsystem.resources;

import br.com.denilo.ticketmanagementsystem.dtos.tickets.TicketCreateDTO;
import br.com.denilo.ticketmanagementsystem.dtos.tickets.TicketDetailsDTO;
import br.com.denilo.ticketmanagementsystem.dtos.tickets.TicketSummaryDTO;
import br.com.denilo.ticketmanagementsystem.dtos.tickets.TicketUpdateDTO;
import br.com.denilo.ticketmanagementsystem.repositories.TicketRepository;
import br.com.denilo.ticketmanagementsystem.services.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "tickets")
public class TicketResource {

    @Autowired
    TicketService ticketService;
    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping
    public ResponseEntity<List<TicketSummaryDTO>> findAll() {
        return ResponseEntity.ok().body(ticketService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TicketDetailsDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(ticketService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TicketDetailsDTO> create(@Valid @RequestBody TicketCreateDTO ticketDTO) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(ticketService.create(ticketDTO).getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TicketDetailsDTO> update(@PathVariable Long id, @Valid @RequestBody TicketUpdateDTO ticketDTO) {
        TicketDetailsDTO ticketUpdated = ticketService.update(id, ticketDTO);
        return ResponseEntity.ok().body(ticketUpdated);
    }

}
