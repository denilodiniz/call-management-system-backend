package br.com.denilo.ticketmanagementsystem.resources;

import br.com.denilo.ticketmanagementsystem.dtos.TechnicianDTO;
import br.com.denilo.ticketmanagementsystem.services.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/technicians")
public class TechnicianResource {

    @Autowired
    private TechnicianService technicianService;

    @GetMapping("/{id}")
    public ResponseEntity<TechnicianDTO> findById(@PathVariable Long id) {
        TechnicianDTO technicianDTO = technicianService.findById(id);
        return ResponseEntity.ok().body(technicianDTO);
    }

}
