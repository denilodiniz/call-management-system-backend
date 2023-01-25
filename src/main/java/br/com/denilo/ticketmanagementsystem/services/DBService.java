package br.com.denilo.ticketmanagementsystem.services;

import br.com.denilo.ticketmanagementsystem.entities.Ticket;
import br.com.denilo.ticketmanagementsystem.entities.Client;
import br.com.denilo.ticketmanagementsystem.entities.Technician;
import br.com.denilo.ticketmanagementsystem.entities.enums.Priority;
import br.com.denilo.ticketmanagementsystem.entities.enums.Profile;
import br.com.denilo.ticketmanagementsystem.repositories.TicketRepository;
import br.com.denilo.ticketmanagementsystem.repositories.ClientRepository;
import br.com.denilo.ticketmanagementsystem.repositories.TechnicianRepository;
import br.com.denilo.ticketmanagementsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TechnicianRepository technicianRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public void initializeDB() {
        Client client = new Client(
                "Linus Torvalds", "70511744013", "linus@email.com", "123"
        );

        Technician technician = new Technician(
                "Valdir Cezar", "76045777093", "valdir@email.com", "123"
        );
        technician.addProfile(Profile.ADMIN);

        Ticket ticket1 = new Ticket(
                "Chamado 01", "Primeiro chamado.", Priority.MEDIUM, client, technician
        );
        /*Ticket ticket2 = new Ticket(
                "Chamado 02", "Segundo chamado.", Priority.MEDIUM, clientRepository.findById(1L).get(), technicianRepository.findById(2L).get()
        );
        Ticket ticket3 = new Ticket(
                "Chamado 03", "Terceiro chamado.", Priority.LOW, clientRepository.findById(1L).get(), technicianRepository.findById(2L).get()
        );
        Ticket ticket4 = new Ticket(
                "Chamado 04", "Quarto chamado.", Priority.HIGH, clientRepository.findById(1L).get(), technicianRepository.findById(2L).get()
        );*/

        clientRepository.save(client);
        technicianRepository.save(technician);
        ticketRepository.save(ticket1);


        /*ticketRepository.saveAll(Arrays.asList(
                ticket2, ticket3, ticket4
        ));*/
    }

}
