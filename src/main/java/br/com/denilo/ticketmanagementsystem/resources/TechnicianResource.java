package br.com.denilo.ticketmanagementsystem.resources;

import br.com.denilo.ticketmanagementsystem.dtos.technicians.TechnicianDetailsDTO;
import br.com.denilo.ticketmanagementsystem.dtos.technicians.TechnicianSummaryDTO;
import br.com.denilo.ticketmanagementsystem.dtos.technicians.TechnicianUpdateDTO;
import br.com.denilo.ticketmanagementsystem.services.TechnicianService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/technicians")
public class TechnicianResource {

    @Autowired
    private TechnicianService technicianService;

    @GetMapping
    public ResponseEntity<List<TechnicianSummaryDTO>> findAll() {
        return ResponseEntity.ok().body(technicianService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TechnicianDetailsDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(technicianService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TechnicianUpdateDTO> create(@Valid @RequestBody TechnicianUpdateDTO technicianDTO) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(technicianService.create(technicianDTO).getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TechnicianSummaryDTO> update(@PathVariable Long id, @Valid @RequestBody TechnicianUpdateDTO technicianDTO) {
        return ResponseEntity.ok().body(technicianService.update(id, technicianDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<TechnicianUpdateDTO> delete(@PathVariable Long id) {
        technicianService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
