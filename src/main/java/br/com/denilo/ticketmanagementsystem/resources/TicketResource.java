package br.com.denilo.ticketmanagementsystem.resources;

import br.com.denilo.ticketmanagementsystem.dtos.TicketDTO;
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

    @GetMapping
    public ResponseEntity<List<TicketDTO>> findAll() {
        return ResponseEntity.ok().body(ticketService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TicketDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(ticketService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TicketDTO> create(@Valid @RequestBody TicketDTO ticketDTO) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(ticketService.create(ticketDTO).getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

}
