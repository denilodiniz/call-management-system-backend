package br.com.denilo.ticketmanagementsystem.services;

import br.com.denilo.ticketmanagementsystem.entities.Client;
import br.com.denilo.ticketmanagementsystem.entities.Technician;
import br.com.denilo.ticketmanagementsystem.entities.Ticket;
import br.com.denilo.ticketmanagementsystem.entities.User;
import br.com.denilo.ticketmanagementsystem.entities.enums.Priority;
import br.com.denilo.ticketmanagementsystem.entities.enums.Profile;
import br.com.denilo.ticketmanagementsystem.repositories.TicketRepository;
import br.com.denilo.ticketmanagementsystem.repositories.ClientRepository;
import br.com.denilo.ticketmanagementsystem.repositories.TechnicianRepository;
import br.com.denilo.ticketmanagementsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

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

    @Autowired
    private BCryptPasswordEncoder encoder;

    public void initializeDB() {

        Client client1 = new Client(
                "Linus Torvalds", "70511744013", "linus@email.com", encoder.encode("123")
        );

        Client client2 = new Client(
                "Igor", "67541338052", "igor@email.com", encoder.encode("123")
        );
//
        Technician technician1 = new Technician(
                "Valdir Cezar", "76045777093", "valdir@email.com", encoder.encode("123")
        );
        technician1.addProfile(Profile.ADMIN);
////
        Technician technician2 = new Technician(
                "Priscyla", "23502691088", "priscyla@email.com", encoder.encode("123")
        );
//
        Ticket ticket1 = new Ticket(
                "Chamado 01", "Primeiro chamado.", Priority.MEDIUM, client1, technician1
        );

        Ticket ticket2 = new Ticket(
                "Chamado 02", "Segundo chamado.", Priority.HIGH, client1, technician2
        );
        Ticket ticket3 = new Ticket(
                "Chamado 03", "Terceiro chamado.", Priority.LOW, client2, technician1
        );

        userRepository.saveAll(Arrays.asList(client1, client2));
        userRepository.saveAll(Arrays.asList(technician1, technician2));

        ticketRepository.saveAll(Arrays.asList(
                ticket1, ticket2, ticket3
        ));
    }

}
